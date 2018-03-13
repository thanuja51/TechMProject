package stepdefinitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import java.util.LinkedHashMap;
import java.util.List;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import fileValidations.FileValidation;
import utils.Common;
import utils.Report;
import utils.Wrappers;

public class FileValidationStepDef {

	Wrappers wp = new Wrappers();
	FileValidation fv = new FileValidation();
	Report rp = new Report();
	private Scenario scenario;

	/**
	 * Description � To verify the file as per the given combination
	 * @param transactionFile, sourceSystem
	 * @return void
	 */
	@Given("^Transaction file \"([^\"]*)\" exists for \"([^\"]*)\"$")
	public void check_File_Location(String transactionFile, String sourceSystem) throws Exception{

		fv.verifyFileCombination(transactionFile,sourceSystem);
	}
	/**
	 * Description � To verify the file count and do file level validations
	 * @param <null>
	 * @return void
	 */
	@When("^I validate transaction file count and perform file level validations$")
	public void verify_Transaction_File_Count_Perform_File_Level_Validations() throws Exception{
		fv.validateFiles();
	}

	/**
	 * Description � To verify transactions in given transaction files against given specifications 
	 * @param sourceSystem, transactionFileType
	 * @return void
	 */
	@And("^I verify field format for fields as per \"([^\"]*)\" specifications for \"([^\"]*)\"$")
	public void verify_Field_Format_Mandatory_NonMandatory_Fields(String sourceSystem, String transactionFileType) throws Exception{

		File[] files2 = wp.getAllFiles(Common.tempFilePath);
		int numberOfTransactions = 0;
		for(int i=0; i<Common.iterationCounter; i++){
			Common.fileName = wp.getFileName(wp.getFileAbsolutePath(files2[i]));
			String cloneFileName = "";
			for (int k=0; k<Common.fileName.length(); k++){
				cloneFileName = cloneFileName+Common.fileName.charAt(k);
			}
			Common.fileName2 = cloneFileName;
			List<String> transactionEntries =  wp.readNotepad(files2[i], "UTF-8");
			List<String> transactionEntriesData = wp.readSpecificSegment(transactionEntries, "D");
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
			reqMap = wp.setReqMap();
			Common.reportMap = wp.cloneMap(reqMap);
			numberOfTransactions = transactionEntriesData.size();
			if(Common.MultiCountryFlag && Common.fileName2 .contains(transactionFileType) && Common.fileName2 .contains(Common.sourceSystem2)){
				String countryCodeCheck = Common.fileName2 .substring((transactionFileType.length()), (transactionFileType.length()+2));
				if(wp.getCountryCodeList().contains(countryCodeCheck)){
					Common.countryCode =countryCodeCheck;
				}
			}
			if (reqMap.containsKey("externalTransactionId")){
				for (int l=0; l<numberOfTransactions; l++){
					String validationLine = transactionEntriesData.get(l);
					String externalTransactionId = validationLine.substring(wp.getStartIndex("externalTransactionId", reqMap),
							wp.getEndIndex("externalTransactionId", reqMap)).trim();
					Common.transaction_Id.add(externalTransactionId);
				}
			}
			if (reqMap.containsKey("transactionReferenceNumber")){
				for (int l=0; l<numberOfTransactions; l++){
					String validationLine = transactionEntriesData.get(l);
					String externalTransactionId = validationLine.substring(wp.getStartIndex("transactionReferenceNumber", reqMap),
							wp.getEndIndex("transactionReferenceNumber", reqMap)).trim();
					Common.transactionRefNumber.add(externalTransactionId);
				}
			}

			for(int j=0; j<numberOfTransactions; j++){
				String validationLine = transactionEntriesData.get(j);

				/*if(!(validationLine.length() == ( Integer.parseInt(wp.getProperty(transactionFileType))))){
					wp.moveFileToValidated(files2[i]);
					throw new Exception("Length is not same for  Transaction - "+(j+1)+" of "+transactionFileType
							+": Expected - "+Integer.parseInt(wp.getProperty(transactionFileType))+" -- Actual -"+validationLine.length());
				}*/
				try{
					fv.intiateValidation(Common.transactionFile, validationLine, reqMap, j);
				} catch (Exception e){
					wp.moveFileToValidated(files2[i]);
					throw new Exception(e);
				}
				System.out.println("Transaction : "+(j+1)+" - validated");
			}

			rp.createLog(Common.fileName, Common.reportMap);
			Common.reportMap.clear();
			Common.transaction_Id.clear();
			if (!(Common.StatusChecker1 ==0)){
				Common.StatusChecker2++;
				Common.failedFilesList.add(cloneFileName); 

			}
			wp.moveFileToValidated(files2[i]);
		}

		/*Common.scenario.write("Validated File name = " + Common.fileName + "\n");
		Common.scenario.write("Validated Transactions = " +numberOfTransactions+ "\n");
		Common.scenario.write("Assertion Log = " +Report.reportFileName);*/
		if (!(Common.StatusChecker2 ==0)){
			String FailedFiles = "";
			for(int i=0; i<Common.StatusChecker2; i++){
				FailedFiles = FailedFiles+Common.failedFilesList.get(i)+", ";
			}
			Common.failedFilesList.clear();
			Common.StatusChecker2 =0;
			throw new Exception("The following file(s) do(es)n't comply with the given specifications -"+FailedFiles+
					"Check Assertion log of the mentioned files for more info");
		}
	}
}
