#@Author: Manigandan
#@Email : Manigandan.Selvadurai@techmahindra.com
#@Orginzation: TechMahindra

@TANDEM
Feature: Verify TANDEM Source System

@DBTRAN25
Scenario: Verify DBTRAN25_TANDEM transaction file
Given Transaction file "DBTRAN25" exists for "TANDEM"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "TANDEM" specifications for "DBTRAN25"


@PIS12
Scenario: Verify PIS12_TANDEM transaction file
Given Transaction file "PIS12" exists for "TANDEM"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "TANDEM" specifications for "PIS12"


@CIS20
Scenario: Verify CIS20_TANDEM transaction file
Given Transaction file "CIS20" exists for "TANDEM"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "TANDEM" specifications for "CIS20"

@NMON20
Scenario: Verify NMON20_TANDEM transaction file
Given Transaction file "NMON20" exists for "TANDEM"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "TANDEM" specifications for "NMON20"

@AIS20
Scenario: Verify AIS20_TANDEM transaction file
Given Transaction file "AIS20" exists for "TANDEM"
When I validate transaction file count and perform file level validations
Then I verify field format for fields as per "TANDEM" specifications for "AIS20"