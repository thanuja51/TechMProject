package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


public class Report {

	public static FileInputStream inputStream;
	public static FileOutputStream out;
	public static SXSSFWorkbook wb;
	public static SXSSFSheet sheet;
	public static String reportFileName;
	public static File reportFile;
	public static LinkedHashMap<String, Map<String, String>> reqMap;
	public static LinkedHashMap<String, LinkedHashMap<String, String>> assertionLogTemplate = new LinkedHashMap<String, LinkedHashMap<String, String>>();
	public static LinkedHashMap<Integer, HashMap<String, String>> finalMap = new LinkedHashMap<Integer, HashMap<String, String>>();
	public Wrappers wp = new Wrappers();
	public static CellStyle headerStyle;
	public static Font headerFont;
	public static CellStyle normalCellStyle;
	public static Font normalFont;
	public static CellStyle passCellStyle;
	public static Font passFont;
	public static CellStyle failCellStyle;
	public static Font failFont;

	/**
	 * Description - To update report map 
	 * @param transactionCount, fieldName, failCounter, remarks
	 * @return void
	 */
	public void updateLog(int transactionCount, String fieldName, int failCounter, String remarks) {
		assertionLogTemplate = Common.reportMap;
		String Status;
		if (failCounter == 0)
			Status = "PASS";
		else
			Status = "FAIL";
		if (Status.endsWith("\n") || remarks.endsWith("\n")) {
			Status = Status.trim();
			remarks = remarks.trim();
		}
		transactionCount = transactionCount + 1;
		assertionLogTemplate.get(fieldName).put("txn" + transactionCount + "_result", Status);
		assertionLogTemplate.get(fieldName).put("txn" + transactionCount + "_remarks", remarks);
	}

