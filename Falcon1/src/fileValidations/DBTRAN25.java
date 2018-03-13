package fileValidations;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import utils.Report;
import utils.Wrappers;

public class DBTRAN25 extends Wrappers {

	Report rp = new Report();

	/**
	 * Description - To call all field level validation methods
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */	
	public void validateDBTRAN25Transaction(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		// Dependant Fields
		validateTransactionType(transactionEntry, reqMap, transactionCount);
		validateCashbackAmount(transactionEntry, reqMap, transactionCount);
		validateCvv2Present(transactionEntry, reqMap, transactionCount);
		validateCVVVerifyCode(transactionEntry, reqMap, transactionCount);
		validateAuthDecisionCode(transactionEntry, reqMap, transactionCount);
		validateAuthResponseCode(transactionEntry, reqMap, transactionCount);
		validateCvrOfflinePinVerificationPerformed(transactionEntry, reqMap, transactionCount);
		validateCvrOfflinePinVerificationFailed(transactionEntry, reqMap, transactionCount);
		validateAuthPostFlag(transactionEntry, reqMap, transactionCount);
		validateAuthPostMiscIndicator(transactionEntry, reqMap, transactionCount);
		// Non-Dependant Fields
		validateWorkflow(transactionEntry, reqMap, transactionCount);
		validateRecordType(transactionEntry, reqMap, transactionCount);
		validateDataSpecificationVersion(transactionEntry, reqMap, transactionCount);
		validateClientIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateRecordCreationDate(transactionEntry, reqMap, transactionCount);
		validateRecordCreationTime(transactionEntry, reqMap, transactionCount);
		validateRecordCreationMilliseconds(transactionEntry, reqMap, transactionCount);
		validateGMTOffset(transactionEntry, reqMap, transactionCount);
		validateCustomerIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateCustomerAcctNumber(transactionEntry, reqMap, transactionCount);
		validateExternalTransactionId(transactionEntry, reqMap, transactionCount);
		validatePan(transactionEntry, reqMap, transactionCount);
		validateCardExpireDate(transactionEntry, reqMap, transactionCount);
		validateTransactionDate(transactionEntry, reqMap, transactionCount);
		validateTransactionTime(transactionEntry, reqMap, transactionCount);
		validateTransactionAmount(transactionEntry, reqMap, transactionCount);
		validateTransactionCurrencyCode(transactionEntry, reqMap, transactionCount);
		validateTransactionCurrencyConversionRate(transactionEntry, reqMap, transactionCount);
		validateMCC(transactionEntry, reqMap, transactionCount);
		validateMerchantCountryCode(transactionEntry, reqMap, transactionCount);
		validatePinVerifyCode(transactionEntry, reqMap, transactionCount);
		validatePosEntryMode(transactionEntry, reqMap, transactionCount);
		validatePostDate(transactionEntry, reqMap, transactionCount);
		validateUserData01(transactionEntry, reqMap, transactionCount);
		validateUserData02(transactionEntry, reqMap, transactionCount);
		validateCustomerPresent(transactionEntry, reqMap, transactionCount);
		validateAtmOwner(transactionEntry, reqMap, transactionCount);
		validatePortfolio(transactionEntry, reqMap, transactionCount);
		validateMerchantName(transactionEntry, reqMap, transactionCount);
		validateMerchantCity(transactionEntry, reqMap, transactionCount);
		validateMerchantState(transactionEntry, reqMap, transactionCount);
		validateUserIndicator03(transactionEntry, reqMap, transactionCount);
		validateUserData05(transactionEntry, reqMap, transactionCount);
		validateRealtimeRequest(transactionEntry, reqMap, transactionCount);
		validatePadActionExpireDate(transactionEntry, reqMap, transactionCount);
		validateCardAipStatic(transactionEntry, reqMap, transactionCount);
		validateCardAipDynamic(transactionEntry, reqMap, transactionCount);
		validateCardAipVerify(transactionEntry, reqMap, transactionCount);
		validateCardAipRisk(transactionEntry, reqMap, transactionCount);
		validateCardAipIssuerAuthentication(transactionEntry, reqMap, transactionCount);
		validateCardAipCombined(transactionEntry, reqMap, transactionCount);
		validateAvailableBalance(transactionEntry, reqMap, transactionCount);
		validateAvailableDailyCashLimit(transactionEntry, reqMap, transactionCount);
		validateAvailableDailyMerchandiseLimit(transactionEntry, reqMap, transactionCount);
		validateCvv2Response(transactionEntry, reqMap, transactionCount);
		validateTransactionCategory(transactionEntry, reqMap, transactionCount);
		validateAcquirerCountry(transactionEntry, reqMap, transactionCount);
		validateterminalType(transactionEntry, reqMap, transactionCount);
		validateterminalEntryCapability(transactionEntry, reqMap, transactionCount);
		validatePosConditionCode(transactionEntry, reqMap, transactionCount);
		validateNetworkId(transactionEntry, reqMap, transactionCount);
		validateAuthExpireDateVerify(transactionEntry, reqMap, transactionCount);
		validateAuthSecondaryVerify(transactionEntry, reqMap, transactionCount);
		validateAuthReversalReason(transactionEntry, reqMap, transactionCount);
		validateAuthCardIssuer(transactionEntry, reqMap, transactionCount);
		validateCryptogramValid(transactionEntry, reqMap, transactionCount);
		validateStandinAdvice(transactionEntry, reqMap, transactionCount);
		validateMerchantId(transactionEntry, reqMap, transactionCount);
		validateUserData06(transactionEntry, reqMap, transactionCount);
		validateCvrPinTryLimitExceeded(transactionEntry, reqMap, transactionCount);
		validatePosUnattended(transactionEntry, reqMap, transactionCount);
		validatePosCardCapture(transactionEntry, reqMap, transactionCount);
		validatePosSecurity(transactionEntry, reqMap, transactionCount);
	}

