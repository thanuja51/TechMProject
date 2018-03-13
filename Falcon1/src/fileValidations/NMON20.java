package fileValidations;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import utils.Report;
import utils.Wrappers;

public class NMON20 extends Wrappers {

	Report rp = new Report();

	/**
	 * Description - To call all field level validation methods
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNMON20Transaction(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		validateNonmonCode(transactionEntry, reqMap, transactionCount);
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
		validateTransactionDate(transactionEntry, reqMap, transactionCount);
		validateTransactionTime(transactionEntry, reqMap, transactionCount);
		validateNonmonCodeInitiator(transactionEntry, reqMap, transactionCount);		
		validateDecisionCode(transactionEntry, reqMap, transactionCount);
		validateContactMethod(transactionEntry, reqMap, transactionCount);
		validateContactMethodId(transactionEntry, reqMap, transactionCount);
		validateServiceRepresentativeId(transactionEntry, reqMap, transactionCount);
		validatePan(transactionEntry, reqMap, transactionCount);
		validatePaymentInstrumentId(transactionEntry, reqMap, transactionCount);
		validateNewPan(transactionEntry, reqMap, transactionCount);		
		validateNewPaymentInstrumentId(transactionEntry, reqMap, transactionCount);
		validateActionCode(transactionEntry, reqMap, transactionCount);
		validateNewEntityName(transactionEntry, reqMap, transactionCount);
		validateOldEntityName(transactionEntry, reqMap, transactionCount);
		validateNewStreetLine1(transactionEntry, reqMap, transactionCount);
		validateOldStreetLine1(transactionEntry, reqMap, transactionCount);
		validateNewStreetLine2(transactionEntry, reqMap, transactionCount);
		validateOldStreetLine2(transactionEntry, reqMap, transactionCount);
		validateNewStreetLine3(transactionEntry, reqMap, transactionCount);
		validateOldStreetLine3(transactionEntry, reqMap, transactionCount);
		validateNewStreetLine4(transactionEntry, reqMap, transactionCount);
		validateOldStreetLine4(transactionEntry, reqMap, transactionCount);
		validateNewCity(transactionEntry, reqMap, transactionCount);
		validateOldCity(transactionEntry, reqMap, transactionCount);
		validateNewStateProvince(transactionEntry, reqMap, transactionCount);
		validateOldStateProvince(transactionEntry, reqMap, transactionCount);
		validateNewPostalCode(transactionEntry, reqMap, transactionCount);
		validateOldPostalCode(transactionEntry, reqMap, transactionCount);
		validateNewCountryCode(transactionEntry, reqMap, transactionCount);
		validateOldCountryCode(transactionEntry, reqMap, transactionCount);
		validateNewPhone1(transactionEntry, reqMap, transactionCount);
		validateOldPhone1(transactionEntry, reqMap, transactionCount);
		validateNewEmailAddress(transactionEntry, reqMap, transactionCount);
		validateOldEmailAddress(transactionEntry, reqMap, transactionCount);
		validateNewDate1(transactionEntry, reqMap, transactionCount);
		validateOldDate1(transactionEntry, reqMap, transactionCount);
		validateNewDate2(transactionEntry, reqMap, transactionCount);
		validateOldDate2(transactionEntry, reqMap, transactionCount);
		validateNewCode1(transactionEntry, reqMap, transactionCount);		
		validateOldCode1(transactionEntry, reqMap, transactionCount);
		validateNewIndicator1(transactionEntry, reqMap, transactionCount);
		validateOldIndicator1(transactionEntry, reqMap, transactionCount);
		validateNewIndicator2(transactionEntry, reqMap, transactionCount);
		validateOldIndicator2(transactionEntry, reqMap, transactionCount);
		validateNewIndicator3(transactionEntry, reqMap, transactionCount);
		validateOldIndicator3(transactionEntry, reqMap, transactionCount);
		validateNewIndicator4(transactionEntry, reqMap, transactionCount);
		validateOldIndicator4(transactionEntry, reqMap, transactionCount);
		validateNewMonetaryValue(transactionEntry, reqMap, transactionCount);
		validateOldMonetaryValue(transactionEntry, reqMap, transactionCount);
		validateCurrencyCode(transactionEntry, reqMap, transactionCount);
		validateCurrencyConversionRate(transactionEntry, reqMap, transactionCount);
		validateNewNumericValue1(transactionEntry, reqMap, transactionCount);
		validateOldNumericValue1(transactionEntry, reqMap, transactionCount);

	}

	/**
	 * Description - To validate nonmonCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNonmonCode(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "nonmonCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String nonmonCode1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (nonmonCode1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + nonmonCode1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(nonmonCode1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			nonmonCode = nonmonCode1;

			List<String> comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(nonmonCode1.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate workflow field
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
			} else if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")
					|| sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

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
	 * Description - To validate recordType field
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
	 * Description - To validate dataSpecificationVersion field
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
	 * Description - To validate clientIdFromHeader field
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

			String HOGAN_CCMS_C400_clientIdFormat = "SC_" + sourceSystem + countryCode + "_CR";
			String Euronet_Sparrow_Tandem_clientIdFormat = "SC_" + sourceSystem + countryCode + "_DB";
			String EDMP_clientIdFormat = "SC_EURONET" + countryCode + "_DB";
			String EDMP_clientIdFormat1 = "SC_SPARROW" + countryCode + "_DB";

			if (sizeVal == getStringLen(clientIdFromHeader)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") ||sourceSystem.equals("CCMS") || sourceSystem.equals("C400")) {

				if (clientIdFromHeader.trim().equals(HOGAN_CCMS_C400_clientIdFormat)) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not matched");
					FailCounter++;
				}
			} else if ( sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")
					|| sourceSystem.equals("TANDEM")) {

				if (clientIdFromHeader.trim().equals(Euronet_Sparrow_Tandem_clientIdFormat)) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {

				if (clientIdFromHeader.trim().equals(EDMP_clientIdFormat)
						|| clientIdFromHeader.trim().equals(EDMP_clientIdFormat1)) {

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
	 * Description - To validate recordCreationDate field
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
	 * Description - To validate recordCreationTime field
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
				Remarks = appendString(Remarks, "Actual: \""+ recordCreationTime.trim() + "\"");

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
	 * Description - To validate recordCreationMilliseconds field
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

			String recordCreationMilliseconds = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (recordCreationMilliseconds.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + recordCreationMilliseconds.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(recordCreationMilliseconds)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(recordCreationMilliseconds.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}

			} else
				if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {

					if ((verifyTextFormat(recordCreationMilliseconds, "[0-9]{3}"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else if (sourceSystem.equals("C400")) {

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
	 * Description - To validate gmtOffset field
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

			if (verifyTextFormat(gmtOffset, "^(\\+)([0-9]{2}(\\.\\d{2}))$")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate customerIdFromHeader field
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
	 * Description - To validate customerAcctNumber field
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

			if (nonmonCode.trim().startsWith("3")) {

				if (!(verifyTextFormat(customerAcctNumber, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Value is not blank");

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
				} else {

					Remarks = appendString(Remarks, "Value is blank");
					FailCounter++;
				}
			} else if (nonmonCode.trim().startsWith("1")) {

				if ((verifyTextFormat(customerAcctNumber, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Value is blank");
				} else {

					Remarks = appendString(Remarks, "Value is not blank");
					FailCounter++;
				}
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				Remarks = appendString(Remarks, "Invalid nonmonCode - " + nonmonCode);
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate externalTransactionId field
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
	 * Description - To validate transactionDate field
	 *@param transactionEntry, reqMap, transactionCount
	 *@return void
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
	 * Description - To validate transactionTime field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateTransactionTime(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		String fieldName = "transactionTime";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String transactionTime = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (transactionTime.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \""+ transactionTime.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(transactionTime)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (verifyDateFormat(transactionTime, "HHmmss")) {

				Remarks = appendString(Remarks, "Format - Matched");
			} else {

				Remarks = appendString(Remarks, "Format - Not Matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate nonmonCodeInitiator field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNonmonCodeInitiator(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "nonmonCodeInitiator";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String nonmonCodeInitiator = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (nonmonCodeInitiator.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + nonmonCodeInitiator.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(nonmonCodeInitiator)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(nonmonCodeInitiator.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(nonmonCodeInitiator.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

				if (getValueOrFormat(fieldName, reqMap).trim().equals(nonmonCodeInitiator.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("C400")) {

				String[] nonmonCodeValues = { "1150", "1210", "1250", "3020", "3100", "3104", "3201" };
				List<String> nonmonCodeList = createListForComparison(nonmonCodeValues);
				if (nonmonCodeList.contains(nonmonCode)) {

					if (nonmonCodeInitiator.trim().equals("C")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3000") || nonmonCode.trim().equals("3102")) {

					if (nonmonCodeInitiator.trim().equals("B")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3010")) {

					if (nonmonCodeInitiator.trim().equals("B") || nonmonCodeInitiator.trim().equals("C")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (nonmonCodeInitiator.trim().isEmpty()) {

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
	 * Description - To validate decisionCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateDecisionCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "decisionCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String decisionCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (decisionCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + decisionCode.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(decisionCode)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (getValueOrFormat(fieldName, reqMap).trim().equals(decisionCode.trim())) {

				Remarks = appendString(Remarks, "Value - Matched");
			} else {

				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate contactMethod field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateContactMethod(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "contactMethod";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String contactMethod = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (contactMethod.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + contactMethod.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(contactMethod)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")
					|| sourceSystem.equals("C400")) {

				List<String> comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(contactMethod.trim())) {

					Remarks = appendString(Remarks, "Value - Matched");
				} else {

					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("3020")) {

					if (contactMethod.trim().equals("A")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (contactMethod.trim().isEmpty()) {

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
	 * Description - To validate contactMethodId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateContactMethodId(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "contactMethodId";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String contactMethodId = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (contactMethodId.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + contactMethodId.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(contactMethodId)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (!(verifyTextFormat(contactMethodId, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("3020")) {

					if (!(verifyTextFormat(contactMethodId, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (contactMethodId.trim().isEmpty()) {

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
	 * Description - To validate serviceRepresentativeId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateServiceRepresentativeId(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "serviceRepresentativeId";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String serviceRepresentativeId = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (serviceRepresentativeId.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + serviceRepresentativeId.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(serviceRepresentativeId)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {

				if (!(verifyTextFormat(serviceRepresentativeId, "^\\s+$"))) {

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
	 * Description - To validate pan field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePan(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "pan";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String pan = transactionEntry.substring(getStartIndex(fieldName, reqMap), getEndIndex(fieldName, reqMap));

			if (pan.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + pan.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(pan)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (nonmonCode.trim().startsWith("3")) {

				if (!(verifyTextFormat(pan, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Value is not blank");

					if (verifyTextFormat(pan.trim(), "^[0-9]+$") && (pan.trim().length() >= 16)) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					Remarks = appendString(Remarks, "Value is blank");
					FailCounter++;
				}
			} else if (nonmonCode.trim().startsWith("1")) {

				if ((verifyTextFormat(pan, "^\\s+$"))) {

					Remarks = appendString(Remarks, "Value is blank");
				} else {

					Remarks = appendString(Remarks, "Value is not blank");
					FailCounter++;
				}
			} else {

				Remarks = appendString(Remarks, "Value - Not Matched");
				Remarks = appendString(Remarks, "Invalid nonmonCode - " + nonmonCode);
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate paymentInstrumentId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePaymentInstrumentId(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "paymentInstrumentId";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String paymentInstrumentId = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (paymentInstrumentId.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + paymentInstrumentId.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(paymentInstrumentId)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {

				if (!(verifyTextFormat(paymentInstrumentId, "^\\s+$"))) {

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
	 * Description - To validate newPan field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewPan(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "newPan";
		if (reqMap.containsKey(fieldName)) {
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;

			String newPan = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newPan.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newPan.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newPan)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EURONET")
					|| sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("3000")) {

					if (verifyTextFormat(newPan.trim(), "^[0-9]+$") && (newPan.trim().length() >= 16)) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newPan.trim().isEmpty()) {

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
	 * Description - To validate newPaymentInstrumentId field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewPaymentInstrumentId(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newPaymentInstrumentId";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newPaymentInstrumentId = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newPaymentInstrumentId.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newPaymentInstrumentId.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newPaymentInstrumentId)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3000")) {

					if (!(verifyTextFormat(newPaymentInstrumentId, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newPaymentInstrumentId.trim().isEmpty()) {

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
	 * Description - To validate actionCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateActionCode(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "actionCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String actionCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (actionCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + actionCode.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(actionCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS")) {

				if (nonmonCode.trim().equals("3000")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(actionCode.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (actionCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("1250")) {

					if (actionCode.trim().equals("E0")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3000")) {

					if (actionCode.trim().equals("I1")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3020")) {

					if (actionCode.trim().equals("P0")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (actionCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {

				if (nonmonCode.trim().equals("3020")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(actionCode.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (actionCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EDMP")) {

				if (nonmonCode.trim().equals("1250")) {

					if (actionCode.trim().equals("E0")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (actionCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3000")) {

					String[] possibleValues = { "I1", "A1", "  " };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(actionCode)) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3020")) {

					String[] possibleValues = { "P0", "B1", "B0", "  " };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(actionCode)) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (actionCode.trim().isEmpty()) {

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
	 * Description - To validate newEntityName field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewEntityName(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newEntityName";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newEntityName = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newEntityName.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newEntityName.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newEntityName)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")
					|| sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("3000")) {

					if (!(verifyTextFormat(newEntityName, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newEntityName.trim().isEmpty()) {

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
	 * Description - To validate oldEntityName field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldEntityName(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldEntityName";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldEntityName = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldEntityName.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldEntityName.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldEntityName)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3000")) {

					if (!(verifyTextFormat(oldEntityName, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldEntityName.trim().isEmpty()) {

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
	 * Description - To validate newStreetLine1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewStreetLine1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newStreetLine1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newStreetLine1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newStreetLine1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newStreetLine1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newStreetLine1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(newStreetLine1, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newStreetLine1.trim().isEmpty()) {

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
	 * Description - To validate oldStreetLine1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldStreetLine1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldStreetLine1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldStreetLine1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldStreetLine1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldStreetLine1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldStreetLine1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(oldStreetLine1, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldStreetLine1.trim().isEmpty()) {

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
	 * Description - To validate newStreetLine2 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewStreetLine2(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newStreetLine2";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newStreetLine2 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newStreetLine2.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newStreetLine2.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newStreetLine2)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(newStreetLine2, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newStreetLine2.trim().isEmpty()) {

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
	 * Description - To validate oldStreetLine2 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldStreetLine2(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldStreetLine2";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldStreetLine2 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldStreetLine2.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldStreetLine2.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldStreetLine2)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(oldStreetLine2, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldStreetLine2.trim().isEmpty()) {

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
	 * Description - To validate newStreetLine3 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewStreetLine3(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newStreetLine3";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newStreetLine3 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newStreetLine3.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newStreetLine3.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newStreetLine3)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(newStreetLine3, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newStreetLine3.trim().isEmpty()) {

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
	 * Description - To validate oldStreetLine3 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldStreetLine3(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldStreetLine3";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldStreetLine3 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldStreetLine3.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldStreetLine3.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldStreetLine3)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(oldStreetLine3, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldStreetLine3.trim().isEmpty()) {

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
	 * Description - To validate newStreetLine4 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewStreetLine4(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newStreetLine4";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newStreetLine4 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newStreetLine4.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newStreetLine4.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newStreetLine4)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(newStreetLine4, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newStreetLine4.trim().isEmpty()) {

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
	 * Description - To validate oldStreetLine4 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldStreetLine4(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldStreetLine4";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldStreetLine4 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldStreetLine4.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldStreetLine4.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldStreetLine4)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("1150")) {

					if (!(verifyTextFormat(oldStreetLine4, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldStreetLine4.trim().isEmpty()) {

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
	 * Description - To validate newCity field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewCity(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "newCity";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newCity = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newCity.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newCity.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newCity)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(newCity, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCity.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(newCity, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCity.trim().isEmpty()) {

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
	 * Description - To validate oldCity field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldCity(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "oldCity";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldCity = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldCity.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldCity.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldCity)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(oldCity, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldCity.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(oldCity, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldCity.trim().isEmpty()) {

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
	 * Description - To validate newStateProvince field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewStateProvince(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newStateProvince";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newStateProvince = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newStateProvince.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newStateProvince.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newStateProvince)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(newStateProvince, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newStateProvince.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(newStateProvince, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newStateProvince.trim().isEmpty()) {

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
	 * Description - To validate oldStateProvince field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldStateProvince(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldStateProvince";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldStateProvince = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldStateProvince.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldStateProvince.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldStateProvince)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(oldStateProvince, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldStateProvince.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(oldStateProvince, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldStateProvince.trim().isEmpty()) {

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
	 * Description - To validate newPostalCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewPostalCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newPostalCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newPostalCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newPostalCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newPostalCode.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newPostalCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(newPostalCode, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newPostalCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(newPostalCode, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newPostalCode.trim().isEmpty()) {

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
	 * Description - To validate oldPostalCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldPostalCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldPostalCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldPostalCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldPostalCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldPostalCode.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldPostalCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3100")) {

					if (!(verifyTextFormat(oldPostalCode, "^\\s+$"))) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldPostalCode.trim().isEmpty()) {

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
	 * Description - To validate newCountryCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewCountryCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newCountryCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newCountryCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newCountryCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newCountryCode.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newCountryCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")  || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3000")
						|| nonmonCode.trim().equals("3100")) {

					if (verifyTextFormat(newCountryCode, "[0-9]{3}$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCountryCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("CCMS")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3000")) {

					if (verifyTextFormat(newCountryCode, "[0-9]{3}$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCountryCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EDMP")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3100")) {

					if (verifyTextFormat(newCountryCode, "[0-9]{3}$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCountryCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3000") || nonmonCode.trim().equals("3100")) {

					if (newCountryCode.trim().equals("158")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCountryCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EURONET")) {

				if( nonmonCode.trim().equals("3000")){

					if (verifyTextFormat(newCountryCode, "[0-9]{3}$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCountryCode.trim().isEmpty()) {

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
	 * Description - To validate oldCountryCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldCountryCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldCountryCode";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldCountryCode = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldCountryCode.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldCountryCode.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldCountryCode)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("1150") || nonmonCode.trim().equals("3000")
						|| nonmonCode.trim().equals("3100")) {

					if (verifyTextFormat(oldCountryCode, "[0-9]{3}$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldCountryCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3000") || nonmonCode.trim().equals("3100")) {

					if (oldCountryCode.trim().equals("158")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldCountryCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EURONET")) {

				if( nonmonCode.trim().equals("3000")){

					if (verifyTextFormat(oldCountryCode, "[0-9]{3}$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldCountryCode.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			}else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate newPhone1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewPhone1(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "newPhone1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newPhone1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newPhone1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newPhone1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newPhone1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("1210")) {

					if (verifyTextFormat(newPhone1.trim(), "^[0-9]+$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newPhone1.trim().isEmpty()) {

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
	 * Description - To validate oldPhone1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldPhone1(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "oldPhone1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldPhone1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldPhone1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldPhone1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldPhone1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("1210")) {

					if (verifyTextFormat(oldPhone1.trim(), "^[0-9]+$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldPhone1.trim().isEmpty()) {

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
	 * Description - To validate newEmailAddress field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewEmailAddress(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newEmailAddress";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newEmailAddress = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newEmailAddress.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newEmailAddress.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newEmailAddress)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP")
					|| sourceSystem.equals("TANDEM") || (sourceSystem.equals("C400"))) {

				if (nonmonCode.trim().equals("1250")) {

					if (verifyTextFormat(newEmailAddress.trim(), "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newEmailAddress.trim().isEmpty()) {

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
	 * Description - To validate oldEmailAddress field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldEmailAddress(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldEmailAddress";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldEmailAddress = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldEmailAddress.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldEmailAddress.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldEmailAddress)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("1250")) {

					if (verifyTextFormat(oldEmailAddress.trim(), "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldEmailAddress.trim().isEmpty()) {

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
	 * Description - To validate newDate1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewDate1(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "newDate1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newDate1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newDate1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newDate1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newDate1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("C400")) {

				String[] nonmonCodeValues = { "1150", "3000", "3010", "3020", "3102" };
				List<String> nonmonCodeList = createListForComparison(nonmonCodeValues);
				if (nonmonCodeList.contains(nonmonCode)) {

					if (verifyDateFormat(newDate1, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newDate1.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {

				String[] nonmonCodeValues = { "3000", "3010", "3020", "3102" };
				List<String> nonmonCodeList = createListForComparison(nonmonCodeValues);
				if (nonmonCodeList.contains(nonmonCode)) {

					if (verifyDateFormat(newDate1, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newDate1.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			}else if (sourceSystem.equals("CCMS") || sourceSystem.equals("HOGAN")) {

				String[] nonmonCodeValues = { "1150", "3000", "3020", "3102" };
				List<String> nonmonCodeList = createListForComparison(nonmonCodeValues);
				if (nonmonCodeList.contains(nonmonCode)) {

					if (verifyDateFormat(newDate1, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newDate1.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EDMP")) {

				if (nonmonCode.trim().equals("1150")) {

					if (verifyDateFormat(newDate1, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newDate1.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3000") || nonmonCode.trim().equals("3010")
						|| nonmonCode.trim().equals("3102")) {

					if (verifyDateFormat(newDate1, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newDate1.trim().isEmpty()) {

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
	 * Description - To validate oldDate1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldDate1(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "oldDate1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldDate1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldDate1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldDate1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldDate1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {

				String[] nonmonCodeValues = { "1150", "3020", "3102" };
				List<String> nonmonCodeList = createListForComparison(nonmonCodeValues);
				if (nonmonCodeList.contains(nonmonCode)) {

					if (verifyDateFormat(oldDate1, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldDate1.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {

				String[] nonmonCodeValues = { "3000", "3010", "3102" };
				List<String> nonmonCodeList = createListForComparison(nonmonCodeValues);
				if (nonmonCodeList.contains(nonmonCode)) {

					if (verifyDateFormat(oldDate1, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldDate1.trim().isEmpty()) {

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
	 * Description - To validate newDate2 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewDate2(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "newDate2";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newDate2 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newDate2.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newDate2.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newDate2)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("EURONET")
					|| sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {

				if (nonmonCode.trim().equals("3000") || nonmonCode.trim().equals("3010")) {

					if (verifyDateFormat(newDate2, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newDate2.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("3000")) {

					if (verifyDateFormat(newDate2, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newDate2.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			}else {

				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate oldDate2 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldDate2(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "oldDate2";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldDate2 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldDate2.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldDate2.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldDate2)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3000") || nonmonCode.trim().equals("3010")) {

					if (verifyDateFormat(oldDate2, "yyyyMMdd")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldDate2.trim().isEmpty()) {

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
	 * Description - To validate newCode1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewCode1(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "newCode1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newCode1 = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newCode1.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newCode1.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newCode1)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			String[] possibleValues = { "00", "11", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
					"31", "32", "40" };
			List<String> valueList = createListForComparison(possibleValues);

			if (sourceSystem.equals("CCMS")) {

				if (nonmonCode.trim().equals("3010")) {

					if (newCode1.trim().equals("B") || newCode1.trim().equals("N")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3102")) {

					if (valueList.contains(newCode1.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newCode1.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else
				if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {

					if (nonmonCode.trim().equals("3102")) {

						if (valueList.contains(newCode1.trim())) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					} else {

						if (newCode1.trim().isEmpty()) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					}
				} else if (sourceSystem.equals("TANDEM")) {

					String[] tandemPossibleValues = { "00", "27", "11", "20" };
					List<String> tandemValueList = createListForComparison(tandemPossibleValues);

					if (nonmonCode.trim().equals("3010")) {

						if (newCode1.trim().equals("N") || newCode1.trim().equals("DA")) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					} else if (nonmonCode.trim().equals("3102")) {

						if (tandemValueList.contains(newCode1.trim())) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					} else {

						if (newCode1.trim().isEmpty()) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					}
				} else if (sourceSystem.equals("C400")) {

					if (nonmonCode.trim().equals("3010")) {

						if (newCode1.trim().equals("O")) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					} else {

						if (newCode1.trim().isEmpty()) {

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
	 * Description - To validate oldCode1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldCode1(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {

		String fieldName = "oldCode1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldCode1Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldCode1Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldCode1Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldCode1Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("HOGAN")) {

				if (nonmonCode.trim().equals("3102")) {
					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(oldCode1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				} else {

					if (oldCode1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {

				if (nonmonCode.trim().equals("3010")) {

					String[] possibleValues = { "N", "DA" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(oldCode1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3102")) {

					String[] possibleValues = { "00", "27", "11", "20", "11" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(oldCode1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldCode1Val.trim().isEmpty()) {

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
	 * Description - To validate newIndicator1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewIndicator1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newIndicator1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newIndicator1Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newIndicator1Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newIndicator1Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newIndicator1Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS")) {

				if (nonmonCode.trim().equals("1150")) {

					if (newIndicator1Val.trim().equals("U")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				} else if (nonmonCode.trim().equals("3000")) {
					String[] possibleValues = { "I", "F", "R" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(newIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3010") || nonmonCode.trim().equals("3020")) {
					if (newIndicator1Val.trim().equals("C")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3104")) {
					String[] possibleValues = { "Y", "N" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(newIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("HOGAN") || sourceSystem.equals("EDMP") || sourceSystem.equals("C400")) {
				if (nonmonCode.trim().equals("1150")) {

					if (newIndicator1Val.trim().equals("U")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
				if (nonmonCode.trim().equals("3104")) {

					if (newIndicator1Val.trim().equals("Y")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3000")) {
					String[] possibleValues = { "R", "I" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(newIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3010")) {
					String[] possibleValues = { "M", "D" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(newIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3020")) {

					if (!(verifyTextFormat(newIndicator1Val, "^\\s+$"))) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3104")) {
					String[] possibleValues = { "Y", "N" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(newIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator1Val.trim().isEmpty()) {

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
	 * Description - To validate oldIndicator1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldIndicator1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldIndicator1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldIndicator1Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldIndicator1Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldIndicator1Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldIndicator1Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {
				if (nonmonCode.trim().equals("1150")) {

					if (oldIndicator1Val.trim().equals("U")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldIndicator1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
				if (nonmonCode.trim().equals("3104")) {

					if (oldIndicator1Val.trim().equals("N")) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldIndicator1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3000")) {
					String[] possibleValues = { "R", "I" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(oldIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3010")) {
					String[] possibleValues = { "M", "D" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(oldIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3020")) {

					if (!(verifyTextFormat(oldIndicator1Val, "^\\s+$"))) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3104")) {
					String[] possibleValues = { "Y", "N" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(oldIndicator1Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldIndicator1Val.trim().isEmpty()) {

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
	 * Description - To validate newIndicator2 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewIndicator2(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newIndicator2";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newIndicator2Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newIndicator2Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newIndicator2Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newIndicator2Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS")) {
				if (nonmonCode.trim().equals("3000")) {
					String[] possibleValues = { "C", "D", "M", "N", "P", "V", "W", " " };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(newIndicator2Val)) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else if (nonmonCode.trim().equals("3010")) {
					String[] possibleValues = { "P", "G", "S" };
					List<String> valueList = createListForComparison(possibleValues);
					if (valueList.contains(newIndicator2Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator2Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}

			} else if (sourceSystem.equals("HOGAN")) {
				if (nonmonCode.trim().equals("3000")) {
					if (newIndicator2Val.trim().contains("C")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator2Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else
				if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW") || sourceSystem.equals("C400")) {
					if (nonmonCode.trim().equals("3010")) {

						List<String> comparisonList = getComparisonList(reqMap, fieldName);
						if (comparisonList.contains(newIndicator2Val.trim())) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					} else {

						if (newIndicator2Val.trim().isEmpty()) {

							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}
					}
				} else if (sourceSystem.equals("TANDEM")) {
					if (nonmonCode.trim().equals("3000")) {
						if (newIndicator2Val.trim().equals("C")) {
							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}

					} else if (nonmonCode.trim().equals("3010")) {
						if (newIndicator2Val.trim().equals("S")) {
							Remarks = appendString(Remarks, "Value - Matched");
						} else {

							Remarks = appendString(Remarks, "Value - Not Matched");
							FailCounter++;
						}

					} else {

						if (newIndicator2Val.trim().isEmpty()) {

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
	 * Description - To validate oldIndicator2 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldIndicator2(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "oldIndicator2";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldIndicator2Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldIndicator2Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldIndicator2Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldIndicator2Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
				if (nonmonCode.trim().equals("3010")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(oldIndicator2Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldIndicator2Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3000")) {
					if (oldIndicator2Val.trim().equals("C")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				} else if (nonmonCode.trim().equals("3010")) {
					if (oldIndicator2Val.trim().equals("S")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				} else {

					if (oldIndicator2Val.trim().isEmpty()) {

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
	 * Description - To validate newIndicator3 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewIndicator3(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newIndicator3";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newIndicator3Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newIndicator3Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newIndicator3Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newIndicator3Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS")) {
				if (nonmonCode.trim().equals("3010")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(newIndicator3Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator3Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3010")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(newIndicator3Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator3Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("C400")) {
				if (nonmonCode.trim().equals("3010")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(newIndicator3Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator3Val.trim().isEmpty()) {

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
	 * Description - To validate oldIndicator3 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldIndicator3(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "oldIndicator3";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldIndicator3Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldIndicator3Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldIndicator3Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldIndicator3Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3010")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(oldIndicator3Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldIndicator3Val.trim().isEmpty()) {

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
	 * Description - To validate newIndicator4 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewIndicator4(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newIndicator4";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newIndicator4Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newIndicator4Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newIndicator4Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newIndicator4Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("C400")) {
				if (nonmonCode.trim().equals("3010")) {
					if (newIndicator4Val.trim().equals("N")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator4Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3010")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(newIndicator4Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (newIndicator4Val.trim().isEmpty()) {

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
	 * Description - To validate oldIndicator4 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldIndicator4(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldIndicator4";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldIndicator4Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldIndicator4Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldIndicator4Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldIndicator4Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3010")) {

					List<String> comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(oldIndicator4Val.trim())) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldIndicator4Val.trim().isEmpty()) {

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
	 * Description - To validate newMonetaryValue field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewMonetaryValue(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newMonetaryValue";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newMonetaryValueVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newMonetaryValueVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newMonetaryValueVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newMonetaryValueVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || sourceSystem.equals("C400")) {
				if (nonmonCode.trim().equals("3201")) {
					String newMonetaryValueValFormat = "^[0-9]+[.][0-9]{2}$";
					if (verifyDecimalFormat(newMonetaryValueVal)) {
						Remarks = appendString(Remarks, "Decimal format - Present");
					} else {
						Remarks = appendString(Remarks, "Decimal format - Not Present");
						FailCounter++;
					}
					if (verifyTextFormat(newMonetaryValueVal.trim(), newMonetaryValueValFormat)) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newMonetaryValueVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("HOGAN")) {
				if (nonmonCode.trim().equals("3202")) {
					String newMonetaryValueValFormat = "^[0-9]+[.][0-9]{2}$";
					if (verifyDecimalFormat(newMonetaryValueVal)) {
						Remarks = appendString(Remarks, "Decimal format - Present");
					} else {
						Remarks = appendString(Remarks, "Decimal format - Not Present");
						FailCounter++;
					}
					if (verifyTextFormat(newMonetaryValueVal.trim(), newMonetaryValueValFormat)) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newMonetaryValueVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				}
			} else if (sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3203") || nonmonCode.trim().equals("3204")) {
					String newMonetaryValueValFormat = "^[0-9]+[.][0-9]{2}$";
					if (verifyDecimalFormat(newMonetaryValueVal)) {
						Remarks = appendString(Remarks, "Decimal format - Present");
					} else {
						Remarks = appendString(Remarks, "Decimal format - Not Present");
						FailCounter++;
					}
					if (verifyTextFormat(newMonetaryValueVal.trim(), newMonetaryValueValFormat)) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newMonetaryValueVal.trim().isEmpty()) {

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
	 * Description - To validate oldMonetaryValue field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldMonetaryValue(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldMonetaryValue";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldMonetaryValueVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldMonetaryValueVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldMonetaryValueVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldMonetaryValueVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {
				if (nonmonCode.trim().equals("3202")) {
					String newMonetaryValueValFormat = "^[0-9]+[.][0-9]{2}$";
					if (verifyDecimalFormat(oldMonetaryValueVal)) {
						Remarks = appendString(Remarks, "Decimal format - Present");
					} else {
						Remarks = appendString(Remarks, "Decimal format - Not Present");
						FailCounter++;
					}
					if (verifyTextFormat(oldMonetaryValueVal.trim(), newMonetaryValueValFormat)) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldMonetaryValueVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Value - Matched");
					} else {

						Remarks = appendString(Remarks, "Value - Not Matched");
						FailCounter++;
					}

				}
			} else if (sourceSystem.equals("SPARROW") || sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3203") || nonmonCode.trim().equals("3204")) {
					String newMonetaryValueValFormat = "^[0-9]+[.][0-9]{2}$";
					if (verifyDecimalFormat(oldMonetaryValueVal)) {
						Remarks = appendString(Remarks, "Decimal format - Present");
					} else {
						Remarks = appendString(Remarks, "Decimal format - Not Present");
						FailCounter++;
					}
					if (verifyTextFormat(oldMonetaryValueVal.trim(), newMonetaryValueValFormat)) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldMonetaryValueVal.trim().isEmpty()) {

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
	 * Description - To validate currencyCode field
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

			if (sourceSystem.equals("HOGAN")) {
				if (nonmonCode.trim().equals("3202")) {
					String currecyCodeFormat = "[0-9]{3}$";
					if (verifyTextFormat(currencyCodeVal, currecyCodeFormat)) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Matched");
						FailCounter++;
					}
				} else {

					if (currencyCodeVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}

				}
			} else
				if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
					if (nonmonCode.trim().equals("3203") || nonmonCode.trim().equals("3204")) {
						String currecyCodeFormat = "[0-9]{3}$";
						if (verifyTextFormat(currencyCodeVal, currecyCodeFormat)) {
							Remarks = appendString(Remarks, "Format - Matched");
						} else {
							Remarks = appendString(Remarks, "Format - Matched");
							FailCounter++;
						}
					} else {

						if (currencyCodeVal.trim().isEmpty()) {

							Remarks = appendString(Remarks, "Format - Matched");
						} else {

							Remarks = appendString(Remarks, "Format - Not Matched");
							FailCounter++;
						}

					}
				} else if (sourceSystem.equals("TANDEM")) {
					if (nonmonCode.trim().equals("3203") || nonmonCode.trim().equals("3204")) {
						if (currencyCodeVal.trim().equals("901")) {
							Remarks = appendString(Remarks, "Format - Matched");
						} else {
							Remarks = appendString(Remarks, "Format - Matched");
							FailCounter++;
						}
					} else {

						if (currencyCodeVal.trim().isEmpty()) {

							Remarks = appendString(Remarks, "Format - Matched");
						} else {

							Remarks = appendString(Remarks, "Format - Not Matched");
							FailCounter++;
						}

					}
				} else if (sourceSystem.equals("C400")) {
					if (nonmonCode.trim().equals("3201")) {
						String currecyCodeFormat = "[0-9]{3}$";
						if (verifyTextFormat(currencyCodeVal, currecyCodeFormat)) {
							Remarks = appendString(Remarks, "Format - Matched");
						} else {
							Remarks = appendString(Remarks, "Format - Matched");
							FailCounter++;
						}
					} else {

						if (currencyCodeVal.trim().isEmpty()) {

							Remarks = appendString(Remarks, "Format - Matched");
						} else {

							Remarks = appendString(Remarks, "Format - Not Matched");
							FailCounter++;
						}

					}
				}else {

					Remarks = appendString(Remarks, "Invalid source system");
					FailCounter++;
				}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks);
		}
	}

	/**
	 * Description - To validate currencyConversionRate field
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

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
				if (nonmonCode.trim().equals("3203") || nonmonCode.trim().equals("3204")) {
					if (currencyConversionRateVal.equals("000001.000000")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not matched");
						FailCounter++;
					}
				} else {

					if (currencyConversionRateVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}

				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3203") || nonmonCode.trim().equals("3204")) {
					String currencyConversionRateFormat = "^[0-9]+[.][0-9]{6}$";
					if (verifyDecimalFormat(currencyConversionRateVal)) {
						Remarks = appendString(Remarks, "Decimal format - Present");
					} else {
						Remarks = appendString(Remarks, "Decimal format - Not Present");
						FailCounter++;
					}
					if (verifyTextFormat(currencyConversionRateVal.trim(), currencyConversionRateFormat)) {
						Remarks = appendString(Remarks, "Format - Matched");
					} else {
						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (currencyConversionRateVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}

				}

			} else if (sourceSystem.equals("C400")) {
				if (nonmonCode.trim().equals("3201")) {
					
					if (currencyConversionRateVal.equals("000001.000000")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not matched");
						FailCounter++;
					}
				} else {

					if (currencyConversionRateVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}

				}

			} else if (sourceSystem.equals("HOGAN")) {
				if (nonmonCode.trim().equals("3202")) {
					
					if (currencyConversionRateVal.equals("000001.000000")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not matched");
						FailCounter++;
					}
				} else {

					if (currencyConversionRateVal.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
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
	 * Description - To validate newNumericValue1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNewNumericValue1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "newNumericValue1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String newNumericValue1Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (newNumericValue1Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + newNumericValue1Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(newNumericValue1Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
				if (nonmonCode.trim().equals("3020")) {
					if (newNumericValue1Val.trim().equals("4")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not matched");
						FailCounter++;
					}
				} else {

					if (newNumericValue1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}

				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3010")) {
					if (!(verifyTextFormat(newNumericValue1Val.trim(), "^[0]+$"))
							&& verifyTextFormat(newNumericValue1Val.trim(), "^[\\pN]+$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (newNumericValue1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
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
	 * Description - To validate oldNumericValue1 field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateOldNumericValue1(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "oldNumericValue1";
		if (reqMap.containsKey(fieldName)) {

			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String oldNumericValue1Val = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (oldNumericValue1Val.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + oldNumericValue1Val.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(oldNumericValue1Val)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EURONET") || sourceSystem.equals("SPARROW")) {
				if (nonmonCode.trim().equals("3020")) {
					if (oldNumericValue1Val.trim().equals("4")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not matched");
						FailCounter++;
					}
				} else {

					if (oldNumericValue1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}

				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (nonmonCode.trim().equals("3010")) {
					if (!(verifyTextFormat(oldNumericValue1Val.trim(), "^[0]+$"))
							&& verifyTextFormat(oldNumericValue1Val.trim(), "^[\\pN]+$")) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				} else {

					if (oldNumericValue1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
						FailCounter++;
					}
				}
			} else if (sourceSystem.equals("C400")) {
				if (nonmonCode.trim().equals("3010") || nonmonCode.trim().equals("3020")) {
					if (oldNumericValue1Val.trim().equals("4")) {
						Remarks = appendString(Remarks, "Value - Matched");
					} else {
						Remarks = appendString(Remarks, "Value - Not matched");
						FailCounter++;
					}
				} else {

					if (oldNumericValue1Val.trim().isEmpty()) {

						Remarks = appendString(Remarks, "Format - Matched");
					} else {

						Remarks = appendString(Remarks, "Format - Not Matched");
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
