package fileValidations;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import utils.Report;
import utils.Wrappers;

public class RBTRAN21 extends Wrappers {

	Report rp = new Report();

	/**
	 * Description - To call all field level validation methods
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateRBTRAN21Transaction(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		validateWorkflow(transactionEntry, reqMap, transactionCount);
		validateRecordType(transactionEntry, reqMap, transactionCount);
		validateDataSpecificationVersion(transactionEntry, reqMap, transactionCount);
		validateClientIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateRecordCreationDate(transactionEntry, reqMap, transactionCount);
		validateRecordCreationTime(transactionEntry, reqMap, transactionCount);
		validateGMTOffset(transactionEntry, reqMap, transactionCount);
		validateCustomerIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateCustomerAcctNumber(transactionEntry, reqMap, transactionCount);
		validateExternalTransactionId(transactionEntry, reqMap, transactionCount);
		validateDepositWithdrawalFlag(transactionEntry, reqMap, transactionCount);
		validatePaymentOrderFlag(transactionEntry, reqMap, transactionCount);
		validateCreditCustomerId(transactionEntry, reqMap, transactionCount);
		validateCreditAcctNumber(transactionEntry, reqMap, transactionCount);
		validateCreditAcctCountry(transactionEntry, reqMap, transactionCount);
		validateCreditSegmentLevel(transactionEntry, reqMap, transactionCount);
		validateCreditAmount(transactionEntry, reqMap, transactionCount);
		validateCreditCurrencyCode(transactionEntry, reqMap, transactionCount);
		validateCreditDate(transactionEntry, reqMap, transactionCount);
		validateExchangeRate(transactionEntry, reqMap, transactionCount);
		validateTransactionReferenceNumber(transactionEntry, reqMap, transactionCount);
		validateTransactionDate(transactionEntry, reqMap, transactionCount);
		validateTransactionAmount(transactionEntry, reqMap, transactionCount);
		validateTransactionCurrencyCode(transactionEntry, reqMap, transactionCount);
		validateTransactionCurrencyConversionRate(transactionEntry, reqMap, transactionCount);
		validateTransactionType(transactionEntry, reqMap, transactionCount);
		validateAccessChannel(transactionEntry, reqMap, transactionCount);
		validateProcessingChannel(transactionEntry, reqMap, transactionCount);
		validateProcessingType(transactionEntry, reqMap, transactionCount);
		validateInternationalIndicator(transactionEntry, reqMap, transactionCount);
		validateDecision(transactionEntry, reqMap, transactionCount);
	}

	/**
	 * Description - To validate WorkFlow field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateWorkflow(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "workflow";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String workflow = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (workflow.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + workflow.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(workflow)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {

				if ((countryCode.equals("MY")) && (sourceSystem.equals("CCMS"))) {

					if (workflow.trim().equals("MALAYCREDIT")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if ((countryCode.equals("HK")) && (sourceSystem.equals("CCMS"))) {

					if (workflow.trim().equals("HKCREDIT")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (workflow.trim().equals("APACCREDIT")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("C400")) {

				String[] workflowC400Format = { "BD", "LK", "NP", "PK", "VN" };
				List<String> c400CountryList = createListForComparison(workflowC400Format);
				if (c400CountryList.contains(countryCode)) {

					if (workflow.trim().equals("APACCREDIT")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (workflow.trim().equals("ICM")) {

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
	 * Description - To validate RecordType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateRecordType(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "recordType";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String recordtype = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (recordtype.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + recordtype.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(recordtype)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(recordtype.trim())) {
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
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateDataSpecificationVersion(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "dataSpecificationVersion";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String dataSpecificationVersion = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (dataSpecificationVersion.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + dataSpecificationVersion.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(dataSpecificationVersion)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (getValueOrFormat(fieldName, reqMap).trim().equals(dataSpecificationVersion.trim())) {

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
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateClientIdFromHeader(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "clientIdFromHeader";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String clientIdFromHeader = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (clientIdFromHeader.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + clientIdFromHeader.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			String CCMS_clientIdFormat = "SC_" + sourceSystem + countryCode + "_DB";
			String C400_clientIdFormat = "SC_" + sourceSystem + countryCode + "_CR";
			if (sizeVal == getStringLen(clientIdFromHeader)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {
				if (clientIdFromHeader.trim().equals(CCMS_clientIdFormat)) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				if (clientIdFromHeader.trim().equals(C400_clientIdFormat)) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not matched");
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
	 * Description - To validate RecordCreationDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateRecordCreationDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "recordCreationDate";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String recordCreationDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (recordCreationDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + recordCreationDate.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(recordCreationDate)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (verifyDateFormat(recordCreationDate, "yyyyMMdd")) {

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
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateRecordCreationTime(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		String fieldName = "recordCreationTime";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String recordCreationTime = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (recordCreationTime.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + recordCreationTime.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(recordCreationTime)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (verifyDateFormat(recordCreationTime, "HHmmss")) {

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
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateGMTOffset(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "gmtOffset";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String gmtOffset = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (gmtOffset.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + gmtOffset.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(gmtOffset)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(gmtOffset.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate CustomerIdFromHeader field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCustomerIdFromHeader(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "customerIdFromHeader";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String customerIdFromHeader = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (customerIdFromHeader.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + customerIdFromHeader.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(customerIdFromHeader)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (verifyTextFormat(customerIdFromHeader.trim(), "^[A-Z]{2}[0-9]+$")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			if (customerIdFromHeader.contains(countryCode)) {

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
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCustomerAcctNumber(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "customerAcctNumber";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String customerAcctNumber = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (customerAcctNumber.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + customerAcctNumber.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(customerAcctNumber)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (verifyTextFormat(customerAcctNumber.trim(), "^[A-Z]{2}[0-9]+$")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			if (customerAcctNumber.contains(countryCode)) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate ExternalTransactionId field
	 * @param transactionEntry, reqMap, transactionCount
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
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + externalTransactionId.trim() + "\"");
			if (sizeVal == getStringLen(externalTransactionId)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			//transaction_Id.add(externalTransactionId);
			int idCount = Collections.frequency(transaction_Id, externalTransactionId.trim());
			if ((verifyTextFormat(externalTransactionId.trim(), "^[\\pN\\pL]+$")) && (idCount == 1) && (!externalTransactionId.trim().isEmpty())){

				Remarks = appendString(Remarks, "Value is valid & Unique");
			} else {

				Remarks = appendString(Remarks, "Value is not unique/Valid");
				FailCounter++;}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate DepositWithdrawalFlag field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateDepositWithdrawalFlag(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "depositWithdrawalFlag";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String depositWithdrawalFlag = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (depositWithdrawalFlag.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + depositWithdrawalFlag.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(depositWithdrawalFlag)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(depositWithdrawalFlag.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(depositWithdrawalFlag)) {

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
	 * Description - To validate PaymentOrderFlag field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePaymentOrderFlag(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "paymentOrderFlag";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String paymentOrderFlag = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (paymentOrderFlag.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + paymentOrderFlag.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(paymentOrderFlag)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(paymentOrderFlag.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate CreditCustomerId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditCustomerId(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditCustomerId";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditCustomerId = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditCustomerId.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditCustomerId.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(creditCustomerId)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {

				if (!(verifyTextFormat(creditCustomerId, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				if (verifyTextFormat(creditCustomerId.trim(), "^[A-Z]{2}[0-9]+$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

				if (creditCustomerId.contains(countryCode)) {

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
	 * Description - To validate CreditAcctNumber field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditAcctNumber(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditAcctNumber";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditAcctNumber = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditAcctNumber.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditAcctNumber.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(creditAcctNumber)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {

				if (!(verifyTextFormat(creditAcctNumber, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				if (verifyTextFormat(creditAcctNumber.trim(), "^[A-Z]{2}[0-9]+$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

				if (creditAcctNumber.contains(countryCode)) {

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
	 * Description - To validate CreditAcctCountry field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditAcctCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditAcctCountry";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditSegmentLevel = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditSegmentLevel.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditSegmentLevel.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(creditSegmentLevel)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			String creditAcctCountryValue = "";

			if (countryCode.equals("HK"))
				creditAcctCountryValue = "344";
			else if (countryCode.equals("ID"))
				creditAcctCountryValue = "360";
			else if (countryCode.equals("TH"))
				creditAcctCountryValue = "764";
			else if (countryCode.equals("SG"))
				creditAcctCountryValue = "702";
			else if (countryCode.equals("PH"))
				creditAcctCountryValue = "608";
			else if (countryCode.equals("IN"))
				creditAcctCountryValue = "356";
			else if (countryCode.equals("TW"))
				creditAcctCountryValue = "158";
			else if (countryCode.equals("MY"))
				creditAcctCountryValue = "458";

			if (sourceSystem.equals("CCMS")) {

				if (creditSegmentLevel.trim().equals(creditAcctCountryValue)) {

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
	 * Description - To validate CreditSegmentLevel field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditSegmentLevel(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditSegmentLevel";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditSegmentLevel = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditSegmentLevel.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditSegmentLevel.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(creditSegmentLevel)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(creditSegmentLevel.trim())) {

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
	 * Description - To validate CreditAmount field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditAmount(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditAmount";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditAmount = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditAmount.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditAmount.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(creditAmount)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			String transactionAmountFormat = "^[0-9]+[.][0-9]{2}$";
			if (verifyDecimalFormat(creditAmount)) {

				Remarks = appendString(Remarks, "Decimal format - Present");
			} else {

				Remarks = appendString(Remarks, "Decimal format - Not Present");
				FailCounter++;
			}

			if (verifyTextFormat(creditAmount.trim(), transactionAmountFormat)) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate CreditCurrencyCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditCurrencyCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditCurrencyCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditCurrencyCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditCurrencyCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditCurrencyCode.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(creditCurrencyCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			String creditAcctCountryValue = "";

			if (countryCode.equals("HK"))
				creditAcctCountryValue = "344";
			else if (countryCode.equals("ID"))
				creditAcctCountryValue = "360";
			else if (countryCode.equals("TH"))
				creditAcctCountryValue = "764";
			else if (countryCode.equals("SG"))
				creditAcctCountryValue = "702";
			else if (countryCode.equals("PH"))
				creditAcctCountryValue = "608";
			else if (countryCode.equals("IN"))
				creditAcctCountryValue = "356";
			else if (countryCode.equals("TW"))
				creditAcctCountryValue = "158";
			else if (countryCode.equals("MY"))
				creditAcctCountryValue = "458";

			if (sourceSystem.equals("CCMS")) {

				if (creditCurrencyCode.trim().equals(creditAcctCountryValue)) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				if (verifyTextFormat(creditCurrencyCode, "[0-9]{3}$")) {

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
	 * Description - To validate CreditDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditDate(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "creditDate";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditDate.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(creditDate)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (verifyDateFormat(creditDate, "yyyyMMdd")) {

				Remarks = appendString(Remarks, "Format- Matched");
			} else {

				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate ExchangeRate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateExchangeRate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "exchangeRate";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String exchangeRate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (exchangeRate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + exchangeRate.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(exchangeRate)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(exchangeRate.trim())) {

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
	 * Description - To validate TransactionReferenceNumber field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionReferenceNumber(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "transactionReferenceNumber";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionReferenceNumber = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (transactionReferenceNumber.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + transactionReferenceNumber.trim() + "\"");
			if (sizeVal == getStringLen(transactionReferenceNumber)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			//transactionRefNumber.add(transactionReferenceNumber);
			int idCount = Collections.frequency(transactionRefNumber, transactionReferenceNumber.trim());
			if ((verifyTextFormat(transactionReferenceNumber.trim(), "^[\\pN\\pL]+$")) && (idCount == 1) && (!transactionReferenceNumber.trim().isEmpty())){

				Remarks = appendString(Remarks, "Value is valid & Unique");
			} else {

				Remarks = appendString(Remarks, "Value is not unique/Valid");
				FailCounter++;}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate TransactionDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "transactionDate";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + transactionDate.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(transactionDate)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (verifyDateFormat(transactionDate, "yyyyMMdd")) {

				Remarks = appendString(Remarks, "Format- Matched");
			} else {

				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate TransactionAmount field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionAmount(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "transactionAmount";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionAmount = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionAmount.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + transactionAmount.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(transactionAmount)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			String transactionAmountFormat = "^[0-9]+[.][0-9]{2}$";
			if (verifyDecimalFormat(transactionAmount)) {

				Remarks = appendString(Remarks, "Decimal format - Present");
			} else {

				Remarks = appendString(Remarks, "Decimal format - Not Present");
				FailCounter++;
			}

			if (verifyTextFormat(transactionAmount.trim(), transactionAmountFormat)) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate TransactionCurrencyCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionCurrencyCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "transactionCurrencyCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionCurrencyCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionCurrencyCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + transactionCurrencyCode.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionCurrencyCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			String creditAcctCountryValue = "";
			if (countryCode.equals("HK"))
				creditAcctCountryValue = "344";
			else if (countryCode.equals("ID"))
				creditAcctCountryValue = "360";
			else if (countryCode.equals("TH"))
				creditAcctCountryValue = "764";
			else if (countryCode.equals("SG"))
				creditAcctCountryValue = "702";
			else if (countryCode.equals("PH"))
				creditAcctCountryValue = "608";
			else if (countryCode.equals("IN"))
				creditAcctCountryValue = "356";
			else if (countryCode.equals("TW"))
				creditAcctCountryValue = "158";
			else if (countryCode.equals("MY"))
				creditAcctCountryValue = "458";

			if (sourceSystem.equals("CCMS")) {

				if (transactionCurrencyCode.trim().equals(creditAcctCountryValue)) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				if (verifyTextFormat(transactionCurrencyCode, "[0-9]{3}$")) {

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
	 * Description - To validate TransactionCurrencyConversionRate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionCurrencyConversionRate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "transactionCurrencyConversionRate";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionCurrencyConversionRate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionCurrencyConversionRate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + transactionCurrencyConversionRate.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionCurrencyConversionRate)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(transactionCurrencyConversionRate.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate TransactionType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionType(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "transactionType";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String transactionType = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (transactionType.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + transactionType.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionType)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(transactionType.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate AccessChannel field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAccessChannel(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "accessChannel";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String accessChannel = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (accessChannel.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + accessChannel.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(accessChannel)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(accessChannel.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate ProcessingChannel field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateProcessingChannel(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "processingChannel";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String processingChannel = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (processingChannel.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + processingChannel.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(processingChannel)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (getValueOrFormat(fieldName, reqMap).trim().equals(processingChannel.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate ProcessingType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateProcessingType(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "processingType";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String processingType = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (processingType.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + processingType.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(processingType)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("C400")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(processingType)) {

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
	 * Description - To validate InternationalIndicator field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateInternationalIndicator(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "internationalIndicator";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String internationalIndicator = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (internationalIndicator.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + internationalIndicator.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(internationalIndicator)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("C400")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(internationalIndicator.trim())) {

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
	 * Description - To validate Decision field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateDecision(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "decision";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String decision = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (decision.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + decision.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(decision)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("C400")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(decision.trim())) {
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
}