#@Author: Manigandan
#@Email : Manigandan.Selvadurai@techmahindra.com
#@Orginzation: TechMahindra

@SPARROW
Feature: Verify SPARROW Source System

@DBTRAN25
Scenario: Verify DBTRAN25_SPARROW transaction file
Given Transaction file "DBTRAN25" exists for "SPARROW"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "SPARROW" specifications for "DBTRAN25"

@NMON20
Scenario: Verify NMON20_SPARROW transaction file
Given Transaction file "NMON20" exists for "SPARROW"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "SPARROW" specifications for "NMON20"