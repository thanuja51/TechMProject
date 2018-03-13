package fileValidations;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import utils.Report;
import utils.Wrappers;

public class AIS20 extends Wrappers {
	Report rp = new Report();

	public void validateAIS20Transaction(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		validateWorkflow(transactionEntry, reqMap, transactionCount);
		validateRecordType(transactionEntry, reqMap, transactionCount);
		validateDataSpecificationVersion(transactionEntry, reqMap, transactionCount);
		validateRecordCreationDate(transactionEntry, reqMap, transactionCount);
		validateRecordCreationTime(transactionEntry, reqMap, transactionCount);
		validateRecordCreationMilliseconds(transactionEntry, reqMap, transactionCount);
		validateGMTOffset(transactionEntry, reqMap, transactionCount);
		validateCustomerIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateCustomerAcctNumber(transactionEntry, reqMap, transactionCount);
		validateExternalTransactionId(transactionEntry, reqMap, transactionCount);
		validateType(transactionEntry, reqMap, transactionCount);
		validateOwnership(transactionEntry, reqMap, transactionCount);
		validateUsage(transactionEntry, reqMap, transactionCount);
		validateJointCustomerId(transactionEntry, reqMap, transactionCount);
		validateVipType(transactionEntry, reqMap, transactionCount);
		validateBankId(transactionEntry, reqMap, transactionCount);
		validateBranchId(transactionEntry, reqMap, transactionCount);
		validateBranchCountry(transactionEntry, reqMap, transactionCount);
		validateClientIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateBranchStateProvince(transactionEntry, reqMap, transactionCount);
		validateNumberOfPaymentIds(transactionEntry, reqMap, transactionCount);
		validateNumberOfAuthorizedUsers(transactionEntry, reqMap, transactionCount);
		validateOpenDate(transactionEntry, reqMap, transactionCount);
		validateCurrencyCode(transactionEntry, reqMap, transactionCount);
		validateCurrencyConversionRate(transactionEntry, reqMap, transactionCount);
		validateCreditLimit(transactionEntry, reqMap, transactionCount); // DOUBT
		validateOverdraftLimit(transactionEntry, reqMap, transactionCount);
		validateDailyCashLimit(transactionEntry, reqMap, transactionCount);
		validateHasDirectDeposit(transactionEntry, reqMap, transactionCount);
		validateHasOnlinePay(transactionEntry, reqMap, transactionCount);
		validateHasMobilePay(transactionEntry, reqMap, transactionCount);
		validateStatementAddressee(transactionEntry, reqMap, transactionCount);
		validateStatementStreetLine1(transactionEntry, reqMap, transactionCount);
		validateStatementStreetLine2(transactionEntry, reqMap, transactionCount);
		validateStatementStreetLine3(transactionEntry, reqMap, transactionCount);
		validateStatementStreetLine4(transactionEntry, reqMap, transactionCount);
		validateStatementCity(transactionEntry, reqMap, transactionCount);
		validateStatementStateProvince(transactionEntry, reqMap, transactionCount);
		validateStatementPostalCode(transactionEntry, reqMap, transactionCount);
		validateStatementCountryCode(transactionEntry, reqMap, transactionCount);
		validateStatementCyclePeriod(transactionEntry, reqMap, transactionCount);
		validateStatementDayOfMonth(transactionEntry, reqMap, transactionCount);
		validateNumberOfCyclesInactive(transactionEntry, reqMap, transactionCount);
		validateNumberOfCyclesDelinquent(transactionEntry, reqMap, transactionCount);
		validateDelinquentAmount(transactionEntry, reqMap, transactionCount);
		validateStatus(transactionEntry, reqMap, transactionCount);
		validateOverlimitFlag(transactionEntry, reqMap, transactionCount);
	}