	/**
	 * Description - To create assertion log 
	 * @param fieldName, assertionLogTemplate
	 * @return void
	 */
	public void createLog(String fileName, LinkedHashMap<String, LinkedHashMap<String, String>> assertionLogTemplate)
			throws IOException {
		SXSSFRow row;
		SXSSFRow contentRow;
		int failCounter1 = 0;

		wb = new SXSSFWorkbook();
		headerStyle = wb.createCellStyle();
		headerFont = wb.createFont();
		normalCellStyle = wb.createCellStyle();
		normalFont = wb.createFont();
		passCellStyle = wb.createCellStyle();
		passFont = wb.createFont();
		failCellStyle = wb.createCellStyle();
		failFont = wb.createFont();
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String TimeStampClone = "";
		for (int ij=0; ij<timeStamp.length(); ij++){
			TimeStampClone = TimeStampClone+timeStamp.charAt(ij);
		}
		reportFileName = Common.fileName2 + "_AssertionLog_" + TimeStampClone+ ".xlsx";
		String[] rowH = Arrays.copyOf(assertionLogTemplate.keySet().toArray(), 
				assertionLogTemplate.keySet().toArray().length, String[].class);
		String cellColour = "none";
		boolean flag = true;
		Object[] temp = null, tempH = null;
		for (int i = 0; i < rowH.length; i++) {
			for (int j = 0; j < assertionLogTemplate.get(rowH[i]).size(); j++) {
				if (wp.verifyTextFormat(assertionLogTemplate.get(rowH[i]).keySet().toArray()[j].toString(),
						"[t]{1}[x]{1}[n]{1}[0-9_a-zA-Z]*$")) {
					tempH = assertionLogTemplate.get(rowH[i]).keySet().toArray();
					break;
				}
			}
		}

		float iterationVal = (float)(tempH.length - 6);
		float iterationVal1 = (float) (iterationVal/16300);
		int iterationVal12 = (int) Math.ceil(iterationVal1);
		out = new FileOutputStream(new File(Common.assertionLogPath+"/" + reportFileName));
		int iteratorColVal = 16305;
		int iCol1 = 0;
		int iCol11 = 0;
		int iteratorColVal2 = 0;
		boolean singleIterationFlag = false;
		if (iterationVal12==1)
			singleIterationFlag = true;

		for (int iteratorVal = 1; iteratorVal <= iterationVal12; iteratorVal++){
			int iteratorval2;
			if (singleIterationFlag)
				iteratorval2 = tempH.length;
			else if (iteratorColVal2==0)
				iteratorval2 = 16305;
			else 
				iteratorval2 = iteratorColVal2+6;
			int logVal1=0;
			if(iCol1>0)
				iCol11 = iCol1/2;
			sheet = wb.createSheet("Log_"+iteratorVal+"("+iCol1+"-"+((iteratorColVal-5)/2)+")");

			for (int iRow = 0; iRow < rowH.length; iRow++) {
				row = sheet.createRow(iRow);
				for (int iCol = 0; iCol < 6; iCol++) {
					if (iRow == 0 && iCol == 0) {
						row.createCell(iCol).setCellValue("Field Name");
						row.getCell(iCol).setCellStyle(applyCellStyle("Header", headerStyle, headerFont));

					} else if (iRow == 0) {
						// col headers
						row.createCell(iCol).setCellValue(tempH[iCol - 1].toString());
						row.getCell(iCol).setCellStyle(applyCellStyle("Header", headerStyle, headerFont));
					} else if (iCol == 0) {
						// row Headers
						row.createCell(iCol).setCellValue(rowH[iRow - 1]);
						row.getCell(iCol).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
						// last row
						if (iRow == assertionLogTemplate.size() - 1) {
							sheet.createRow(iRow + 1).createCell(iCol).setCellValue(rowH[iRow]);
							sheet.getRow(iRow + 1).getCell(iCol).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
						}
					} 
				}

			}

			for (int iRow = 0; iRow < rowH.length; iRow++) {
				for ( int iCol = 5; iCol < iteratorval2; iCol++) {

					if (iRow == 0) {
						// col headers
						sheet.getRow(0).createCell(iCol+1).setCellValue(tempH[iCol1+iCol].toString());
						sheet.getRow(0).getCell(iCol+1).setCellStyle(applyCellStyle("Header", headerStyle, headerFont));
					}

				}
			}

			for (int k = 1; k <= rowH.length; k++) {
				contentRow = sheet.getRow(k);
				for (int l = 1; l <= 5; l++) {
					if (assertionLogTemplate.get(rowH[k - 1]).containsKey(tempH[l - 1])) {
						if (assertionLogTemplate.get(rowH[k - 1]).get(tempH[l - 1]) != null) {
							contentRow.createCell(l).setCellValue(assertionLogTemplate.get(rowH[k - 1]).get(tempH[l - 1]));
							if (assertionLogTemplate.get(rowH[k - 1]).get(tempH[l - 1]).equals("FAIL")) {
								failCounter1++;
								cellColour = "red";
								flag = false;
								contentRow.getCell(l).setCellStyle(applyCellStyle("FAIL", failCellStyle, failFont));
							} else if (assertionLogTemplate.get(rowH[k - 1]).get(tempH[l - 1]).equals("PASS")) {
								cellColour = "green";
								flag = false;
								contentRow.getCell(l).setCellStyle(applyCellStyle("PASS", passCellStyle, passFont));
							} else {
								cellColour = "none";
								flag = true;
								contentRow.getCell(l).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
							}
						} else {
							// null content for req spec fields
							contentRow.createCell(l);
							contentRow.getCell(l).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
						}

					} else {
						// null content for txn remarks and results
						contentRow.createCell(l);
						contentRow.getCell(l).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
					}
				}
			}

			for (int k = 1; k <= rowH.length; k++) {
				contentRow = sheet.getRow(k);

				for (int l = 6; l <= (iteratorval2); l++) {
					if (assertionLogTemplate.get(rowH[k - 1]).containsKey(tempH[(iCol1+l) - 1])) {
						if (assertionLogTemplate.get(rowH[k - 1]).get(tempH[(iCol1+l) - 1]) != null) {
							contentRow.createCell(l).setCellValue(assertionLogTemplate.get(rowH[k - 1]).get(tempH[(iCol1+l) - 1]));
							if (assertionLogTemplate.get(rowH[k - 1]).get(tempH[(iCol1+l) - 1]).equals("FAIL")) {
								failCounter1++;
								cellColour = "red";
								flag = false;
								contentRow.getCell(l).setCellStyle(applyCellStyle("FAIL", failCellStyle, failFont));
							} else if (assertionLogTemplate.get(rowH[k - 1]).get(tempH[l - 1]).equals("PASS")) {
								cellColour = "green";
								flag = false;
								contentRow.getCell(l).setCellStyle(applyCellStyle("PASS", passCellStyle, passFont));
							} else {
								cellColour = "none";
								flag = true;
								contentRow.getCell(l).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
							}
						} else {
							// null content for req spec fields
							contentRow.createCell(l);
							contentRow.getCell(l).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
						}

					} else {
						// null content for txn remarks and results
						contentRow.createCell(l);
						contentRow.getCell(l).setCellStyle(applyCellStyle("Normal", normalCellStyle, normalFont));
					}
				}
				System.out.println("Sheet - "+iteratorVal+" :Row printed - "+k);
			}

			Common.StatusChecker1 = failCounter1;
			if(iteratorVal<(iterationVal12-1)){
				iteratorColVal = iteratorColVal+16300;
				iteratorColVal2 =16300;
			}
			else {
				iteratorColVal2 = (tempH.length-iteratorColVal);
				iteratorColVal = iteratorColVal+(tempH.length-iteratorColVal);
			}
			iCol1 = iCol1+16300;
			sheet.setDefaultColumnWidth(35);
		}
		wb.write(out);
		out.close();
	}
	
	/**
	 * Description - To apply cell style
	 * @param styleType, cellstye, font
	 * @return cellstye
	 */
	public CellStyle applyCellStyle(String styleType, CellStyle cellstye, Font font) {
		
		cellstye.setBorderTop(BorderStyle.THIN);
		cellstye.setBorderBottom(BorderStyle.THIN);
		cellstye.setBorderLeft(BorderStyle.THIN);
		cellstye.setBorderRight(BorderStyle.THIN);
		cellstye.setWrapText(true);
		if (styleType.equalsIgnoreCase("Header")){
			cellstye.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
			cellstye.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			cellstye.setFont(font);
			cellstye.setAlignment(HorizontalAlignment.CENTER);
		}else if (styleType.equalsIgnoreCase("PASS")){
			cellstye.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			cellstye.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			cellstye.setFont(font);
			cellstye.setAlignment(HorizontalAlignment.CENTER);
		} else if (styleType.equalsIgnoreCase("FAIL")){
			cellstye.setFillForegroundColor(IndexedColors.RED.getIndex());
			cellstye.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			cellstye.setFont(font);
			cellstye.setAlignment(HorizontalAlignment.CENTER);
		} else if(styleType.equalsIgnoreCase("Normal")){
		
		}
		return cellstye;
	}

}
