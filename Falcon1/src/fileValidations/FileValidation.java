package fileValidations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import utils.Common;
import java.util.LinkedHashMap;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import utils.Report;
import utils.Wrappers;

public class FileValidation extends Wrappers {
	Wrappers wp = new Wrappers();

	/**
	 * Description - To verify the file as per the given combination
	 * @param transactionFile, sourceSystem
	 * @return void
	 */
	public void verifyFileCombination(String transactionFile, String sourceSystem) throws Exception{
		String sourceSystem2 = "";
		Common.transactionFile = transactionFile;
		Common.sourceSystem = sourceSystem;
		if (sourceSystem.equals("HOGAN")){
			sourceSystem2 = "HOGN";
		}else if(sourceSystem.equals("EURONET")){
			sourceSystem2 = "EURO";
		}else if(sourceSystem.equals("TANDEM")){
			sourceSystem2 = "TDEM";
		}else if(sourceSystem.equals("SPARROW")){
			sourceSystem2 = "SPAR";
		} else {
			sourceSystem2 = sourceSystem;
		}
		Common.sourceSystem2 =sourceSystem2;
		File[] files = wp.getAllFiles(Common.testFilesPath);
		int fileCounter = 0;

		for (int i=0; i<files.length; i++){
			String fileAbsPath1 = wp.getFileAbsolutePath(files[i]);
			Common.validationFile = files[0];
			String fileName = wp.getFileName(fileAbsPath1);
			String fileFormat1 = wp.getFileFormat(fileAbsPath1);
			if(Common.MultiCountryFlag && fileName.contains(transactionFile) && fileName.contains(sourceSystem2)){
				String countryCodeCheck = fileName.substring((transactionFile.length()), (transactionFile.length()+2));
				if(wp.getCountryCodeList().contains(countryCodeCheck)){
					Common.countryCode =countryCodeCheck;
				} 
			}

			String expectedFilnamePrefix = transactionFile+Common.countryCode+sourceSystem2;
			if(fileName.contains(expectedFilnamePrefix)){
				Thread.sleep(1000);
				try {
					Files.move(Paths.get(fileAbsPath1), Paths.get(Common.tempFilePath+"\\"+fileName+"."+fileFormat1));
				} catch (IOException e) {
					e.printStackTrace();
					Files.copy(Paths.get(fileAbsPath1), Paths.get(Common.tempFilePath+"\\"+fileName+"."+fileFormat1), StandardCopyOption.REPLACE_EXISTING);
					files[i].delete();
					Thread.sleep(1000);
					if(files[i].isFile())
						files[i].delete();
					Thread.sleep(1000);
				}
				fileCounter++;
			}
		}
		if (fileCounter == 0){
			throw new Exception("The given Directory/Folder is empty or the expected file is not present - "+transactionFile+Common.countryCode+sourceSystem);
			
		}
	}

	/**
	 * Description - To verify the file count and do file level validations
	 * @param <null>
	 * @return void
	 */
	public void validateFiles() throws Exception{
		File[] files2 = wp.getAllFiles(Common.tempFilePath);
		Common.iterationCounter = files2.length;
		if (wp.isDuplicateFile(files2,Common.countryCode, Common.transactionFile, Common.sourceSystem)){
			throw new Exception("Duplicate Files present");
		}

		for(int i=0; i<Common.iterationCounter; i++){
			String filename3 = wp.getFileName(wp.getFileAbsolutePath(files2[i]));
			String cloneFileName = "";

			for (int k=0; k<filename3.length(); k++){
				cloneFileName = cloneFileName+filename3.charAt(k);
			}

			String fileName2 = cloneFileName;
			int actualFileLength = fileName2.length();
			if(Common.MultiCountryFlag && filename3.contains(transactionFile) && filename3.contains(sourceSystem2)){
				String countryCodeCheck = filename3.substring((transactionFile.length()), (transactionFile.length()+2));
				if(wp.getCountryCodeList().contains(countryCodeCheck)){
					Common.countryCode =countryCodeCheck;
				}
			}

			int expectedFileLength = (Common.transactionFile+Common.sourceSystem2+Common.countryCode).length()+14;
			if(wp.isFileEmpty(files2[i]))
				System.out.println("Able to read the file - "+fileName2);
			else{
				wp.moveFileToValidated(files2[i]);
				throw new Exception("Unable to read file/File is empty for - "+fileName2);
			}
			if (actualFileLength == expectedFileLength && wp.verifyTextFormat(fileName2, "[0-9]{14}$"))
				System.out.println("File naming convention is as expected for file - "+fileName2);
			else{
				wp.moveFileToValidated(files2[i]);
				throw new Exception("File naming convention is not as expected for - "+fileName2 +": Actual - ");
			}
			if(wp.getFileFormat(wp.getFileAbsolutePath(files2[i])).contains("txt"))
				System.out.println("File format for file - "+fileName2+" is .txt as expected");
			else{
				wp.moveFileToValidated(files2[i]);
				throw new Exception("File format is not .txt for - "+fileName2);
			}
		}
	}

	/**
	 * Description - To initiate validation method based on the given transaction type 
	 * @param transactionFile, validationLinene, reqMap, transactionCount
	 * @return void
	 */
	public void intiateValidation(String transactionFile, String validationLine, 
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws Exception {

		if(Common.transactionFile.equalsIgnoreCase("DBTRAN25"))
			new DBTRAN25().validateDBTRAN25Transaction(validationLine, reqMap, transactionCount);
		else if (Common.transactionFile.equalsIgnoreCase("CRTRAN25"))
			new CRTRAN25().validateCRTRAN25Transaction(validationLine, reqMap, transactionCount);
		else if (Common.transactionFile.equalsIgnoreCase("CIS20"))
			new CIS20().validateCIS20Transaction(validationLine, reqMap, transactionCount);
		else if (Common.transactionFile.equalsIgnoreCase("AIS20"))
			new AIS20().validateAIS20Transaction(validationLine, reqMap, transactionCount);
		else if (Common.transactionFile.equalsIgnoreCase("PIS12"))
			new PIS12().validatePIS12Transaction(validationLine, reqMap, transactionCount);
		else if (Common.transactionFile.equalsIgnoreCase("RBTRAN21"))
			new RBTRAN21().validateRBTRAN21Transaction(validationLine, reqMap, transactionCount);
		else if (Common.transactionFile.equalsIgnoreCase("NMON20"))
			new NMON20().validateNMON20Transaction(validationLine, reqMap, transactionCount);
		else
			throw new Exception("Validation class is not loaded properly");
	}
}
