Feature: Rest Assured Requests

  Scenario Outline: User calls web service to get all countries and validate that countries are returned in the response
    Given I have set the base URL
    When I have set the resource to <resource>
    Then the result should contain <alpha2_code>
  Examples:
    | resource | alpha2_code |
    | "/all"   | "US"        |
    | "/all"   | "DE"        |
    | "/all"   | "GB"        |
    
  Scenario Outline: User calls web service to get countries individually and validate the response
    Given I have set the base URL
    When I have set the resource to <resource>
    Then the result of name, alpha2_code and alpha3_code should be <name>, <alpha2_code> and <alpha3_code>
  Examples:
    | resource       | name                                                   | alpha2_code | alpha3_code |
    | "/iso2code/US" | "United States of America"                             | "US"        | "USA"       |
    | "/iso2code/DE" | "Germany"                                              | "DE"        | "DEU"       |
    | "/iso2code/GB" | "United Kingdom of Great Britain and Northern Ireland" | "GB"        | "GBR"       |    
    
  Scenario Outline: User call web service to get inexistent country
    Given I have set the base URL
    When I have set the resource to <resource>
    Then the result should not contain <alpha2_code>
  Examples:
    | resource | alpha2_code |
    | "/all"   | "XX"        |
    
  Scenario: User call web service to post new country
    Given I have set the base URL
    When I have set the resource to base resource
    Then the result should inform "Country created successfully"