package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import cucumber.api.Scenario;


public class Common {
	
	// **************  Common Variables  ***********************
	/**
	 * Description - To store and reuse common variables
	 */
	
	public static String fileName;
	public static int iterationCounter;
	public static int transactionsCount;
	public static File validationFile;
	public static String tempFilePath;
	public static String validatedFilesPath;
	public static String validatedFilesPathDynamic;
	public static LinkedHashMap<String, LinkedHashMap<String, String>> reportMap;
	public static String transactionFile;
	public static String sourceSystem;
	public static String countryCode;
	public static String cvv2Present;
	public static String AuthPostFlag;
	public static ArrayList<String> transaction_Id = new ArrayList<String>();
	public static String AuthDecisionCode;
	public static String TransactionType;
	public static String mcc;
	public static int StatusChecker1 = 0;
	public static int StatusChecker2 = 0;
	public static List<String> failedFilesList = new ArrayList<String>();
	public static String failedFiles;
	//public static String testFilePath;
	public static String transactionFileRequirementsPath;
	public static String assertionLogPath;
	public static String fileName2;
	public static Scenario scenario;
	public static String cvrOfflinePinVerificationPerformed;
	public static String sourceSystem2;
	public static String MediaTypeFlag;
	public static ArrayList<String> transactionRefNumber = new ArrayList<String>();
	public static String nonmonCode;
	public static String StatusFlag;
	public static String testFilesPath;
	public static String systemToBeValidated;
	public static String countryToBeValidated;
	public static String transactionTypeToBeValidated;
	public static boolean MultiCountryFlag;
	
}
