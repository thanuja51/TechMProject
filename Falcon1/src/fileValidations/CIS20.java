package fileValidations;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import utils.Report;
import utils.Wrappers;

public class CIS20 extends Wrappers {

	Report rp = new Report();

	/**
	 * Description - To call all field level validation methods
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCIS20Transaction(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {


		validateWorkflow(transactionEntry, reqMap, transactionCount);
		validateRecordType(transactionEntry, reqMap, transactionCount);
		validateDataSpecificationVersion(transactionEntry, reqMap, transactionCount);
		validateClientIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateRecordCreationDate(transactionEntry, reqMap, transactionCount);
		validateRecordCreationTime(transactionEntry, reqMap, transactionCount);
		validateRecordCreationMilliseconds(transactionEntry, reqMap, transactionCount);
		validateGMTOffset(transactionEntry, reqMap, transactionCount);
		validateCustomerIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateExternalTransactionId(transactionEntry, reqMap, transactionCount);
		validateVipType(transactionEntry, reqMap, transactionCount);
		validateRelationshipStartDate(transactionEntry, reqMap, transactionCount);
		validateNumberOfAccounts(transactionEntry, reqMap, transactionCount);
		validateGivenName(transactionEntry, reqMap, transactionCount);
		validateSurname(transactionEntry, reqMap, transactionCount);
		validateStreetLine1(transactionEntry, reqMap, transactionCount);
		validateStreetLine2(transactionEntry, reqMap, transactionCount);
		validateStreetLine3(transactionEntry, reqMap, transactionCount);
		validateCity(transactionEntry, reqMap, transactionCount);
		validateStateProvince(transactionEntry, reqMap, transactionCount);
		validatePostalCode(transactionEntry, reqMap, transactionCount);
		validateCountryCode(transactionEntry, reqMap, transactionCount);
		validateResidenceStatus(transactionEntry, reqMap, transactionCount);
		validateDateAtAddress(transactionEntry, reqMap, transactionCount);
		validateSecondaryAddrType(transactionEntry, reqMap, transactionCount);
		validateEmploymentStatus(transactionEntry, reqMap, transactionCount);
		validateEmploymentStartDate(transactionEntry, reqMap, transactionCount);
		validateIncome(transactionEntry, reqMap, transactionCount);
		validateCurrencyCode(transactionEntry, reqMap, transactionCount);
		validateCurrencyConversionRate(transactionEntry, reqMap, transactionCount);
		validatePreferredPhone(transactionEntry, reqMap, transactionCount);
		validateEmailAddress(transactionEntry, reqMap, transactionCount);
		validateEducationalStatus(transactionEntry, reqMap, transactionCount);
		validateBirthDate(transactionEntry, reqMap, transactionCount);
		validateBirthCountry(transactionEntry, reqMap, transactionCount);
		validateCitizenshipCountry(transactionEntry, reqMap, transactionCount);
		validateNationalIdCountry(transactionEntry, reqMap, transactionCount);
		validatePassportCountry(transactionEntry, reqMap, transactionCount);
		validateGender(transactionEntry, reqMap, transactionCount);
		validateMaritalStatus(transactionEntry, reqMap, transactionCount);
		validateNumberOfDependents(transactionEntry, reqMap, transactionCount);
		validateCreditScoreRequestReason(transactionEntry, reqMap, transactionCount);
		validatePefp(transactionEntry, reqMap, transactionCount);
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
			} else if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("TANDEM")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(workflow.trim())) {

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
			String clientIdFromHeader = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (clientIdFromHeader.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + clientIdFromHeader.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			String CCMS_C400_clientIdFormat = "SC_" + sourceSystem + countryCode + "_CR";
			String Hogan_Tandem_clientIdFormat = "SC_" + sourceSystem + countryCode + "_DB";
			String EDMP_clientIdFormat1 = "SC_EURONET" + countryCode + "_DB";
			String EDMP_clientIdFormat2 = "SC_SPARROW" + countryCode + "_DB";

			if (sizeVal == getStringLen(clientIdFromHeader)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS") || sourceSystem.equals("C400")) {

				if (clientIdFromHeader.trim().equals(CCMS_C400_clientIdFormat)) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN")|| sourceSystem.equals("TANDEM")) {

				if (clientIdFromHeader.trim().equals(Hogan_Tandem_clientIdFormat)) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not matched");
					FailCounter++;
				}
			} else if(sourceSystem.equals("EDMP")){
				if (clientIdFromHeader.trim().equals(EDMP_clientIdFormat1) || clientIdFromHeader.trim().equals(EDMP_clientIdFormat2)) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not matched");
					FailCounter++;
				}

			}else {

				Remarks = appendString(Remarks, "Invalid source system");
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
			String recordCreationDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (recordCreationDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + recordCreationDate.trim() + "\"");


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

			String recordCreationTime = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (recordCreationTime.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + recordCreationTime.trim() + "\"");


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

			String recordCreationMilliseconds = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (recordCreationMilliseconds.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + recordCreationMilliseconds.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(recordCreationMilliseconds)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				if ((verifyTextFormat(recordCreationMilliseconds, "[0-9]{3}|[\\s]{3}"))) {

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

			String gmtOffset = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (gmtOffset.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + gmtOffset.trim() + "\"");


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

			String customerIdFromHeader = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (customerIdFromHeader.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + customerIdFromHeader.trim() + "\"");


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
			//transaction_Id.add(externalTransactionId);
			int idCount = Collections.frequency(transaction_Id, externalTransactionId.trim());
			if (verifyTextFormat(externalTransactionId.trim(), "^[\\pN\\pL]+$") && idCount == 1 && (!externalTransactionId.trim().isEmpty())) {

				Remarks = appendString(Remarks, "Value is valid & Unique");
			} else {

				Remarks = appendString(Remarks, "Value is not unique/Valid");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate VipType field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateVipType(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "vipType";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String vipType = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (vipType.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + vipType.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(vipType)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(vipType.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(vipType.trim())) {

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
	 * Description - To validate RelationshipStartDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateRelationshipStartDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "relationshipStartDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String relationshipStartDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (relationshipStartDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + relationshipStartDate.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(relationshipStartDate)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (verifyDateFormat(relationshipStartDate, "yyyyMMdd")) {

				Remarks = appendString(Remarks, "Format- Matched");
			} else {

				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate NumberOfAccounts field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateNumberOfAccounts(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "numberOfAccounts";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String numberOfAccounts = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (numberOfAccounts.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + numberOfAccounts.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(numberOfAccounts)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (verifyTextFormat(numberOfAccounts.trim(), "^[\\pN]+$")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate GivenName field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateGivenName(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "givenName";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String givenName = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (givenName.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + givenName.trim() + "\"");
			if (sizeVal == getStringLen(givenName))
				Remarks = appendString(Remarks, "Length  - Matched");
			else {
				Remarks = appendString(Remarks, "Length  - Not Matched");
				FailCounter++;
			}
			if (!(verifyTextFormat(givenName, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate Surname field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateSurname(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "surname";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String surname = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (surname.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + surname.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(surname)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN")) {

				if (!(verifyTextFormat(surname, "^\\s+$"))) {

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
	 * Description - To validate StreetLine1 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateStreetLine1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "streetLine1";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String streetLine1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (streetLine1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + streetLine1.trim() + "\"");
			if (sizeVal == getStringLen(streetLine1))
				Remarks = appendString(Remarks, "Length  - Matched");
			else {
				Remarks = appendString(Remarks, "Length  - Not Matched");
				FailCounter++;
			}

			if (!(verifyTextFormat(streetLine1, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate StreetLine2 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateStreetLine2(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "streetLine2";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String streetLine2 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (streetLine2.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + streetLine2.trim() + "\"");
			if (sizeVal == getStringLen(streetLine2))
				Remarks = appendString(Remarks, "Length  - Matched");
			else {
				Remarks = appendString(Remarks, "Length  - Not Matched");
				FailCounter++;
			}
			if (!(verifyTextFormat(streetLine2, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate StreetLine3 field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateStreetLine3(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "streetLine3";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String streetLine3 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (streetLine3.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + streetLine3.trim() + "\"");
			if (sizeVal == getStringLen(streetLine3))
				Remarks = appendString(Remarks, "Length  - Matched");
			else {
				Remarks = appendString(Remarks, "Length  - Not Matched");
				FailCounter++;
			}
			if (!(verifyTextFormat(streetLine3, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate City field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCity(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "city";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String city = transactionEntry.substring(getStartIndex(fieldName, reqMap), getEndIndex(fieldName, reqMap));


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (city.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + city.trim() + "\"");
			if (sizeVal == getStringLen(city))
				Remarks = appendString(Remarks, "Length  - Matched");
			else {
				Remarks = appendString(Remarks, "Length  - Not Matched");
				FailCounter++;
			}
			if (!(verifyTextFormat(city, "^\\s+$"))) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate StateProvince field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */

