#@Author: Manigandan
#@Email : Manigandan.Selvadurai@techmahindra.com
#@Orginzation: TechMahindra

@EURONET
Feature: EURONET Source System

@DBTRAN25
Scenario: Verify DBTRAN25_EURONET transaction file
Given Transaction file "DBTRAN25" exists for "EURONET"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "EURONET" specifications for "DBTRAN25"

@NMON20
Scenario: Verify NMON20_EURONET transaction file
Given Transaction file "NMON20" exists for "EURONET"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "EURONET" specifications for "NMON20"