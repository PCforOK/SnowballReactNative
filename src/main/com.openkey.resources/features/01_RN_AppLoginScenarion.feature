@AppLoginRNAndroidApp
Feature: Verify app launch and app login after creating session for a Guest through Openkey Host portal

  Scenario: As a guest I should be able to launch and login into the RN Snowball app

    Given App is installed in the device
    When App is launched
    And Splash screen should appear
    Then User should be presented with Push Notifications screen


