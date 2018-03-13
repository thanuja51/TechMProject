#@Author: Manigandan
#@Email : Manigandan.Selvadurai@techmahindra.com
#@Orginzation: TechMahindra

@HOGAN
Feature: HOGAN Source System

@DBTRAN25
Scenario: Verify DBTRAN25_HOGAN transaction file
Given Transaction file "DBTRAN25" exists for "HOGAN"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "HOGAN" specifications for "DBTRAN25"


@CIS20
Scenario: Verify CIS20_HOGAN transaction file
Given Transaction file "CIS20" exists for "HOGAN"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "HOGAN" specifications for "CIS20"

@PIS12
Scenario: Verify PIS12_HOGAN transaction file
Given Transaction file "PIS12" exists for "HOGAN"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "HOGAN" specifications for "PIS12"

@NMON20
Scenario: Verify NMON20_HOGAN transaction file
Given Transaction file "NMON20" exists for "HOGAN"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "HOGAN" specifications for "NMON20"

@AIS20
Scenario: Verify AIS20_HOGAN transaction file
Given Transaction file "AIS20" exists for "HOGAN"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "HOGAN" specifications for "AIS20"