	public void validateStateProvince(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "stateProvince";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String stateProvince = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (stateProvince.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + stateProvince.trim() + "\"");
			if (sizeVal == getStringLen(stateProvince))
				Remarks = appendString(Remarks, "Length  - Matched");
			else {
				Remarks = appendString(Remarks, "Length  - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				if (!(verifyTextFormat(stateProvince, "^\\s+$"))) {

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
	 * Description - To validate PostalCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePostalCode(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "postalCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String postalCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (postalCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + postalCode.trim() + "\"");
			if (sizeVal == getStringLen(postalCode))
				Remarks = appendString(Remarks, "Length  - Matched");
			else {
				Remarks = appendString(Remarks, "Length  - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				if (!(verifyTextFormat(postalCode, "^\\s+$"))) {

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
	 * Description - To validate CountryCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCountryCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "countryCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String countryCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (countryCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + countryCode.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(countryCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("CCMS")
					|| sourceSystem.equals("EDMP")) {

				if (verifyTextFormat(countryCode, "[0-9]{3}$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				if (!(verifyTextFormat(countryCode, "^\\s+$"))) {
					Remarks = appendString(Remarks, "Format -Matched");

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
	 * Description - To validate ResidenceStatus field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateResidenceStatus(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "residenceStatus";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String residenceStatus = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (residenceStatus.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + residenceStatus.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(residenceStatus)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("CCMS")
					|| sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(residenceStatus.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(residenceStatus.trim())) {

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
	 * Description - To validate DateAtAddress field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateDateAtAddress(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "dateAtAddress";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String dateAtAddress = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (dateAtAddress.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + dateAtAddress.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(dateAtAddress)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				if (verifyDateFormat(dateAtAddress, "yyyyMMdd")) {

					Remarks = appendString(Remarks, "Format- Matched");
				} else {

					Remarks = appendString(Remarks, "Format- Not matched");
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
	 * Description - To validate SecondaryAddrType field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateSecondaryAddrType(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "secondaryAddrType";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String secondaryAddrType = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (secondaryAddrType.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + secondaryAddrType.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(secondaryAddrType)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(secondaryAddrType.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(secondaryAddrType.trim())) {

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
	 * Description - To validate EmploymentStatus field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateEmploymentStatus(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "employmentStatus";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String employmentStatus = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (employmentStatus.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + employmentStatus.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(employmentStatus)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("EDMP")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(employmentStatus.trim())) {

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
	 * Description - To validate EmploymentStartDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateEmploymentStartDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "employmentStartDate";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String employmentStartDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (employmentStartDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + employmentStartDate.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(employmentStartDate)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || sourceSystem.equals("C400")) {

				if (verifyDateFormat(employmentStartDate, "yyyyMMdd") || employmentStartDate.trim().isEmpty()) {

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
	 * Description - To validate Income field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateIncome(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "income";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String income = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (income.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + income.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(income)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN")) {
				if (verifyTextFormat(income.trim(), "^[\\pN]+$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

			} else if (sourceSystem.equals("EDMP") || sourceSystem.equals("C400")
					|| sourceSystem.equals("TANDEM")) {

				if (verifyTextFormat(income, "^([\\pN]+|[\\s]+)$")) {

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
	 * Description - To validate CurrencyCode field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCurrencyCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "currencyCode";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String currencyCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (currencyCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + currencyCode.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(currencyCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(currencyCode.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400")) {

				if (verifyTextFormat(currencyCode, "[0-9]{3}$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(currencyCode.trim())) {

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
	 * Description - To validate CurrencyConversionRate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCurrencyConversionRate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "currencyConversionRate";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String currencyConversionRate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (currencyConversionRate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + currencyConversionRate.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(currencyConversionRate)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (currencyConversionRate.equals("000001.000000")
					|| currencyConversionRate.trim().equals("1.000000")) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate PreferredPhone field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePreferredPhone(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "preferredPhone";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String preferredPhone = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (preferredPhone.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + preferredPhone.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(preferredPhone)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("CCMS")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(preferredPhone.trim())) {

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
	 * Description - To validate EmailAddress field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateEmailAddress(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "emailAddress";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String emailAddress = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (emailAddress.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + emailAddress.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(emailAddress)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (verifyTextFormat(emailAddress.trim(), "^[A-Za-z0-9+_.-]+@(.+)$") || emailAddress.trim().isEmpty()) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}

	}
	/**
	 * Description - To validate EducationalStatus field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateEducationalStatus(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "educationalStatus";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String educationalStatus = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (educationalStatus.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + educationalStatus.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(educationalStatus)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(educationalStatus.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(educationalStatus.trim())) {

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
	 * Description - To validate BirthDate field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateBirthDate(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "birthDate";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String birthDate = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (birthDate.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + birthDate.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(birthDate)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (verifyDateFormat(birthDate, "yyyyMMdd")) {

				Remarks = appendString(Remarks, "Format- Matched");
			} else {

				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate BirthCountry field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateBirthCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "birthCountry";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String birthCountry = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (birthCountry.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + birthCountry.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(birthCountry)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("TANDEM")) {

				if (verifyTextFormat(birthCountry, "[0-9]{3}$")) {

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
	 * Description - To validate CitizenshipCountry field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCitizenshipCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "citizenshipCountry";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String citizenshipCountry = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (citizenshipCountry.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + citizenshipCountry.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(citizenshipCountry)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("EDMP") || sourceSystem.equals("C400")
					|| sourceSystem.equals("TANDEM")) {

				if (verifyTextFormat(citizenshipCountry, "[0-9]{3}$")) {

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
	 * Description - To validate NationalIdCountry field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateNationalIdCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "nationalIdCountry";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String nationalIdCountry = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (nationalIdCountry.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + nationalIdCountry.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(nationalIdCountry)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("CCMS")
					|| sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

				if (verifyTextFormat(nationalIdCountry, "[0-9]{3}$")) {

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
	 * Description - To validate PassportCountry field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePassportCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "passportCountry";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String passportCountry = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (passportCountry.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + passportCountry.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(passportCountry)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("EDMP")) {

				if (verifyTextFormat(passportCountry, "[0-9]{3}$")) {

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
	 * Description - To validate Gender field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateGender(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "gender";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String gender = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (gender.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + gender.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(gender)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(gender.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
	/**
	 * Description - To validate MaritalStatus field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateMaritalStatus(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "maritalStatus";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String maritalStatus = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (maritalStatus.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + maritalStatus.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(maritalStatus)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(maritalStatus.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate CreditScoreRequestReason field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validateCreditScoreRequestReason(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "creditScoreRequestReason";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String creditScoreRequestReason = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (creditScoreRequestReason.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + creditScoreRequestReason.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(creditScoreRequestReason)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("C400")
					|| sourceSystem.equals("TANDEM")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(creditScoreRequestReason.trim())) {

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
	 * Description - To validate pefp field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */
	public void validatePefp(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "pefp";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String pefp = transactionEntry.substring(getStartIndex(fieldName, reqMap), getEndIndex(fieldName, reqMap));

			if (pefp.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + pefp.trim() + "\"");


			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(pefp)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("EDMP")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(pefp.trim())) {

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
	 * Description - To validate NumberOfDependents field
	 * @param transactionEntry,reqMap, transactionCount
	 * @return void
	 */	
	public void validateNumberOfDependents(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "numberOfDependents";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String numberOfDependents = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (numberOfDependents.trim().equals(""))
				Remarks = appendString(Remarks, "Actual - \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual - \"" + numberOfDependents.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(numberOfDependents)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}
			if (sourceSystem.equals("HOGAN")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(numberOfDependents.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS")) {
				if (verifyTextFormat(numberOfDependents.trim(), "^[\\pN]+$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

			} else if(sourceSystem.equals("EDMP") || sourceSystem.equals("C400")){
				if (verifyTextFormat(numberOfDependents, "[\\pN]+|[\\s]+")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}

			}else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}
}
