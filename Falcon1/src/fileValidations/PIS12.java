package fileValidations;


import utils.Report;
import utils.Wrappers;
import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;


public class PIS12 extends Wrappers {
	Report rp = new Report();

	/**
	 * Description - To call all field level validation methods
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */	
	public void validatePIS12Transaction(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) throws ParseException {

		validateWorkflow(transactionEntry, reqMap, transactionCount);
		validateMediaType(transactionEntry, reqMap, transactionCount);
		validateRecordType(transactionEntry, reqMap, transactionCount);
		validateDataSpecificationVersion(transactionEntry, reqMap, transactionCount);
		validateClientIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateRecordCreationDate(transactionEntry, reqMap, transactionCount);
		validateRecordCreationTime(transactionEntry, reqMap, transactionCount);
		validateGMTOffset(transactionEntry, reqMap, transactionCount);
		validateCustomerIdFromHeader(transactionEntry, reqMap, transactionCount);
		validateCustomerAcctNumber(transactionEntry, reqMap, transactionCount);
		validateExternalTransactionId(transactionEntry, reqMap, transactionCount);
		validatePan(transactionEntry, reqMap, transactionCount);
		validateType(transactionEntry, reqMap, transactionCount);
		validateSubType(transactionEntry, reqMap, transactionCount);
		validateCategory(transactionEntry, reqMap, transactionCount);
		validateAssociation(transactionEntry, reqMap, transactionCount);
		validatePanOpenDate(transactionEntry, reqMap, transactionCount);
		validateMemberSinceDate(transactionEntry, reqMap, transactionCount);
		validateIssuingCountry(transactionEntry, reqMap, transactionCount);
		validateCardholderCity(transactionEntry, reqMap, transactionCount);
		validateCardholderStateProvince(transactionEntry, reqMap, transactionCount);
		validateCardholderCountryCode(transactionEntry, reqMap, transactionCount);
		validateNumberOfPaymentIds(transactionEntry, reqMap, transactionCount);
		validateStatus(transactionEntry, reqMap, transactionCount);
		validateStatusDate(transactionEntry, reqMap, transactionCount);
		validatePinLength(transactionEntry, reqMap, transactionCount);
		validatePinSetDate(transactionEntry, reqMap, transactionCount);
		validatePinType(transactionEntry, reqMap, transactionCount);
		validateActiveIndicator(transactionEntry, reqMap, transactionCount);
		validateNameOnInstrument(transactionEntry, reqMap, transactionCount);
		validateExpirationDate(transactionEntry, reqMap, transactionCount);
		validatelastIssueDate(transactionEntry, reqMap, transactionCount);
		validatePlasticIssueType(transactionEntry, reqMap, transactionCount);
		validateIncentive(transactionEntry, reqMap, transactionCount);
		validateCurrencyCode(transactionEntry, reqMap, transactionCount);
		validateCurrencyConversionRate(transactionEntry, reqMap, transactionCount);
		validateCreditLimit(transactionEntry, reqMap, transactionCount);
		validateDailyPosLimit(transactionEntry, reqMap, transactionCount);
		validateDailyCashLimit(transactionEntry, reqMap, transactionCount);
		validateCashbackLimitMode(transactionEntry, reqMap, transactionCount);
		validateAipStatic(transactionEntry, reqMap, transactionCount);
		validateAipDynamic(transactionEntry, reqMap, transactionCount);
		validateAipVerify(transactionEntry, reqMap, transactionCount);
		validateAipRisk(transactionEntry, reqMap, transactionCount);
		validateAipIssuerAuthentication(transactionEntry, reqMap, transactionCount);
		validateAipCombined(transactionEntry, reqMap, transactionCount);
		validateChipSpecification(transactionEntry, reqMap, transactionCount);
		validateChipSpecVersion(transactionEntry, reqMap, transactionCount);
	}

