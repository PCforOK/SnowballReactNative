@DownloadMobileKey
Feature: Download Mobile key for the guest user

  Scenario: verify Active Key Screen and push notifications when Guest has access to room

    Given Guest is on My STAYS screen
    When Guest clicks GET MY KEY screen
    When Guest is downloading key
    Then My Key Screen should be displayed
    And Guest has access to room
    And Get push notification saying you have access to Room Number
    And My Key Screen Welcome To Hotel Name and Room Number should be displayed