	/*
	 * Description – To validate workflow field
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
			String workFlowVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (workFlowVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + workFlowVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(workFlowVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(workFlowVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {
				String[] workflowC400Format = { "BD", "LK", "NP", "PK", "VN" };
				List<String> c400CountryList = createListForComparison(workflowC400Format);
				if (c400CountryList.contains(countryCode)) {
					if (workFlowVal.trim().equals("APACCREDIT")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {
					if (workFlowVal.trim().equals("ICM")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("CCMS")) {
				if ((countryCode.equals("MY")) && (sourceSystem.equals("CCMS"))) {
					if (workFlowVal.trim().equals("MALAYCREDIT")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if ((countryCode.equals("HK")) && (sourceSystem.equals("CCMS"))) {
					if (workFlowVal.trim().equals("HKCREDIT")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {
					if (workFlowVal.trim().equals("APACCREDIT")) {
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

	/*
	 * Description – To validate recordType field
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

			if (getValueOrFormat(fieldName, reqMap).trim().equals(recordtypeval.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate dataSpecificationVersion field
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

	/*
	 * Description – To validate recordCreationDate field
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

	/*
	 * Description – To validate recordCreationTime field
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

	/*
	 * Description – To validate recordCreationMilliseconds field 
	 * @param transactionEntry, reqMap, transactionCount
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

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				if ((verifyTextFormat(recordCreationMillisecondsVal, "[0-9]{3}|[\\s]{3}"))) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP")) {
				if ((verifyTextFormat(recordCreationMillisecondsVal, "[\\s]{3}"))) {

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

	/*
	 * Description – To validate gmtOffset field
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
				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			if (verifyTextFormat(gmtOffsetVal, "^(\\+)([0-9]{2}(\\.\\d{2}))$")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}

	/*
	 * Description – To validate customerIdFromHeader field
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

	/*
	 * Description – To validate customerAcctNumber field
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
			} else if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")
					|| sourceSystem.equals("C400")) {
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

			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate externalTransactionId field
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
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + externalTransactionId.trim() + "\"");
			if (sizeVal == getStringLen(externalTransactionId)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

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

	/*
	 * Description – To validate type field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateType(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "type";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String typeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (typeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + typeVal.trim() + "\"");
			if (sizeVal == getStringLen(typeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(typeVal.trim())) {
					Remarks = appendString(Remarks, "Value – Matched");

				} else {
					Remarks = appendString(Remarks, "Value – Not Matched");
					FailCounter++;
				}

			} else if (sourceSystem.equals("CCMS") || sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(typeVal.trim())) {
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

	/*
	 * Description – To validate ownership field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOwnership(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "ownership";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String ownershipVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (ownershipVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + ownershipVal.trim() + "\"");
			if (sizeVal == getStringLen(ownershipVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("C400")
					|| sourceSystem.equals("TANDEM")) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(ownershipVal.trim())) {
					Remarks = appendString(Remarks, "Value – Matched");
				} else {
					Remarks = appendString(Remarks, "Value – Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate usage field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateUsage(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "usage";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String usageVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (usageVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + usageVal.trim() + "\"");
			if (sizeVal == getStringLen(usageVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (getValueOrFormat(fieldName, reqMap).trim().equals(usageVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate jointCustomerId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateJointCustomerId(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "jointCustomerId";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String jointCustomerIdVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (jointCustomerIdVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + jointCustomerIdVal.trim() + "\"");
			if (sizeVal == getStringLen(jointCustomerIdVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("C400")
					|| sourceSystem.equals("TANDEM")) {
				if (!(verifyTextFormat(jointCustomerIdVal, "^\\s+$"))) {

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

	/*
	 * Description – To validate vipType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateVipType(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "vipType";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String vipTypeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (vipTypeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + vipTypeVal.trim() + "\"");
			if (sizeVal == getStringLen(vipTypeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP") || sourceSystem.equals("C400")
					|| sourceSystem.equals("TANDEM")) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(vipTypeVal.trim())) {
					Remarks = appendString(Remarks, "Value – Matched");

				} else {
					Remarks = appendString(Remarks, "Value – Not Matched");
					FailCounter++;
				}

			} else if (sourceSystem.equals("HOGAN")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(vipTypeVal.trim())) {
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

	/*
	 * Description – To validate bankId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateBankId(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "bankId";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String bankIdVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (bankIdVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + bankIdVal.trim() + "\"");
			if (sizeVal == getStringLen(bankIdVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(bankIdVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			}

			else if (sourceSystem.equals("EDMP")) {
				if (!(verifyTextFormat(bankIdVal, "^\\s+$"))) {

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

	/*
	 * Description – To validate branchId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateBranchId(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "branchId";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String branchIdVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (branchIdVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + branchIdVal.trim() + "\"");
			if (sizeVal == getStringLen(branchIdVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("C400")
					|| sourceSystem.equals("TANDEM")) {
				if (!(verifyTextFormat(branchIdVal, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			}

			else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate branchCountry field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateBranchCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "branchCountry";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String branchCountryVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (branchCountryVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + branchCountryVal.trim() + "\"");
			if (sizeVal == getStringLen(branchCountryVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || sourceSystem.equals("C400")) {

				String branchCountryFormat = "[0-9]{3}$";
				if (verifyTextFormat(branchCountryVal, branchCountryFormat)) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Matched");
					FailCounter++;
				}

			} else if (sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(branchCountryVal.trim())) {
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

	/*
	 * Description – To validate clientIdFromHeader field
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
			String clientIdFromHeaderVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (clientIdFromHeaderVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + clientIdFromHeaderVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(clientIdFromHeaderVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))) {
				String clientIdFormat = "SC_" + sourceSystem + countryCode + "_CR";
				if (clientIdFromHeaderVal.trim().equals(clientIdFormat)) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				String clientIdFormat = "SC_" + "EURONET" + countryCode + "_DB";
				String clientIdFormat1 = "SC_" + "SPARROW" + countryCode + "_DB";
				if ((clientIdFromHeaderVal.trim().equals(clientIdFormat))
						|| (clientIdFromHeaderVal.trim().equals(clientIdFormat1))) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("TANDEM"))) {
				String clientIdFormat = "SC_" + sourceSystem + countryCode + "_DB";
				if (clientIdFromHeaderVal.trim().equals(clientIdFormat)) {
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

	/*
	 * Description – To validate branchStateProvince field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateBranchStateProvince(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "branchStateProvince";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String branchStateProvinceVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (branchStateProvinceVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + branchStateProvinceVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(branchStateProvinceVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(branchStateProvinceVal)) {
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

	/*
	 * Description – To validate numberOfPaymentIds field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNumberOfPaymentIds(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "numberOfPaymentIds";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String numberOfPaymentIdsVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (numberOfPaymentIdsVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + numberOfPaymentIdsVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(numberOfPaymentIdsVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM")) || (sourceSystem.equals("EDMP"))) {
				if (verifyTextFormat(numberOfPaymentIdsVal.trim(), "^[\\pN]+$")) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {
				if (getValueOrFormat(fieldName, reqMap).equals(numberOfPaymentIdsVal)) {
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

	/*
	 * Description – To validate numberOfAuthorizedUsers field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNumberOfAuthorizedUsers(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "numberOfAuthorizedUsers";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String numberOfAuthorizedUsersVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (numberOfAuthorizedUsersVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + numberOfAuthorizedUsersVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(numberOfAuthorizedUsersVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("EDMP"))) {
				if (verifyTextFormat(numberOfAuthorizedUsersVal.trim(), "^[\\pN]+$")) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {
				if (getValueOrFormat(fieldName, reqMap).equals(numberOfAuthorizedUsersVal)) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("TANDEM")) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(numberOfAuthorizedUsersVal.trim())) {
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

	/*
	 * Description – To validate openDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOpenDate(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "openDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String openDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (openDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + openDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(openDateVal))
				Remarks = appendString(Remarks, "Length - Matched");
			else {
				System.out.println("Length not matched");
				FailCounter++;
			}

			if (verifyDateFormat(openDateVal, "yyyyMMdd"))
				Remarks = appendString(Remarks, "Format- Matched");
			else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate status field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatus(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "status";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statusVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (statusVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + statusVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(statusVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			StatusFlag = statusVal;
			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(statusVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate currencyCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCurrencyCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "currencyCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String currencyCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (currencyCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + currencyCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(currencyCodeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || (sourceSystem.equals("C400")) || (sourceSystem.equals("HOGAN"))
					|| (sourceSystem.equals("CCMS"))) {
				String currencyCodeFormat = "[0-9]{3}$";
				if (verifyTextFormat(currencyCodeVal, currencyCodeFormat)) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).equals(currencyCodeVal)) {
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

	/*
	 * Description – To validate currencyConversionRate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCurrencyConversionRate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "currencyConversionRate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String currencyConversionRateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (currencyConversionRateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + currencyConversionRateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(currencyConversionRateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (currencyConversionRateVal.equals("000001.000000")
					|| currencyConversionRateVal.trim().equals("1.000000")) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate creditLimit field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditLimit(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditLimit";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditLimitVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (creditLimitVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + creditLimitVal.trim() + "\"");
			if (sizeVal == getStringLen(creditLimitVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("C400")) || (sourceSystem.equals("CCMS"))) {
				if (verifyTextFormat(creditLimitVal.trim(), "^[0-9]+$") || creditLimitVal.trim().isEmpty()) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format -Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN")) {
				if (verifyTextFormat(creditLimitVal.trim(), "^[0]+$")) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format -Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate overdraftLimit field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOverdraftLimit(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "overdraftLimit";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String overdraftLimitVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (overdraftLimitVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + overdraftLimitVal.trim() + "\"");
			if (sizeVal == getStringLen(overdraftLimitVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EDMP")) || (sourceSystem.equals("TANDEM"))) {
				if ((verifyTextFormat(overdraftLimitVal.trim(), "^[0-9]+$"))
						|| (verifyTextFormat(overdraftLimitVal, "^[\\s]+$"))) {
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

	/*
	 * Description – To validate dailyCashLimit field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateDailyCashLimit(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "dailyCashLimit";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String dailyCashLimitVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (dailyCashLimitVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + dailyCashLimitVal.trim() + "\"");
			if (sizeVal == getStringLen(dailyCashLimitVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS")) {
				if ((verifyTextFormat(dailyCashLimitVal.trim(), "^[0-9]+$"))
						|| (verifyTextFormat(dailyCashLimitVal, "^[\\s]+$"))) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format -Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate hasDirectDeposit field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateHasDirectDeposit(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "hasDirectDeposit";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String hasDirectDepositVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (hasDirectDepositVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + hasDirectDepositVal.trim() + "\"");
			if (sizeVal == getStringLen(hasDirectDepositVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(hasDirectDepositVal.trim())) {
					Remarks = appendString(Remarks, "Value – Matched");
				} else {
					Remarks = appendString(Remarks, "Value – Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate hasOnlinePay field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateHasOnlinePay(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "hasOnlinePay";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String hasOnlinePayVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (hasOnlinePayVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + hasOnlinePayVal.trim() + "\"");
			if (sizeVal == getStringLen(hasOnlinePayVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("C400")) || (sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(hasOnlinePayVal.trim())) {
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

	/*
	 * Description – To validate hasMobilePay field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateHasMobilePay(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "hasMobilePay";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String hasMobilePayVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (hasMobilePayVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + hasMobilePayVal.trim() + "\"");
			if (sizeVal == getStringLen(hasMobilePayVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("C400")) || (sourceSystem.equals("EDMP"))
					|| (sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(hasMobilePayVal.trim())) {
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

	/*
	 * Description – To validate statementAddressee field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementAddressee(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementAddressee";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementAddresseeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementAddresseeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementAddresseeVal.trim() + "\"");
			if (sizeVal == getStringLen(statementAddresseeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (!(verifyTextFormat(statementAddresseeVal, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate statementStreetLine1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementStreetLine1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementStreetLine1";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementStreetLine1Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementStreetLine1Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementStreetLine1Val.trim() + "\"");
			if (sizeVal == getStringLen(statementStreetLine1Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (!(verifyTextFormat(statementStreetLine1Val, "^\\s+$"))) {
				Remarks = appendString(Remarks, "Format - Matched");
			} else {
				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate statementStreetLine2 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementStreetLine2(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementStreetLine2";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementStreetLine2Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementStreetLine2Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementStreetLine2Val.trim() + "\"");
			if (sizeVal == getStringLen(statementStreetLine2Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))
					|| (sourceSystem.equals("EDMP"))) {
				if (!(verifyTextFormat(statementStreetLine2Val, "^\\s+$"))) {
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

	/*
	 * Description – To validate statementStreetLine3 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementStreetLine3(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementStreetLine3";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementStreetLine3Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementStreetLine3Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementStreetLine3Val.trim() + "\"");
			if (sizeVal == getStringLen(statementStreetLine3Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))
					|| (sourceSystem.equals("EDMP"))) {
				if (!(verifyTextFormat(statementStreetLine3Val, "^\\s+$"))) {
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

	/*
	 * Description – To validate statementStreetLine4 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementStreetLine4(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementStreetLine4";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementStreetLine4Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementStreetLine4Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementStreetLine4Val.trim() + "\"");
			if (sizeVal == getStringLen(statementStreetLine4Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))) {
				if (!(verifyTextFormat(statementStreetLine4Val, "^\\s+$"))) {
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

	/*
	 * Description – To validate statementCity field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementCity(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementCity";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementCityVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementCityVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementCityVal.trim() + "\"");
			if (sizeVal == getStringLen(statementCityVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))
					|| (sourceSystem.equals("EDMP"))) {
				if (!(verifyTextFormat(statementCityVal, "^\\s+$"))) {
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

	/*
	 * Description – To validate statementStateProvince field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementStateProvince(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementStateProvince";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementStateProvinceVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementStateProvinceVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementStateProvinceVal.trim() + "\"");
			if (sizeVal == getStringLen(statementStateProvinceVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400")) || (sourceSystem.equals("EDMP"))) {
				if (!(verifyTextFormat(statementStateProvinceVal, "^\\s+$"))) {
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

	/*
	 * Description – To validate statementPostalCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementPostalCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementPostalCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementPostalCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (statementPostalCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + statementPostalCodeVal.trim() + "\"");
			if (sizeVal == getStringLen(statementPostalCodeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400")) || (sourceSystem.equals("EDMP"))
					|| (sourceSystem.equals("TANDEM"))) {
				if (!(verifyTextFormat(statementPostalCodeVal, "^\\s+$"))) {
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

	/*
	 * Description – To validate statementCountryCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementCountryCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementCountryCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementCountryCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (statementCountryCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + statementCountryCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(statementCountryCodeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(statementCountryCodeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if ((sourceSystem.equals("TANDEM")) || (sourceSystem.equals("C400"))) {
				if (!(verifyTextFormat(statementCountryCodeVal, "^\\s+$"))) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP") || (sourceSystem.equals("CCMS"))) {
				String statementCountryCodeFormat = "[0-9]{3}$";
				if (verifyTextFormat(statementCountryCodeVal, statementCountryCodeFormat)) {
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

	/*
	 * Description – To validate statementCyclePeriod field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementCyclePeriod(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementCyclePeriod";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementCyclePeriodVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (statementCyclePeriodVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + statementCyclePeriodVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(statementCyclePeriodVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS"))) {

				if (!(verifyTextFormat(statementCyclePeriodVal.trim(), "^[0]+$"))
						&& verifyTextFormat(statementCyclePeriodVal.trim(), "^[\\pN]+$")) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else
				if (sourceSystem.equals("EDMP") || (sourceSystem.equals("C400")) || (sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(statementCyclePeriodVal.trim())) {
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

	/*
	 * Description – To validate statementDayOfMonth field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatementDayOfMonth(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "statementDayOfMonth";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statementDayOfMonthVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (statementDayOfMonthVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + statementDayOfMonthVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(statementDayOfMonthVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))) {
				if (!(verifyTextFormat(statementDayOfMonthVal.trim(), "^[0]+$"))
						&& verifyTextFormat(statementDayOfMonthVal.trim(), "^[\\pN]+$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(statementDayOfMonthVal.trim())) {
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

	/*
	 * Description – To validate numberOfCyclesInactive field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNumberOfCyclesInactive(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "numberOfCyclesInactive";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String numberOfCyclesInactiveVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (numberOfCyclesInactiveVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + numberOfCyclesInactiveVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(numberOfCyclesInactiveVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))
					|| (sourceSystem.equals("EDMP"))) {
				if (verifyTextFormat(numberOfCyclesInactiveVal.trim(), "^[\\pN]+$")) {
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

	/*
	 * Description – To validate numberOfCyclesDelinquent field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNumberOfCyclesDelinquent(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "numberOfCyclesDelinquent";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String numberOfCyclesDelinquentVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (numberOfCyclesDelinquentVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + numberOfCyclesDelinquentVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(numberOfCyclesDelinquentVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))
					|| (sourceSystem.equals("EDMP"))) {
				if (verifyTextFormat(numberOfCyclesDelinquentVal.trim(), "^[\\pN]+$")) {
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

	/*
	 * Description – To validate delinquentAmount field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateDelinquentAmount(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "delinquentAmount";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String delinquentAmountVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (delinquentAmountVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + delinquentAmountVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(delinquentAmountVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			String delinquentAmountValFormat = "^[0-9]+[.][0-9]{2}$";

			if (!(verifyTextFormat(delinquentAmountVal, "^[\\s]+$"))) {

				if (verifyDecimalFormat(delinquentAmountVal)
						&& verifyTextFormat(delinquentAmountVal.trim(), delinquentAmountValFormat)) {
					Remarks = appendString(Remarks, "Decimal and format - Matched");
				} else {
					Remarks = appendString(Remarks, "Decimal and format - Not Matched");
					FailCounter++;
				}
			} else {
				Remarks = appendString(Remarks, "Format - Matched");
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/*
	 * Description – To validate overlimitFlag field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOverlimitFlag(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "overlimitFlag";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String overlimitFlagVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (overlimitFlagVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + overlimitFlagVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(overlimitFlagVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("C400")) || (sourceSystem.equals("EDMP"))
					|| (sourceSystem.equals("TANDEM"))) {
				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(overlimitFlagVal.trim())) {
					Remarks = appendString(Remarks, "Value – Matched");
				} else {
					Remarks = appendString(Remarks, "Value – Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS")) {
				if (StatusFlag.equals("03")) {
					if (overlimitFlagVal.equals("1")) {
						Remarks = appendString(Remarks, "Value – Matched");
					} else {
						Remarks = appendString(Remarks, "Value – Not Matched");
						FailCounter++;
					}
				} else {
					if (overlimitFlagVal.equals("0")) {
						Remarks = appendString(Remarks, "Value – Matched");
					} else {
						Remarks = appendString(Remarks, "Value – Not Matched");
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
}
