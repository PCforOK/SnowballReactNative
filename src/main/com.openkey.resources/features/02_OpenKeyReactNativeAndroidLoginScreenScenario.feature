@AppLoginRNAndroidApp
Feature: Verify app login after creating session for a Guest through Openkey Host portal

  Scenario: As a guest I should be able to login into the RN Snowball app

    Given User is at Permission Required Screen
    When User clicks NEXT over Permission Required Screen
    Then User should be presented with Find My Reservation Screen

    Given User is at Find My Reservation screen
    When User enters registered mobile number and clicks 'SUBMIT'
    Then  OPT INTO MESSAGING Screen should be displayed

    Given User is at OPT INTO MESSAGING Screen
    When User click Next button over OPT INTO MESSAGING screen
    Then  User should be presented with VERIFICATION Screen

    When User receives the verification code
    And  User Enters received verification code
    Then Verification Code should be validated successfully