	/**
	 * Description - To validate WorkFlow field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateWorkflow(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "workflow";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String workFlowVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (workFlowVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + workFlowVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(workFlowVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(workFlowVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate RecordType field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateRecordType(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "recordType";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String recordtypeval = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (recordtypeval.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + recordtypeval.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(recordtypeval)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(recordtypeval)) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}
	/**
	 * Description - To validate DataSpecificationVersion field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateDataSpecificationVersion(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "dataSpecificationVersion";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String dataSpecificationVersionval = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (dataSpecificationVersionval.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + dataSpecificationVersionval.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(dataSpecificationVersionval)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(dataSpecificationVersionval.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate ClientIdFromHeader field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateClientIdFromHeader(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "clientIdFromHeader";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String clientIdFromHeaderVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (clientIdFromHeaderVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + clientIdFromHeaderVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			String clientIdFormat = "SC_" + sourceSystem + countryCode + "_DB";
			if (sizeVal == getStringLen(clientIdFromHeaderVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (clientIdFromHeaderVal.trim().equals(clientIdFormat)) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate RecordCreationDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateRecordCreationDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "recordCreationDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String recordCreationDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (recordCreationDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + recordCreationDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(recordCreationDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				FailCounter++;
			}

			if (verifyDateFormat(recordCreationDateVal, "yyyyMMdd")) {
				Remarks = appendString(Remarks, "Format- Matched");

			} else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate RecordCreationTime field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateRecordCreationTime(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		String fieldName = "recordCreationTime";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String recordCreationTimeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (recordCreationTimeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + recordCreationTimeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(recordCreationTimeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (verifyDateFormat(recordCreationTimeVal, "HHmmss")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate RecordCreationMilliseconds field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateRecordCreationMilliseconds(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "recordCreationMilliseconds";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String recordCreationMillisecondsVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (recordCreationMillisecondsVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + recordCreationMillisecondsVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(recordCreationMillisecondsVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((verifyTextFormat(recordCreationMillisecondsVal, "[0-9]{3}|[\\s]{3}"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate GmtOffset field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateGMTOffset(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "gmtOffset";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String gmtOffsetVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (gmtOffsetVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + gmtOffsetVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(gmtOffsetVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (getValueOrFormat(fieldName, reqMap).trim().equals(gmtOffsetVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate CustomerIdFromHeader field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCustomerIdFromHeader(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "customerIdFromHeader";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String customerIdFromHeaderVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (customerIdFromHeaderVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + customerIdFromHeaderVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(customerIdFromHeaderVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (verifyTextFormat(customerIdFromHeaderVal.trim(), "^[A-Z]{2}[0-9]+$")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			if (customerIdFromHeaderVal.contains(countryCode)) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate CustomerAcctNumber field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCustomerAcctNumber(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "customerAcctNumber";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String customerAcctNumberVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (customerAcctNumberVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + customerAcctNumberVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(customerAcctNumberVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN")) {
				if (verifyTextFormat(customerAcctNumberVal.trim(), "^[A-Z]{2}[0-9]{11}$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

				if (customerAcctNumberVal.contains(countryCode)) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else
				if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {
					if (verifyTextFormat(customerAcctNumberVal.trim(), "^[A-Z]{2}[0-9]+$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}

					if (customerAcctNumberVal.contains(countryCode)) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate ExternalTransactionId field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateExternalTransactionId(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "externalTransactionId";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String externalTransactionId = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (externalTransactionId.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + externalTransactionId.trim() + "\"");
			if (sizeVal == getStringLen(externalTransactionId)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			// transaction_Id.add(externalTransactionId);
			int idCount = Collections.frequency(transaction_Id, externalTransactionId.trim());
			if (verifyTextFormat(externalTransactionId.trim(), "^[\\pN\\pL]+$") && idCount == 1
					&& (!externalTransactionId.trim().isEmpty())) {

				Remarks = appendString(Remarks, "Value is valid & Unique");
			} else {

				Remarks = appendString(Remarks, "Value is not unique/Valid");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate Pan field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePan(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "pan";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String panVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (panVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + panVal.trim() + "\"");
			if (sizeVal == getStringLen(panVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (verifyTextFormat(panVal.trim(), "^[0-9]+$") && (panVal.trim().length() >= 16)) {
				Remarks = appendString(Remarks, "Format - Matched");
			} else {
				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AuthPostFlag field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthPostFlag(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "authPostFlag";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String authPostFlagVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (authPostFlagVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authPostFlagVal.trim() + "\"");
			if (sizeVal == getStringLen(authPostFlagVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			AuthPostFlag = authPostFlagVal;

			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(authPostFlagVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");

			} else {
				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CardExpireDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCardExpireDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardExpireDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardExpireDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (cardExpireDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cardExpireDateVal.trim() + "\"");
			if (sizeVal == getStringLen(cardExpireDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (verifyDateFormat(cardExpireDateVal, "yyyyMMdd")) {
				Remarks = appendString(Remarks, "Format - Matched");
			} else {
				Remarks = appendString(Remarks, "Format - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TransactionDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "transactionDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + transactionDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (verifyDateFormat(transactionDateVal, "yyyyMMdd")) {

				Remarks = appendString(Remarks, "Format- Matched");

			} else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TransactionTime field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionTime(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "transactionTime";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionTimeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionTimeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + transactionTimeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(transactionTimeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (verifyDateFormat(transactionTimeVal, "HHmmss")) {

				Remarks = appendString(Remarks, "Format- Matched");

			} else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TransactionCurrencyCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionCurrencyCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "transactionCurrencyCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionCurrencyCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionCurrencyCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + transactionCurrencyCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionCurrencyCodeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			String transactionCurrecyCodeFormat = "[0-9]{3}$";
			if (verifyTextFormat(transactionCurrencyCodeVal, transactionCurrecyCodeFormat)) {
				Remarks = appendString(Remarks, "Format - Matched");
			} else {
				Remarks = appendString(Remarks, "Format - Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TransactionCurrencyConversionRate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionCurrencyConversionRate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "transactionCurrencyConversionRate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionCurrencyConversionRateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionCurrencyConversionRateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks,
						"Actual - \"" + transactionCurrencyConversionRateVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionCurrencyConversionRateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (transactionCurrencyConversionRateVal.equals("000001.000000")
					|| transactionCurrencyConversionRateVal.trim().equals("1.000000")) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AuthDecisionCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthDecisionCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "authDecisionCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String authDecisionCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (authDecisionCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authDecisionCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(authDecisionCodeVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			AuthDecisionCode = authDecisionCodeVal;

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(authDecisionCodeVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate AuthReversalReason field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthReversalReason(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "authReversalReason";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String authReversalReasonVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (authReversalReasonVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authReversalReasonVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(authReversalReasonVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(authReversalReasonVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate AuthCardIssuer field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthCardIssuer(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "authCardIssuer";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String authCardIssuerVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (authCardIssuerVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authCardIssuerVal.trim() + "\"");
			if (sizeVal == getStringLen(authCardIssuerVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(authCardIssuerVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET")) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(authCardIssuerVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CryptogramValid field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCryptogramValid(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cryptogramValid";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cryptogramValidVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (cryptogramValidVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cryptogramValidVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cryptogramValidVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("SPARROW")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (comparisonList.contains(cryptogramValidVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET") || sourceSystem.equals("TANDEM")) {
				if (cryptogramValidVal.equals(" ")) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate StandinAdvice field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateStandinAdvice(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "standinAdvice";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String standinAdvice = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (standinAdvice.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + standinAdvice.trim() + "\"");
			if (sizeVal == getStringLen(standinAdvice)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {
				if (standinAdvice.equals(" ")) {
					Remarks = appendString(Remarks, "Value Matched");
				} else {
					Remarks = appendString(Remarks, "Value Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (comparisonList.contains(standinAdvice.trim())) {
					Remarks = appendString(Remarks, "Value Matched");
				} else {
					Remarks = appendString(Remarks, "Value Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TransactionType field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionType(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "transactionType";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String transactionTypeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (transactionTypeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + transactionTypeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionTypeVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			TransactionType = transactionTypeVal;
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(transactionTypeVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate mcc field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateMCC(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "mcc";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String mccVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (mccVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + mccVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(mccVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			mcc = mccVal;
			if (!(verifyTextFormat(mccVal, "^\\s+$"))) {
				Remarks = appendString(Remarks, "Value is not blank");
				if (verifyTextFormat(mccVal.trim(), "^[\\pN]+$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Value is blank");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate PinVerifyCode field
	 * 
	 * @param transactionEntry,
	 *            reqMap, transactionCount
	 * @return void
	 */
	public void validatePinVerifyCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "pinVerifyCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String pinVerifyCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (pinVerifyCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + pinVerifyCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(pinVerifyCodeVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(pinVerifyCodeVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate PosEntryMode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePosEntryMode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "posEntryMode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String posEntryModeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (posEntryModeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + posEntryModeVal.trim() + "\"");
			if (sizeVal == getStringLen(posEntryModeVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(posEntryModeVal.trim()))
				Remarks = appendString(Remarks, "Value - Matched");
			else {
				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate PostDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePostDate(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "postDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String postDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (postDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + postDateVal.trim() + "\"");
			if (sizeVal == getStringLen(postDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (((AuthPostFlag).trim()).equals("P")) {
				if (verifyDateFormat(postDateVal, "yyyyMMdd"))
					Remarks = appendString(Remarks, "Date Format - Matched");
				else {
					Remarks = appendString(Remarks, "Date Format - Not Matched");
					FailCounter++;
				}
			} else if (((AuthPostFlag).trim()).equals("A")) {
				if (verifyTextFormat(postDateVal, "\\s{8}"))
					Remarks = appendString(Remarks, "Value is Blank");
				else {
					Remarks = appendString(Remarks, "Value is Not Blank");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Dependent field (AuthPostFlag) value is not proper");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate PadActionExpireDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePadActionExpireDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "padActionExpireDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String padActionExpireDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (padActionExpireDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + padActionExpireDate.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(padActionExpireDate)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (verifyDateFormat(padActionExpireDate, "yyyyMMdd") || padActionExpireDate.trim().isEmpty()) {

				Remarks = appendString(Remarks, "Format - Matched");

			} else {
				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate cvv2Present field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCvv2Present(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "cvv2Present";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cvv2PresentVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (cvv2PresentVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cvv2PresentVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cvv2PresentVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("EURONET")) || (sourceSystem.equals("SPARROW"))
					|| (sourceSystem.equals("TANDEM"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				cvv2Present = cvv2PresentVal;
				if (comparisonList.contains(cvv2PresentVal.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");

				} else {

					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
				rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}
		}
	}

	/**
	 * Description - To validate cvvVerifyCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCVVVerifyCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "cvvVerifyCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String cvvVerifyCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (cvvVerifyCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cvvVerifyCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cvvVerifyCodeVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {

				if (!(cvv2Present.equals(" "))) {

					if (!(cvvVerifyCodeVal.equals(" "))) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				} else {

					if ((cvv2Present.equals(" ")) && (cvvVerifyCodeVal.equals(" "))) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if ((sourceSystem.equals("EURONET")) || (sourceSystem.equals("SPARROW"))
					|| (sourceSystem.equals("TANDEM"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (!(cvv2Present.equals(" "))) {

					if (comparisonList.contains(cvvVerifyCodeVal.trim()) && (!(cvvVerifyCodeVal.equals(" ")))) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if ((cvv2Present.equals(" "))) {

						if (comparisonList.contains(cvvVerifyCodeVal.trim())) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					}
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate CustomerPresent field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCustomerPresent(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "customerPresent";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String customerPresentVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (customerPresentVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + customerPresentVal.trim() + "\"");
			if (sizeVal == getStringLen(customerPresentVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET")) || (sourceSystem.equals("TANDEM"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(customerPresentVal.trim()))
					Remarks = appendString(Remarks, "Value - Matched");
				else {

					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("SPARROW")) {

				if ((verifyTextFormat(customerPresentVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {
				Remarks = appendString(Remarks, "Invalid source system ");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate AtmOwner field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAtmOwner(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "atmOwner";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String atmOwnerVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (atmOwnerVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + atmOwnerVal.trim() + "\"");
			if (sizeVal == getStringLen(atmOwnerVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET")) || (sourceSystem.equals("TANDEM"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(atmOwnerVal.trim()))
					Remarks = appendString(Remarks, "Value - Matched");
				else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("SPARROW")) {

				if ((verifyTextFormat(atmOwnerVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {
				Remarks = appendString(Remarks, " Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate UserData01 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateUserData01(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "userData01";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String userData01Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (userData01Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + userData01Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(userData01Val)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (verifyDateFormat(userData01Val.trim(), "yyyyMMdd")) {

				Remarks = appendString(Remarks, "Format - Matched");

			} else {
				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate UserData02 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateUserData02(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) throws ParseException {

		String fieldName = "userData02";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String userData02Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (userData02Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + userData02Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(userData02Val)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (!(verifyTextFormat(userData02Val, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Value is not blank");

				if (verifyDateFormat(userData02Val.trim(), "HHmmss")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Value is blank");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate UserIndicator03 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateUserIndicator03(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "userIndicator03";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String userIndicator03Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (userIndicator03Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + userIndicator03Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(userIndicator03Val)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (verifyTextFormat(userIndicator03Val.trim(), "^[\\pN]+$")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate RealtimeRequest field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateRealtimeRequest(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "realtimeRequest";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String realtimeRequestVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (realtimeRequestVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + realtimeRequestVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(realtimeRequestVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("TANDEM"))) {

				if ((verifyTextFormat(realtimeRequestVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(realtimeRequestVal.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate CardAipStatic field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateCardAipStatic(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardAipStatic";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardAipStaticVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (cardAipStaticVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cardAipStaticVal.trim() + "\"");
			if (sizeVal == getStringLen(cardAipStaticVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(cardAipStaticVal.trim()))
				Remarks = appendString(Remarks, "Value - Matched");
			else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CardAipDynamic field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCardAipDynamic(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardAipDynamic";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardAipDynamicVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (cardAipDynamicVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cardAipDynamicVal.trim() + "\"");
			if (sizeVal == getStringLen(cardAipDynamicVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(cardAipDynamicVal.trim()))
				Remarks = appendString(Remarks, "Value - Matched");
			else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CardAipVerify field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCardAipVerify(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardAipVerify";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardAipVerifyVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (cardAipVerifyVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cardAipVerifyVal.trim() + "\"");
			if (sizeVal == getStringLen(cardAipVerifyVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(cardAipVerifyVal.trim()))
				Remarks = appendString(Remarks, "Value - Matched");
			else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CardAipRisk field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCardAipRisk(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardAipRisk";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardAipRiskVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (cardAipRiskVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cardAipRiskVal.trim() + "\"");
			if (sizeVal == getStringLen(cardAipRiskVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(cardAipRiskVal.trim()))
				Remarks = appendString(Remarks, "Value - Matched");
			else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CardAipIssuerAuthentication field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCardAipIssuerAuthentication(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardAipIssuerAuthentication";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardAipIssuerAuthenticationVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (cardAipIssuerAuthenticationVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cardAipIssuerAuthenticationVal.trim() + "\"");
			if (sizeVal == getStringLen(cardAipIssuerAuthenticationVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(cardAipIssuerAuthenticationVal.trim()))
				Remarks = appendString(Remarks, "Value - Matched");
			else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CardAipCombined field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCardAipCombined(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardAipCombined";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardAipCombinedVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (cardAipCombinedVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cardAipCombinedVal.trim() + "\"");
			if (sizeVal == getStringLen(cardAipCombinedVal)) {
				Remarks = Remarks + "Length - Matched \n";
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(cardAipCombinedVal.trim()))
				Remarks = appendString(Remarks, "Value - Matched");
			else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate cvv2Response field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCvv2Response(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cvv2Response";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cvv2ResponseVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (cvv2ResponseVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cvv2ResponseVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cvv2ResponseVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(cvv2ResponseVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TransactionCategory field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionCategory(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "transactionCategory";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionCategoryVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionCategoryVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + transactionCategoryVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(transactionCategoryVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(transactionCategoryVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AcquirerCountry field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAcquirerCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "acquirerCountry";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String acquirerCountryVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (acquirerCountryVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + acquirerCountryVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(acquirerCountryVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {
				if ((verifyTextFormat(acquirerCountryVal, "(\\s){3}"))) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else {
				String transactionCurrecyCodeFormat = "[0-9]{3}|[\\s]{3}$";
				if (verifyTextFormat(acquirerCountryVal, transactionCurrecyCodeFormat)) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Matched");
					FailCounter++;
				}
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TerminalType field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateterminalType(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "terminalType";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String terminalTypeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (terminalTypeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + terminalTypeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(terminalTypeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(terminalTypeVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TerminalEntryCapability field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateterminalEntryCapability(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "terminalEntryCapability";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String terminalEntryCapabilityVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (terminalEntryCapabilityVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + terminalEntryCapabilityVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(terminalEntryCapabilityVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(terminalEntryCapabilityVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate PosConditionCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePosConditionCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "posConditionCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String posConditionCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (posConditionCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + posConditionCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(posConditionCodeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(posConditionCodeVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate NetworkId field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateNetworkId(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "networkId";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String networkIdVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (networkIdVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + networkIdVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(networkIdVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(networkIdVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AuthExpireDateVerify field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthExpireDateVerify(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "authExpireDateVerify";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String authExpireDateVerifyVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (authExpireDateVerifyVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authExpireDateVerifyVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(authExpireDateVerifyVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (comparisonList.contains(authExpireDateVerifyVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AuthSecondaryVerify field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthSecondaryVerify(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "authSecondaryVerify";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String authSecondaryVerifyVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (authSecondaryVerifyVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authSecondaryVerifyVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(authSecondaryVerifyVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {
				if ((verifyTextFormat(authSecondaryVerifyVal, "(\\s){1}$"))) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (comparisonList.contains(authSecondaryVerifyVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AuthResponseCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthResponseCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "authResponseCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String authResponseCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (authResponseCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authResponseCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(authResponseCodeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);

			if (AuthDecisionCode.equals("A")) {
				if ((authResponseCodeVal.equals("A"))) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (AuthDecisionCode.equals("D")) {
				if ((!(authResponseCodeVal.equals("A"))) && ((comparisonList.contains(authResponseCodeVal.trim())))) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else {
				if (comparisonList.contains(authResponseCodeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CvrOfflinePinVerificationPerformed field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCvrOfflinePinVerificationPerformed(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "cvrOfflinePinVerificationPerformed";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cvrOfflinePinVerificationPerformedVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (cvrOfflinePinVerificationPerformedVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks,
						"Actual - \"" + cvrOfflinePinVerificationPerformedVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cvrOfflinePinVerificationPerformedVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			cvrOfflinePinVerificationPerformed = cvrOfflinePinVerificationPerformedVal;

			if (sourceSystem.equals("HOGAN")) {

				if ((verifyTextFormat(cvrOfflinePinVerificationPerformedVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if ((sourceSystem.equals("EURONET")) || (sourceSystem.equals("SPARROW"))
					|| (sourceSystem.equals("TANDEM"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (comparisonList.contains(cvrOfflinePinVerificationPerformedVal.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CvrPinTryLimitExceeded field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCvrPinTryLimitExceeded(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "cvrPinTryLimitExceeded";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cvrPinTryLimitExceededVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (cvrPinTryLimitExceededVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cvrPinTryLimitExceededVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cvrPinTryLimitExceededVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("TANDEM"))) {

				if ((verifyTextFormat(cvrPinTryLimitExceededVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if ((sourceSystem.equals("EURONET")) || (sourceSystem.equals("SPARROW"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (comparisonList.contains(cvrPinTryLimitExceededVal.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate PosUnattended field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePosUnattended(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "posUnattended";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String posUnattendedVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (posUnattendedVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + posUnattendedVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(posUnattendedVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(posUnattendedVal.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate PosCardCapture field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePosCardCapture(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "posCardCapture";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String posCardCaptureVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (posCardCaptureVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + posCardCaptureVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(posCardCaptureVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET")) || (sourceSystem.equals("TANDEM"))) {

				if ((verifyTextFormat(posCardCaptureVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("SPARROW")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (comparisonList.contains(posCardCaptureVal.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate PosSecurity field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePosSecurity(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "posSecurity";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String posSecurityVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (posSecurityVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + posSecurityVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(posSecurityVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("SPARROW"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (comparisonList.contains(posSecurityVal.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if ((sourceSystem.equals("EURONET")) || (sourceSystem.equals("TANDEM"))) {

				if ((verifyTextFormat(posSecurityVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate UserData06 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateUserData06(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "userData06";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String userData06 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (userData06.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + userData06.trim() + "\"");
			if (sizeVal == getStringLen(userData06)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (verifyDecimalFormat(userData06.trim())) {

				if (verifyNegativeNumber(userData06.trim())) {
					Remarks = appendString(Remarks, "Value is Negative");

					if (verifyTextFormat(userData06.trim(), "^[-]{1}[\\pN]+[.]{1}[\\pN]{2}$")
							&& !(verifyTextFormat(userData06.trim(), "^[-]{1}[0]+[.]{1}[\\pN]{2}$"))) {
						Remarks = appendString(Remarks, "Format Matched");

					} else {
						Remarks = appendString(Remarks, "Format Not Matched");
						FailCounter++;
					}
				} else {
					Remarks = appendString(Remarks, "Value is Positive");
					if (verifyTextFormat(userData06.trim(), "^[\\pN]+[.]{1}[\\pN]{2}$")) {
						Remarks = appendString(Remarks, "Format Matched");

					} else {
						Remarks = appendString(Remarks, "Format Not Matched");
						FailCounter++;
					}
				}

			} else {

				if (verifyNegativeNumber(userData06.trim())) {
					Remarks = appendString(Remarks, "Value is Negative");

					if (verifyTextFormat(userData06.trim(), "^[-]{1}[\\pN]+$")
							&& !(verifyTextFormat(userData06.trim(), "^[-]{1}[0]+$"))) {
						Remarks = appendString(Remarks, "Format Matched");

					} else {
						Remarks = appendString(Remarks, "Format Not Matched");
						FailCounter++;
					}
				} else {
					Remarks = appendString(Remarks, "Value is Positive");
					if (verifyTextFormat(userData06.trim(), "^[\\pN]+$")) {
						Remarks = appendString(Remarks, "Format Matched");

					} else {
						Remarks = appendString(Remarks, "Format Not Matched");
						FailCounter++;
					}
				}

			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CvrOfflinePinVerificationFailed field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCvrOfflinePinVerificationFailed(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "cvrOfflinePinVerificationFailed";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cvrOfflinePinVerificationFailedVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (cvrOfflinePinVerificationFailedVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cvrOfflinePinVerificationFailedVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cvrOfflinePinVerificationFailedVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("TANDEM"))) {

				if ((verifyTextFormat(cvrOfflinePinVerificationFailedVal, "^(\\s)$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if ((sourceSystem.equals("EURONET")) || (sourceSystem.equals("SPARROW"))) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);

				if (cvrOfflinePinVerificationPerformed.equals("0")) {

					if (cvrOfflinePinVerificationFailedVal.equals(" ")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}

				else {

					if (comparisonList.contains(cvrOfflinePinVerificationFailedVal.trim())) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate TransactionAmount field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateTransactionAmount(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "transactionAmount";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionAmountVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionAmountVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + transactionAmountVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(transactionAmountVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			String transactionAmountFormat = "^[0-9]+[.][0-9]{2}$";
			if (verifyDecimalFormat(transactionAmountVal)) {
				Remarks = appendString(Remarks, "Decimal format - Present");
			} else {
				Remarks = appendString(Remarks, "Decimal format - Not Present");
				FailCounter++;
			}
			if (verifyTextFormat(transactionAmountVal.trim(), transactionAmountFormat)) {
				Remarks = appendString(Remarks, "Format - Matched");
			} else {
				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AvailableBalance field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateAvailableBalance(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "availableBalance";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String availableBalanceVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (availableBalanceVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + availableBalanceVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(availableBalanceVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {
				if (!(availableBalanceVal.trim().isEmpty())) {

					if (verifyNegativeNumber(availableBalanceVal.trim())
							&& verifyTextFormat(availableBalanceVal.trim(), "^[-]{1}[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableBalanceVal)) {
						Remarks = appendString(Remarks, "Value is Negative");
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else if (verifyTextFormat(availableBalanceVal.trim(), "^[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableBalanceVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						
						FailCounter++;
					}

				} else if (availableBalanceVal.trim().isEmpty()) {

					Remarks = appendString(Remarks, "Value is blank");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET")) {

				if (!(availableBalanceVal.trim().isEmpty())) {

					if (verifyTextFormat(availableBalanceVal.trim(), "^[-+]{1}[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableBalanceVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else if (verifyTextFormat(availableBalanceVal.trim(), "^[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableBalanceVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
					
						FailCounter++;
					}

				} else if (availableBalanceVal.trim().isEmpty()) {

					Remarks = appendString(Remarks, "Value is blank");

				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate AvailableDailyCashLimit field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateAvailableDailyCashLimit(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "availableDailyCashLimit";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String availableDailyCashLimitVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (availableDailyCashLimitVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + availableDailyCashLimitVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(availableDailyCashLimitVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {
				if (!(availableDailyCashLimitVal.trim().isEmpty())) {

					if (verifyNegativeNumber(availableDailyCashLimitVal.trim())
							&& verifyTextFormat(availableDailyCashLimitVal.trim(), "^[-]{1}[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyCashLimitVal)) {
						Remarks = appendString(Remarks, "Value is Negative");
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else if (verifyTextFormat(availableDailyCashLimitVal.trim(), "^[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyCashLimitVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						
						FailCounter++;
					}

				} else if (availableDailyCashLimitVal.trim().isEmpty()) {

					Remarks = appendString(Remarks, "Value is blank");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET")) {

				if (!(availableDailyCashLimitVal.trim().isEmpty())) {

					if (verifyTextFormat(availableDailyCashLimitVal.trim(), "^[-+]{1}[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyCashLimitVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else if (verifyTextFormat(availableDailyCashLimitVal.trim(), "^[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyCashLimitVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
					
						FailCounter++;
					}

				} else if (availableDailyCashLimitVal.trim().isEmpty()) {

					Remarks = appendString(Remarks, "Value is blank");

				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}
			

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AvailableDailyMerchandiseLimit field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAvailableDailyMerchandiseLimit(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "availableDailyMerchandiseLimit";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String availableDailyMerchandiseLimitVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (availableDailyMerchandiseLimitVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + availableDailyMerchandiseLimitVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(availableDailyMerchandiseLimitVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {
				if (!(availableDailyMerchandiseLimitVal.trim().isEmpty())) {

					if (verifyNegativeNumber(availableDailyMerchandiseLimitVal.trim())
							&& verifyTextFormat(availableDailyMerchandiseLimitVal.trim(), "^[-]{1}[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyMerchandiseLimitVal)) {
						Remarks = appendString(Remarks, "Value is Negative");
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else if (verifyTextFormat(availableDailyMerchandiseLimitVal.trim(), "^[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyMerchandiseLimitVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						
						FailCounter++;
					}

				} else if (availableDailyMerchandiseLimitVal.trim().isEmpty()) {

					Remarks = appendString(Remarks, "Value is blank");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EURONET")) {

				if (!(availableDailyMerchandiseLimitVal.trim().isEmpty())) {

					if (verifyTextFormat(availableDailyMerchandiseLimitVal.trim(), "^[-+]{1}[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyMerchandiseLimitVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else if (verifyTextFormat(availableDailyMerchandiseLimitVal.trim(), "^[0-9]+[.][0-9]{2}$")
							&& verifyDecimalFormat(availableDailyMerchandiseLimitVal)) {
						Remarks = appendString(Remarks, "Format - Matched");
						
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
					
						FailCounter++;
					}

				} else if (availableDailyMerchandiseLimitVal.trim().isEmpty()) {

					Remarks = appendString(Remarks, "Value is blank");

				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}
			

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CashbackAmount field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCashbackAmount(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cashbackAmount";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cashbackAmount = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (cashbackAmount.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + cashbackAmount.trim() + "\"");
			if (sizeVal == getStringLen(cashbackAmount)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET"))) {

				if (TransactionType.equals("B")) {
					if (!((cashbackAmount.trim().isEmpty()))) {
						if (verifyDecimalFormat(cashbackAmount)
								&& !(verifyTextFormat(cashbackAmount, "^[0]+[.][0]{2}$"))) {
							if (verifyTextFormat(cashbackAmount.trim(), "^[0-9]+[.][0-9]{2}$")) {
								Remarks = appendString(Remarks, "Decimal & format - Matched");

							} else {
								Remarks = appendString(Remarks, "Decimal & format - Not Matched");
								FailCounter++;
							}
						} else {
							Remarks = appendString(Remarks, "Actual It is not Decimal number");
							FailCounter++;
						}
					} else {

						Remarks = appendString(Remarks, "Value is blank");
					}
				} else {

					if (!(cashbackAmount.trim().isEmpty())) {
						if (verifyDecimalFormat(cashbackAmount)) {
							if (verifyTextFormat(cashbackAmount.trim(), "^[0-9]+[.][0-9]{2}$")) {
								Remarks = appendString(Remarks, "Decimal & format - Matched");

							} else {
								Remarks = appendString(Remarks, "Decimal & format - Not Matched");
								FailCounter++;
							}
						} else {
							Remarks = appendString(Remarks, "Actual It is Not Decimal number");
							FailCounter++;
						}
					} else {
						Remarks = appendString(Remarks, "Actual Value is blank");
					}
				}
			} else if ((sourceSystem.equals("SPARROW")) || (sourceSystem.equals("TANDEM"))) {

				if ((verifyTextFormat(cashbackAmount, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}

			} else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate MerchantCountryCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateMerchantCountryCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "merchantCountryCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String merchantCountryCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (merchantCountryCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + merchantCountryCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(merchantCountryCodeVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (!(verifyTextFormat(merchantCountryCodeVal, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate Portfolio field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validatePortfolio(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "portfolio";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String portfolioName = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (portfolioName.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + portfolioName.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(portfolioName)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (!(verifyTextFormat(portfolioName, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");

			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate merchantName field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateMerchantName(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "merchantName";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String merchantName = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (merchantName.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + merchantName.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(merchantName)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET"))
					|| (sourceSystem.equals("SPARROW"))) {

				if (!(verifyTextFormat(merchantName, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Format - Matched");

				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate MerchantCity field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateMerchantCity(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "merchantCity";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String merchantCity = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (merchantCity.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + merchantCity.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(merchantCity)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET"))) {
				if (!(verifyTextFormat(merchantCity, "^\\s+$"))) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate MerchantState field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateMerchantState(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "merchantState";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String merchantStateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (merchantStateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + merchantStateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(merchantStateVal)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET"))) {
				if (!(verifyTextFormat(merchantStateVal, "^\\s+$"))) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate UserData05 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateUserData05(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "userData05";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String userData05Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (userData05Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + userData05Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(userData05Val)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EURONET"))
					|| (sourceSystem.equals("SPARROW"))) {

				if (!(verifyTextFormat(userData05Val, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Format - Matched");

				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/**
	 * Description - To validate MerchantId field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateMerchantId(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "merchantId";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String merchantId = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (merchantId.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + merchantId.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(merchantId)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {

				if (!(verifyTextFormat(merchantId, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Format - Matched");

				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate AuthPostMiscIndicator field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateAuthPostMiscIndicator(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "authPostMiscIndicator";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String authPostMiscIndicatorVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (authPostMiscIndicatorVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + authPostMiscIndicatorVal.trim() + "\"");
			if (sizeVal == getStringLen(authPostMiscIndicatorVal))
				Remarks = appendString(Remarks, "Length - Matched");
			else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (((AuthPostFlag).trim()).equals("P")) {
				if (authPostMiscIndicatorVal.trim().equals("Y") || authPostMiscIndicatorVal.trim().equals("N"))
					Remarks = appendString(Remarks, "Value - Matched");
				else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (((AuthPostFlag).trim()).equals("A")) {
				if (authPostMiscIndicatorVal.equals(" "))
					Remarks = appendString(Remarks, "Value is blank");
				else {
					Remarks = appendString(Remarks, "Value is not blank");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid value");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
}
