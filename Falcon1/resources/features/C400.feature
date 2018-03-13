#@Author: Manigandan
#@Email : Manigandan.Selvadurai@techmahindra.com
#@Orginzation: TechMahindra

@C400
Feature: C400 Source System

@CRTRAN25
Scenario: Verify CRTRAN25_C400 transaction file
Given Transaction file "CRTRAN25" exists for "C400"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "C400" specifications for "CRTRAN25"

@CIS20
Scenario: Verify CIS20_C400 transaction file
Given Transaction file "CIS20" exists for "C400"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "C400" specifications for "CIS20"

@PIS12
Scenario: Verify PIS12_C400 transaction file
Given Transaction file "PIS12" exists for "C400"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "C400" specifications for "PIS12"

@NMON20
Scenario: Verify NMON20_C400 transaction file
Given Transaction file "NMON20" exists for "C400"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "C400" specifications for "NMON20"

@RBTRAN21
Scenario: Verify RBTRAN21_C400 transaction file
Given Transaction file "RBTRAN21" exists for "C400"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "C400" specifications for "RBTRAN21"

@AIS20
Scenario: Verify AIS20_C400 transaction file
Given Transaction file "AIS20" exists for "C400"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "C400" specifications for "AIS20"