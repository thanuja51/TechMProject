#@Author: Manigandan
#@Email : Manigandan.Selvadurai@techmahindra.com
#@Orginzation: TechMahindra

@EDMP
Feature: EDMP Source System

@PIS12
Scenario: Verify PIS12_EDMP transaction file
Given Transaction file "PIS12" exists for "EDMP"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "EDMP" specifications for "PIS12"

@CIS20
Scenario: Verify CIS20_EDMP transaction file
Given Transaction file "CIS20" exists for "EDMP"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "EDMP" specifications for "CIS20"

@NMON20
Scenario: Verify NMON20_EDMP transaction file
Given Transaction file "NMON20" exists for "EDMP"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "EDMP" specifications for "NMON20"

@AIS20
Scenario: Verify AIS20_EDMP transaction file
Given Transaction file "AIS20" exists for "EDMP"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "EDMP" specifications for "AIS20"