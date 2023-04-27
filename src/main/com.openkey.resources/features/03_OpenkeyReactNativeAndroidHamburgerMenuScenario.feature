@HamburgerMenuAndroidApp

Feature: Navigate through all the Hamburger menu items and verify underlying functionality of each Menu items


  Scenario : As a guest, I would like to open Hamburger Menu and check all available options within the menu

    When Guest clicks on Hamburger menu icon
    Then Hamburger Menu should slideout
    And All menu items should appear enabled within Hamburger Menu


  Scenario : As a guest, I would like to access PROFILE screen through Hamburger Menu

    Given Hamburger Menu is open
    When Guest clicks on PROFILE menu item
    Then Guest should be navigated to PROFILE screen successfully

  Scenario : As a guest, I would like to update the user details like First Name, Last Name and Email through PROFILE screen

    Given Guest is on PROFILE Screen
    When Guest Updates the First Name Last Name and Email id of user
    Then Guest should be presented with Profile Successful Update message

  Scenario : As a guest, I would like to update the user details which was earlier


  Scenario : As a guest, I would like to access My Stays screen through Hamburger Menu

    Given Hamburger Menu is open
    When Guest clicks on UPCOMING STAYS menu item
    Then Guest should be navigated to MY STAYS screen successfully

  Scenario : As a guest, I would like to access SECURITY screen through Hamburger Menu

    Given Hamburger Menu is open
    When Guest clicks on SECURITY menu item
    Then Guest should be navigated to SECURITY screen successfully

  Scenario : As a guest, I would like to enable security lock i.e. Touch ID, Face ID and Pattern Lock through Security Screen

    Given Guest is on SECURITY Screen
    When Guest enables device supported security lock type
    Then Selected security lock type console should be displayed
    And Guest should be able to enable the supported security lock type successfully

  Scenario : As a guest, I would like to access SEARCH HOTELS screen through Hamburger Menu

    Given Hamburger Menu is open
    When Guest clicks on SEARCH HOTELS menu item
    Then Guest should be navigated to SEARCH HOTELS screen successfully

  Scenario : As a guest, I would like to search for hotel and get hotel information

    Given Guest is on SEARCH HOTELS Screen
    When Guest enters city and clicks search
    Then Guest should be navigated to matching search result screen
    And Guest should be able to access related Hotel Information screen

  Scenario : As a guest, I would like to access SLEEP SOUNDS screen through Hamburger Menu

    Given Hamburger Menu is open
    When Guest clicks on SLEEP SOUNDS menu item
    Then Guest should be navigated to SLEEP SOUNDS screen successfully

  Scenario : As a guest, I would like to play and pause the available sleep sounds in conjunction with timers

    Given Guest is on SLEEP SOUNDS Screen
    When Guest clicks on sleep sound time and available sound types
    Then selected Sound type should be played accordingly