	/**
	 * Description - To validate Type field
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
			String typeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap), getEndIndex(fieldName, reqMap));


			if (typeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + typeVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(typeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || sourceSystem.equals("CCMS")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(typeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN") || sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(typeVal.trim())) 
					Remarks = appendString(Remarks, "Value - Matched");
				else {
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
	 * Description - To validate SubType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateSubType(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "subType";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String subTypeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (subTypeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + subTypeVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(subTypeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || (sourceSystem.equals("C400") || sourceSystem.equals("HOGAN"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(subTypeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS") || sourceSystem.equals("TANDEM")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(subTypeVal.trim())) 
					Remarks = appendString(Remarks, "Value - Matched");
				else {
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
	 * Description - To validate Category field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCategory(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "category";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String categoryVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (categoryVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + categoryVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(categoryVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(categoryVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if ((sourceSystem.equals("CCMS")) || (sourceSystem.equals("EDMP"))
					|| (sourceSystem.equals("C400"))) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(categoryVal.trim())) 
					Remarks = appendString(Remarks, "Value - Matched");
				else {
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
	 * Description - To validate Association field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAssociation(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "association";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String associationVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (associationVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + associationVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(associationVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			List<String>  comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(associationVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate NameOnInstrument field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateNameOnInstrument(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {

		String fieldName = "nameOnInstrument (emboss name)";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String nameOnInstrument = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (nameOnInstrument.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + nameOnInstrument.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(nameOnInstrument)) {

				Remarks = appendString(Remarks, "Length - Matched");
			} else {

				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EDMP"))
					|| (sourceSystem.equals("C400")) || (sourceSystem.equals("TANDEM"))) {

				if (!(verifyTextFormat(nameOnInstrument, "^\\s+$"))) {

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
	 * Description - To validate PanOpenDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePanOpenDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "panOpenDate";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String panOpenDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (panOpenDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + panOpenDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(panOpenDateVal))
				Remarks = appendString(Remarks, "Length - Matched");
			else {
				
				FailCounter++;
			}

			if (verifyDateFormat(panOpenDateVal, "yyyyMMdd"))
				Remarks = appendString(Remarks, "Format- Matched");
			else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate MemberSinceDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateMemberSinceDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "memberSinceDate";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String memberSinceDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (memberSinceDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + memberSinceDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(memberSinceDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				
				FailCounter++;
			}

			if (verifyDateFormat(memberSinceDateVal, "yyyyMMdd")) {
				Remarks = appendString(Remarks, "Format- Matched");

			} else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate StatusDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateStatusDate(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "statusDate";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String statusDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (statusDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + statusDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(statusDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				
				FailCounter++;
			}

			if (verifyDateFormat(statusDateVal, "yyyyMMdd")) {
				Remarks = appendString(Remarks, "Format- Matched");

			} else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate ExpirationDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateExpirationDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "expirationDate";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String expirationDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (expirationDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + expirationDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(expirationDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				
				FailCounter++;
			}

			if (verifyDateFormat(expirationDateVal, "yyyyMMdd")) {
				Remarks = appendString(Remarks, "Format- Matched");

			} else {
				Remarks = appendString(Remarks, "Format- Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate lastIssueDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatelastIssueDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "lastIssueDate (emboss date)";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String lastIssueDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			if (lastIssueDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + lastIssueDateVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(lastIssueDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || (sourceSystem.equals("HOGAN"))
					|| (sourceSystem.equals("CCMS")) || (sourceSystem.equals("C400"))) {
				if (verifyDateFormat(lastIssueDateVal, "yyyyMMdd")) {
					Remarks = appendString(Remarks, "Format- Matched");

				} else {
					Remarks = appendString(Remarks, "Format- Not matched");
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
	 * Description - To validate IssuingCountry field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateIssuingCountry(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "issuingCountry";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String issuingCountryVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (issuingCountryVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + issuingCountryVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(issuingCountryVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || (sourceSystem.equals("CCMS"))
					|| (sourceSystem.equals("C400"))) {
				String issuingCountryValFormat = "[0-9]{3}$";
				if (verifyTextFormat(issuingCountryVal, issuingCountryValFormat)) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(issuingCountryVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
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
	 * Description - To validate ActiveIndicator field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateActiveIndicator(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "activeIndicator";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String activeIndicatorVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (activeIndicatorVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + activeIndicatorVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(activeIndicatorVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("CCMS"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(activeIndicatorVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP") || (sourceSystem.equals("TANDEM"))
					|| (sourceSystem.equals("C400"))) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(activeIndicatorVal.trim())) {
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
	 * Description - To validate CardholderCountryCode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCardholderCountryCode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardholderCountryCode";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardholderCountryCodeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (cardholderCountryCodeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + cardholderCountryCodeVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cardholderCountryCodeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("CCMS") || (sourceSystem.equals("C400"))
					|| (sourceSystem.equals("HOGAN"))) {
				String issuingCountryValFormat = "[0-9]{3}$";
				if (verifyTextFormat(cardholderCountryCodeVal, issuingCountryValFormat)) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(cardholderCountryCodeVal.trim())) {
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
	 * Description - To validate CardholderCity field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCardholderCity(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardholderCity";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardholderCityVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (cardholderCityVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + cardholderCityVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cardholderCityVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS"))
					|| (sourceSystem.equals("TANDEM")) || (sourceSystem.equals("C400"))) {
				if (!(verifyTextFormat(cardholderCityVal, "^\\s+$"))) {
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
	 * Description - To validate CardholderStateProvince field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCardholderStateProvince(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cardholderStateProvince";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cardholderStateProvinceVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (cardholderStateProvinceVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + cardholderStateProvinceVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cardholderStateProvinceVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS"))
					|| (sourceSystem.equals("TANDEM")) || (sourceSystem.equals("C400"))) {
				if (!(verifyTextFormat(cardholderStateProvinceVal, "^\\s+$"))) {
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

	/**
	 * Description - To validate NumberOfPaymentIds field
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

			if (sourceSystem.equals("HOGAN")) {

				if (!(verifyTextFormat(numberOfPaymentIdsVal.trim(), "^[0]+$")) && verifyTextFormat(numberOfPaymentIdsVal.trim(), "^[\\pN]+$")) {

					Remarks = appendString(Remarks, "Format - Matched");
				} else {

					Remarks = appendString(Remarks, "Format - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS") || (sourceSystem.equals("TANDEM"))) {

				if (Integer.parseInt(getValueOrFormat(fieldName, reqMap).trim())==Integer.parseInt(numberOfPaymentIdsVal.trim())) {
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
	 * Description - To validate Status field
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
			String statusVal = transactionEntry.substring(getStartIndex(fieldName, reqMap), getEndIndex(fieldName, reqMap));


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

			List<String>  comparisonList = getComparisonList(reqMap, fieldName);
			if (comparisonList.contains(statusVal.trim())) {
				Remarks = appendString(Remarks, "Value - Matched");
			} else {
				Remarks = appendString(Remarks, "Value - Not matched");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate PinLength field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePinLength(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "pinLength";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String pinLengthVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (pinLengthVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + pinLengthVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(pinLengthVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM") ||sourceSystem.equals("EDMP")|| (sourceSystem.equals("C400"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(pinLengthVal.trim())) {
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
	 * Description - To validate CurrencyCode field
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

			if (sourceSystem.equals("HOGAN") || sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(currencyCodeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP") || (sourceSystem.equals("C400"))
					|| (sourceSystem.equals("CCMS"))) {
				String issuingCountryValFormat = "[0-9]{3}$";
				if (verifyTextFormat(currencyCodeVal, issuingCountryValFormat)) {
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
	 * Description - To validate CurrencyConversionRate field
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

	/**
	 * Description - To validate DailyPosLimit field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateDailyPosLimit(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "dailyPosLimit";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String dailyPosLimitVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);


			if (dailyPosLimitVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + dailyPosLimitVal.trim() + "\"");
			if (sizeVal == getStringLen(dailyPosLimitVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}


			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS"))
					|| (sourceSystem.equals("EDMP")) || (sourceSystem.equals("TANDEM"))) {
				if (verifyTextFormat(dailyPosLimitVal.trim(), "^[0-9]+$")) {
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

	/**
	 * Description - To validate DailyCashLimit field
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

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS"))
					|| (sourceSystem.equals("EDMP"))) {
				if (verifyTextFormat(dailyCashLimitVal.trim(), "^[0-9]+$")) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format -Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("TANDEM")) {
				
				if (Integer.parseInt(getValueOrFormat(fieldName, reqMap).trim())==Integer.parseInt(dailyCashLimitVal.trim())) {
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
	 * Description - To validate CashbackLimitMode field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateCashbackLimitMode(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "cashbackLimitMode";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String cashbackLimitModeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (cashbackLimitModeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + cashbackLimitModeVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(cashbackLimitModeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(cashbackLimitModeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(cashbackLimitModeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
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

	/**
	 * Description - To validate MediaType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateMediaType(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "mediaType";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String mediaTypeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			

			if (mediaTypeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + mediaTypeVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(mediaTypeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			MediaTypeFlag = mediaTypeVal;

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(mediaTypeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("CCMS") || sourceSystem.equals("EDMP")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(mediaTypeVal.trim())) {
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
	 * Description - To validate Incentive field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateIncentive(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "incentive";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String incentiveVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (incentiveVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + incentiveVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(incentiveVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("CCMS"))
					|| (sourceSystem.equals("EDMP")) || (sourceSystem.equals("C400"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(incentiveVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("TANDEM")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(incentiveVal.trim())) {
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
	 * Description - To validate AipStatic field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAipStatic(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "aipStatic";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String aipStaticVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (aipStaticVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + aipStaticVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(aipStaticVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("C400") || sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(aipStaticVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				if (((MediaTypeFlag).trim()).equals("M")) {
					if (verifyTextFormat(aipStaticVal, "(\\s){1}")) {
						Remarks = appendString(Remarks, "Value is Blank");
					} else {
						Remarks = appendString(Remarks, "Value is Not Blank");
						FailCounter++;
					}
				} else {
					List<String>  comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(aipStaticVal.trim()) && !(aipStaticVal.trim().isEmpty())) {
						Remarks = appendString(Remarks, "Value - Matched");}
					else {
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
	 * Description - To validate AipVerify field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAipVerify(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "aipVerify";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String aipVerifyVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (aipVerifyVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + aipVerifyVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(aipVerifyVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM"))
					|| (sourceSystem.equals("C400"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(aipVerifyVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				if (((MediaTypeFlag).trim()).equals("M")) {
					if (verifyTextFormat(aipVerifyVal, "(\\s){1}")) {
						Remarks = appendString(Remarks, "Value is Blank");
					} else {
						Remarks = appendString(Remarks, "Value is Not Blank");
						FailCounter++;
					}
				} else {
					List<String>  comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(aipVerifyVal.trim()) && !(aipVerifyVal.trim().isEmpty())) {
						Remarks = appendString(Remarks, "Value - Matched");}
					else {
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
	 * Description - To validate AipRisk field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAipRisk(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "aipRisk";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String aipRiskVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (aipRiskVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + aipRiskVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(aipRiskVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM"))
					|| (sourceSystem.equals("C400"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(aipRiskVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				if (((MediaTypeFlag).trim()).equals("M")) {
					if (verifyTextFormat(aipRiskVal, "(\\s){1}")) {
						Remarks = appendString(Remarks, "Value is Blank");
					} else {
						Remarks = appendString(Remarks, "Value is Not Blank");
						FailCounter++;
					}
				} else {
					List<String>  comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(aipRiskVal.trim()) && !(aipRiskVal.trim().isEmpty())) {
						Remarks = appendString(Remarks, "Value - Matched");}
					else {
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
	 * Description - To validate AipDynamic field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAipDynamic(String transactionEntry, LinkedHashMap<String, LinkedHashMap<String, String>> reqMap,
			int transactionCount) {
		String fieldName = "aipDynamic";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String aipDynamicVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (aipDynamicVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + aipDynamicVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(aipDynamicVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM"))
					|| (sourceSystem.equals("C400"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(aipDynamicVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {

				if (((MediaTypeFlag).trim()).equals("M")) {
					if (verifyTextFormat(aipDynamicVal, "(\\s){1}")) {
						Remarks = appendString(Remarks, "Value is Blank");
					} else {
						Remarks = appendString(Remarks, "Value is Not Blank");
						FailCounter++;
					}
				} else {
					List<String>  comparisonList = getComparisonList(reqMap, fieldName);
					if (comparisonList.contains(aipDynamicVal.trim()) && !(aipDynamicVal.trim().isEmpty())) {
						Remarks = appendString(Remarks, "Value - Matched");}
					else {
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
	 * Description - To validate AipIssuerAuthentication field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAipIssuerAuthentication(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "aipIssuerAuthentication";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String aipIssuerAuthenticationVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (aipIssuerAuthenticationVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + aipIssuerAuthenticationVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(aipIssuerAuthenticationVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM"))
					|| (sourceSystem.equals("C400"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(aipIssuerAuthenticationVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(aipIssuerAuthenticationVal.trim())) {
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
	 * Description - To validate AipCombined field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateAipCombined(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "aipCombined";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String aipCombinedVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (aipCombinedVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + aipCombinedVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(aipCombinedVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN") || (sourceSystem.equals("TANDEM"))
					|| (sourceSystem.equals("C400"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(aipCombinedVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(aipCombinedVal.trim())) {
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
			String recordtypeval = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (recordtypeval.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + recordtypeval.trim() + "\"");

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
			String dataSpecificationVersionval = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (dataSpecificationVersionval.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + dataSpecificationVersionval.trim() + "\"");
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
			String recordCreationDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (recordCreationDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + recordCreationDateVal.trim() + "\"");

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
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + recordCreationTimeVal.trim() + "\"");

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
	 * Description - To validate GMTOffset field
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
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + gmtOffsetVal.trim() + "\"");

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
	 * Description - To validate Pan field
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
			String panVal = transactionEntry.substring(getStartIndex(fieldName, reqMap), getEndIndex(fieldName, reqMap));
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);


			if (panVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + panVal.trim() + "\"");
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
			String customerAcctNumberVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));

			if (customerAcctNumberVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + customerAcctNumberVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(customerAcctNumberVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not Matched");
				FailCounter++;
			}

			if (sourceSystem.equals("HOGAN")) {
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
			} else if (sourceSystem.equals("EDMP") || (sourceSystem.equals("TANDEM"))
					|| (sourceSystem.equals("C400")) || (sourceSystem.equals("CCMS"))) {
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
				Remarks = appendString(Remarks, "Invalid Source System");
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
			String customerIdFromHeaderVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (customerIdFromHeaderVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + customerIdFromHeaderVal.trim() + "\"");

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
	 * Description - To validate Workflow field
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
			if ((sourceSystem.equals("HOGAN")) || (sourceSystem.equals("EDMP"))
					|| (sourceSystem.equals("TANDEM"))) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(workFlowVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
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
			} else {
				Remarks = appendString(Remarks, "Invalid source system");
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
			} else if( (sourceSystem.equals("HOGAN")) || (sourceSystem.equals("TANDEM"))){
				String clientIdFormat = "SC_" + sourceSystem + countryCode + "_DB";
				if (clientIdFromHeaderVal.trim().equals(clientIdFormat)) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
					FailCounter++;
				}
			}else if (sourceSystem.equals("EDMP")) {

				String clientIdFormat = "SC_" + "EURONET" + countryCode + "_DB";
				String clientIdFormat1 = "SC_" + "SPARROW" + countryCode + "_DB";
				if ((clientIdFromHeaderVal.trim().equals(clientIdFormat))
						|| (clientIdFromHeaderVal.trim().equals(clientIdFormat1))) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
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
	 * Description - To validate PlasticIssueType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePlasticIssueType(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "plasticIssueType";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String subTypeVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (subTypeVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + subTypeVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(subTypeVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP") || sourceSystem.equals("TANDEM")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(subTypeVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not matched");
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
	 * Description - To validate PinSetDate field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePinSetDate(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "pinSetDate";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String pinSetDateVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (pinSetDateVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + pinSetDateVal.trim() + "\"");

			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);

			if (sizeVal == getStringLen(pinSetDateVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP")) {
				if (verifyDateFormat(pinSetDateVal, "yyyyMMdd") || pinSetDateVal.trim().isEmpty()) {
					Remarks = appendString(Remarks, "Format- Matched");

				} else {
					Remarks = appendString(Remarks, "Format- Not matched");
					FailCounter++;
				}}
			else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}

			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate PinType field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validatePinType(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "pinType";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String activeIndicatorVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (activeIndicatorVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + activeIndicatorVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(activeIndicatorVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("EDMP")|| (sourceSystem.equals("C400"))) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(activeIndicatorVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
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

	/**
	 * Description - To validate CreditLimit field
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

			if ((sourceSystem.equals("C400")) || (sourceSystem.equals("CCMS"))
					||(sourceSystem.equals("TANDEM"))) {
				if (verifyTextFormat(creditLimitVal.trim(), "^[0-9]+$")) {
					Remarks = appendString(Remarks, "Format - Matched");
				} else {
					Remarks = appendString(Remarks, "Format -Not Matched");
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

	/**
	 * Description - To validate ChipSpecification field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateChipSpecification(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "chipSpecification";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String chipSpecificationVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),
					getEndIndex(fieldName, reqMap));


			if (chipSpecificationVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + chipSpecificationVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(chipSpecificationVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}

			if (sourceSystem.equals("TANDEM") || sourceSystem.equals("C400")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(chipSpecificationVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				}
			} else if (sourceSystem.equals("EDMP")) {
				List<String>  comparisonList = getComparisonList(reqMap, fieldName);
				if (comparisonList.contains(chipSpecificationVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
					FailCounter++;
				} }
			else {
				Remarks = appendString(Remarks, "Invalid source system");
				FailCounter++;
			}
			rp.updateLog(transactionCount, fieldName, FailCounter, Remarks); 
		}
	}

	/**
	 * Description - To validate ChipSpecVersion field
	 * @param transactionEntry, reqMap, transactionCount
	 * @return void
	 */
	public void validateChipSpecVersion(String transactionEntry,
			LinkedHashMap<String, LinkedHashMap<String, String>> reqMap, int transactionCount) {
		String fieldName = "chipSpecVersion";
		if (reqMap.containsKey(fieldName)) { 
			String Remarks = "";
			Remarks = appendString(Remarks, "Expected: " + reqMap.get(fieldName).get("Expected"));
			int FailCounter = 0;
			String chipSpecVersionVal = transactionEntry.substring(getStartIndex(fieldName, reqMap),getEndIndex(fieldName, reqMap));


			if (chipSpecVersionVal.trim().equals(""))
				Remarks = appendString(Remarks, "Actual: \"<Blank>\"");
			else
				Remarks = appendString(Remarks, "Actual: \"" + chipSpecVersionVal.trim() + "\"");
			String Size = reqMap.get(fieldName).get("Size");
			int sizeVal = Integer.parseInt(Size);
			if (sizeVal == getStringLen(chipSpecVersionVal)) {
				Remarks = appendString(Remarks, "Length - Matched");
			} else {
				Remarks = appendString(Remarks, "Length - Not matched");
				FailCounter++;
			}
			if (sourceSystem.equals("C400") || sourceSystem.equals("TANDEM")) {
				if (getValueOrFormat(fieldName, reqMap).trim().equals(chipSpecVersionVal.trim())) {
					Remarks = appendString(Remarks, "Value - Matched");
				} else {
					Remarks = appendString(Remarks, "Value - Not Matched");
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
}