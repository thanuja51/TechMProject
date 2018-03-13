package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Wrappers extends Common{

	public static Properties prop;

	public boolean isFileExist1(String filePath, String countryCode, String fileType, String sourceSystem) throws Exception {

		File f = new File(filePath);
		File[] listOfFiles = f.listFiles();
		String fileName = null;
		boolean flag = false;
		int availableFiles = 0;
		if (listOfFiles.length == 0) {
			throw new Exception("Given directory/folder is empty - "+filePath);
		} else if (listOfFiles.length >= 1) {

			for (int i = 0; i < listOfFiles.length; i++) {
				fileName = getFileName(getFileAbsolutePath(listOfFiles[i])).toLowerCase();
				if (fileName.contains(fileType.toLowerCase()) && fileName.contains(sourceSystem.toLowerCase()) && fileName.contains(countryCode.toLowerCase()))
					availableFiles++;
			}
		}
		return flag;
	}


	public boolean isFileExist(String filePath, String fileType, String sourceSystem) throws Exception {

		File f = new File(filePath);
		File[] listOfFiles = f.listFiles();
		String fileName = null;
		boolean flag = false;
		int availableFiles = 0;
		if (listOfFiles.length == 0) {
			throw new Exception("Given directory/folder is empty - "+filePath);
		} else if (listOfFiles.length >= 1) {

			for (int i = 0; i < listOfFiles.length; i++) {
				fileName = getFileName(getFileAbsolutePath(listOfFiles[i]));
				String countryCodeCheck = fileName.substring((fileType.length()), (fileType.length()+2));
				if (fileName.contains(fileType) && fileName.contains(sourceSystem) && getCountryCodeList().contains(countryCodeCheck))
					availableFiles++;
			}
			if(availableFiles>0){
				flag = true;
			}
		}
		return flag;
	}


	public void verifyFilepath(String location, String filePath) throws Exception {

		File file1 = new File(filePath);
		if (!file1.exists()) {
			throw new Exception("Error: "+location+" - "+filePath+" path does not exist.");
		} 
	}


	public boolean isFileEmpty(File file) throws Exception {

		boolean flag = true;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			if (br.readLine() == null) {
				flag = false;
			}
		} catch (IOException e) {
			throw new Exception("Error reading transaction file - "+getFileName(getFileAbsolutePath(file)));
		}
		return flag;
	}



	public String getFileAbsolutePath(File file) throws Exception {
		String path = null;
		try {
			if (file.exists())
				path = file.getAbsolutePath();
		} catch (Exception e) {
			throw new Exception("Unable to get avsolute path of given file");
		}
		return path;
	}


	public String getFileName(String absolutePath) {
		String fileBaseName = FilenameUtils.getBaseName(absolutePath);
		return fileBaseName;
	}


	public String getFileFormat(String absolutePath) {
		String fileFormat = FilenameUtils.getExtension(absolutePath);
		return fileFormat;
	}


	public File[] getAllFiles(String fileLocation) {
		File f = new File(fileLocation);
		File[] listOfFiles = f.listFiles();
		return listOfFiles;
	}


	public boolean isDuplicateFile(File[] fileList, String countryCode, String fileType, String sourceSystem) throws Exception {
		String checkString = fileType + countryCode + sourceSystem;
		int counter = 0;
		String fileName = null;
		boolean flag = false;
		for (int i = 0; i < fileList.length; i++) {
			fileName = getFileName(getFileAbsolutePath(fileList[i]));
			if (fileName.contains(checkString)) {
				counter++;
				if (counter > 1)
					flag = true;
			}
		}
		return flag;
	}


	public List<String> readNotepad(File file, String charSet) throws IOException {

		InputStreamReader reader = null;
		BufferedReader bufferedReader = null;
		List<String> lines = new ArrayList<String>();
		try {
			reader = new InputStreamReader(new FileInputStream(file), charSet);
			bufferedReader = new BufferedReader(reader);
			String temp;
			while ((temp = bufferedReader.readLine()) != null) {
				lines.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bufferedReader.close();
		reader.close();	
		return lines;
	}


	public List<String> readSpecificSegment(List<String> fileContent, String segHeader) {

		List<String> segLines = new ArrayList<String>();

		for (int i = 0; i < fileContent.size(); i++) {

			if (fileContent.get(i).startsWith(segHeader)) {

				segLines.add(fileContent.get(i));

			}
		}
		return segLines;
	}

	public int getStringLen(String val) {

		return val.length();
	}

	public boolean verifyDecimalFormat(String val) {

		int count = 0;
		boolean flag = false;
		for (int i = 0; i < val.length(); i++) {
			if (val.charAt(i) == '.') {
				count++;
			}
		}
		if (count == 1) {
			flag = true;
		} 
		return flag;
	}

	public boolean verifyNegativeNumber(String val) {
		int count = 0;
		Boolean value = false;
		for (int i = 0; i < val.length(); i++) {
			if (val.charAt(i) == '-') {
				count++;
			}
		}
		if (count == 1 && val.charAt(0) == '-') {
			value = true;
		} 
		return value;
	}

	public void loadPropFile(String propFilePath) {

		try {
			prop = new Properties();
			InputStream inStream = getClass().getClassLoader().getResourceAsStream(propFilePath);

			prop.load(inStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getProperty(String key) {
		return prop.getProperty(key);

	}

	public void flushProp() {
		prop = null;
	}

	public int getStartIndex(String filedName, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap) {
		String val = reqMap.get(filedName).get("StartPosition");
		int val1 = Integer.parseInt(val);
		return val1 - 1;
	}

	public int getEndIndex(String filedName, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap) {
		String val1 = reqMap.get(filedName).get("StartPosition");
		int val11 = Integer.parseInt(val1);
		String val2 = reqMap.get(filedName).get("Size");
		int val21 = Integer.parseInt(val2);
		int val = val11 + val21 - 1;
		return val;
	}

	public String getValueOrFormat(String filedName, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap) {
		String val = reqMap.get(filedName).get("Expected");
		return val;
	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> cloneMap(
			LinkedHashMap<String, LinkedHashMap<String, String>> originalMap) {
		LinkedHashMap<String, LinkedHashMap<String, String>> cloneMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		for (Entry<String, LinkedHashMap<String, String>> entry : originalMap.entrySet()) {
			cloneMap.put(entry.getKey(), new LinkedHashMap<String, String>(entry.getValue()));
		}
		return cloneMap;
	}

	public String appendString(String original, String addString) {
		StringBuilder str = new StringBuilder(original);
		str.append(addString + "\n");
		return str.toString();
	}

	public List<String> createListForComparison(String[] input){
		List<String> outPutList = new ArrayList<String>();
		outPutList = Arrays.asList(input);
		return outPutList;
	}

	public List<String> getComparisonList(LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, String fieldName){
		String formatRules = reqMap.get(fieldName).get("Expected");
		String[] stringArr = formatRules.split("\\(");
		String[] stringArr2 = stringArr[1].split("\\)");
		String[] stringArr3 = stringArr2[0].split(",");
		List<String>  comparisonList = createListForComparison(stringArr3);
		List<String>  comparisonList1 = new ArrayList<>();
		for(int i=0; i<comparisonList.size(); i++){
			if((comparisonList.get(i).trim().trim()).equalsIgnoreCase("blank")){
				comparisonList1.add("");
			} else {
				comparisonList1.add(comparisonList.get(i).trim());
			}
		}
		return comparisonList1;
	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> readAndConvertToMap(String excelFilePath,
			String sheetName) throws IOException {
		InputStream inputStream;
		XSSFWorkbook wb;
		XSSFSheet dataSheet;
		int rowCount;
		int colCount;
		LinkedHashMap<Integer, String> columnHeaderMap = new LinkedHashMap<Integer, String>();
		LinkedHashMap<Integer, String> rowHeaderMap = new LinkedHashMap<Integer, String>();
		LinkedHashMap<String, LinkedHashMap<String, String>> sheetlevelMap1 = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		LinkedHashMap<Integer, LinkedHashMap<String, Map<String, String>>> masterReqMap = new LinkedHashMap<Integer, LinkedHashMap<String, Map<String, String>>>();
		String rowHeader1;
		String columnHeader1;
		String value1 = null;
		Row rowVal;
		double value2;
		Row rowVal1;
		Cell CheckCell;
		inputStream = getClass().getClassLoader().getResourceAsStream(excelFilePath);
		wb = new XSSFWorkbook(inputStream);
		dataSheet = wb.getSheet(sheetName);
		rowCount = dataSheet.getPhysicalNumberOfRows();
		System.out.println("rowCount--->"+rowCount);
		colCount = dataSheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("colCount--->"+colCount);
		rowVal = dataSheet.getRow(0);
		System.out.println("rowVal--->"+rowVal);
		for (int j = 0; j < colCount; j++) {
			CheckCell = rowVal.getCell(j);
			System.out.println("CheckCell--->"+CheckCell);
			if (CheckCell != null && CheckCell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
				rowHeader1 = rowVal.getCell(j).getStringCellValue();
				System.out.println("rowHeader1--->"+rowHeader1);
			} else {
				rowHeader1 = null;
			}
			columnHeaderMap.put(j, rowHeader1);
		}
		int validateColumnNo = 0 ;
		for(int t=0; t<colCount; t++){

			if(dataSheet.getRow(0).getCell(t).getStringCellValue().equalsIgnoreCase("Validate"))
				validateColumnNo = t;
		}
		for (int l = 0; l < rowCount; l++) {
			Row checkRow = dataSheet.getRow(l);
			System.out.println("checkRow--->"+checkRow);
			if (checkRow != null && checkRow.getCell(validateColumnNo).getStringCellValue().equals("Y")) {
				CheckCell = dataSheet.getRow(l).getCell(0);
				System.out.println("CheckCell 2--->"+CheckCell);
				if (CheckCell != null && CheckCell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
					columnHeader1 = dataSheet.getRow(l).getCell(0).getStringCellValue();
					System.out.println("columnHeader1--->"+columnHeader1);
				} else {
					columnHeader1 = null;
				}
				rowHeaderMap.put(l, columnHeader1);
			} 
		}
		int rowCount2;
		int numberOfSheets = wb.getNumberOfSheets();
		for (int i = 1; i < rowCount; i++) {
			LinkedHashMap<String, String> rowLevelMap1 = new LinkedHashMap<String, String>();
			rowVal1 = dataSheet.getRow(i);
			System.out.println("rowVal1--->"+rowVal1);
			if (rowVal1.getCell(validateColumnNo).getStringCellValue().equals("Y")) {
				for (int j = 1; j < colCount; j++) {
					CheckCell = rowVal1.getCell(j);
					System.out.println("CheckCell 3--->"+CheckCell);
					if (CheckCell != null && CheckCell.getCellType() != XSSFCell.CELL_TYPE_BLANK && CheckCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
						value1 = rowVal1.getCell(j).getStringCellValue();
						System.out.println("value1 --->"+value1);
					} else if (CheckCell != null && CheckCell.getCellType() != XSSFCell.CELL_TYPE_BLANK && CheckCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
						value2 = rowVal1.getCell(j).getNumericCellValue();
						value1 = Double.toString(value2);
						System.out.println("value1 string--->"+value1);
					} else {
						value1 = null;
					}
					rowLevelMap1.put(columnHeaderMap.get(j), value1);
				}
				sheetlevelMap1.put(rowHeaderMap.get(i), rowLevelMap1);
			}
		}
		inputStream.close();
		return sheetlevelMap1;
	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> setReqMap() throws Exception{
		LinkedHashMap<String, LinkedHashMap<String, String>> reqMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		try {
			reqMap = readAndConvertToMap("./transactionFileRequirements/"+transactionFile+".xlsx", sourceSystem);
		} catch (Exception e){
			throw new Exception("Issue in creating requirement map for : "+transactionFile+"-"+sourceSystem+" combination");
		}
		return reqMap;
	}

	public void moveFileToValidated(File file) throws Exception{
		try {
			System.gc();
			Runtime.getRuntime().gc();
			Files.move(Paths.get(getFileAbsolutePath(file)), Paths.get(Common.validatedFilesPathDynamic+"\\"+getFileName(getFileAbsolutePath(file))+"."
					+getFileFormat(getFileAbsolutePath(file))));

		} catch (IOException e) {
			System.gc();
			Files.copy(Paths.get(getFileAbsolutePath(file)), Paths.get(Common.validatedFilesPathDynamic+"\\"+getFileName(getFileAbsolutePath(file))+"."
					+getFileFormat(getFileAbsolutePath(file))), StandardCopyOption.REPLACE_EXISTING);
			file.delete();
			Thread.sleep(2000);
		}
	}


	public boolean verifyDateFormat(String val, String dateFormat) {
		DateFormat formatter = new SimpleDateFormat(dateFormat);
		formatter.setLenient(false);
		Boolean value = false;
		try {
			Date date = formatter.parse(val);
			if (verifyTextFormat(val.trim(), "^[\\pN]+$")){
				if ( dateFormat.equalsIgnoreCase("yyyymmdd")){
					if(!(val.startsWith("0")) && val.trim().length()==8)
						value = true;
					else
						value = false;
				} else if (dateFormat.equalsIgnoreCase("hhmmss")) {
					if( val.trim().length()== 6)
						value = true;
					else
						value = false;
				} else{
					value = false;
				}

			} else{
				value = false;
			}
		} catch (ParseException e) {
			value = false;
		}
		return value;
	}

	public List<String> getCountryCodeList() {
		String countryCodeList1 = getProperty("CountryCodes");
		String[] countryCodeList2 =countryCodeList1.split(",");
		List<String>  countryCodeComparisonList = createListForComparison(countryCodeList2);
		return countryCodeComparisonList;
	}

	public void loadFilePathsAndCountry() throws Exception{
		if(Common.countryToBeValidated.equalsIgnoreCase("ALL")){
			Common.MultiCountryFlag = true;
		} else if(!(Common.countryToBeValidated.trim().isEmpty())) {
			Common.countryCode = Common.countryToBeValidated;
		} else{
			throw new Exception("Transaction file type input - \""+Common.countryToBeValidated+"\" is not valid");
		}
		File parentFile = new File(System.getProperty("user.dir"));
		String sourceFolder = parentFile.getParent();
		tempFilePath = "C:\\FalconAutomation\\TempFiles";
		validatedFilesPath = "C:\\FalconAutomation\\ValidateFiles";
		assertionLogPath = "C:\\FalconAutomation\\AssertionLog";
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String TimeStampClone = "";
		for (int ij=0; ij<timeStamp.length(); ij++){
			TimeStampClone = TimeStampClone+timeStamp.charAt(ij);
		}
		File file = new File(validatedFilesPath + "/" + TimeStampClone);
		file.mkdirs();
		validatedFilesPathDynamic = file.getAbsolutePath();
		verifyFilepath("Test Files Path", testFilesPath);
		verifyFilepath("Temp Files Path",tempFilePath);
		verifyFilepath("Validated Files Path",validatedFilesPath);
		verifyFilepath("Validated file path's current instance",validatedFilesPathDynamic);
		verifyFilepath("Assertion log Path", assertionLogPath);
	}

	public Boolean verifyTextFormat(String val, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Boolean value;
		Matcher m = p.matcher(val);
		if (m.find()) {
			value = true;
		} else {
			value = false;
		}
		return value;
	}
}
