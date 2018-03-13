#@Author: Manigandan
#@Email : Manigandan.Selvadurai@techmahindra.com
#@Orginzation: TechMahindra

@CCMS
Feature: CCMS Source System

@CRTRAN25
Scenario: Verify CRTRAN25_CCMS transaction file
Given Transaction file "CRTRAN25" exists for "CCMS"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "CCMS" specifications for "CRTRAN25"

@PIS12
Scenario: Verify CIS20_CCMS transaction file
Given Transaction file "PIS12" exists for "CCMS"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "CCMS" specifications for "PIS12"


@CIS20
Scenario: Verify CIS20_CCMS transaction file
Given Transaction file "CIS20" exists for "CCMS"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "CCMS" specifications for "CIS20"

@NMON20
Scenario: Verify NMON20_CCMS transaction file
Given Transaction file "NMON20" exists for "CCMS"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "CCMS" specifications for "NMON20"

@RBTRAN21
Scenario: Verify RBTRAN21_CCMS transaction file
Given Transaction file "RBTRAN21" exists for "CCMS"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "CCMS" specifications for "RBTRAN21"

@AIS20
Scenario: Verify AIS20_CCMS transaction file
Given Transaction file "AIS20" exists for "CCMS"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "CCMS" specifications for "AIS20"