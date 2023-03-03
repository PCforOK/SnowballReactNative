package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class RN_OpenKeyAppHamburgerMenuSteps extends BaseSteps {


    @Before

    public void setups() throws IOException {

        setupScreens(driver);


    }

    @Given("^User is on MY STAYS screen$")

    public void User_is_on_MY_STAYS_screen() throws InterruptedException {

       openKeyMobileAndroidAppHamburgerMenuScreen.verifyMyStaysScreen();

       Thread.sleep(5000);
    }


    @When("^Guest clicks on Hamburger menu$")
    public void guest_Clicks_On_Hamburger_Menu() {

        openKeyMobileAndroidAppHamburgerMenuScreen.verifyHamburgerMenuClickAction();
    }

    @Then("^All menu items should appear enabled$")
    public void all_Menu_Items_Should_Appear_Enabled() {

        openKeyMobileAndroidAppHamburgerMenuScreen.verifyHamburgerMenuItems();

    }

    @When("^Guest clicks on PROFILE menu item$")
    public void guestClicksOnPROFILEMenuItem() {

       openKeyMobileAndroidAppHamburgerMenuScreen.verifyProfileClickAction();

    }

    @Then("^PROFILE screen features should be functional$")
    public void profileScreenFeaturesShouldBeFunctional() throws InterruptedException {

       openKeyMobileAndroidAppHamburgerMenuScreen.verifyProfileScreenActions();
    }

    @When("^Guest clicks on UPCOMING STAYS menu item$")
    public void guestClicksOnUPCOMINGSTAYSMenuItem() {

    }

    @Then("^UPCOMING STAYS screen features should be functional$")
    public void upcomingSTAYSScreenFeaturesShouldBeFunctional() {
    }

    @When("^Guest clicks on SECURITY menu item$")
    public void guestClicksOnSECURITYMenuItem() throws InterruptedException {

        Thread.sleep(5000);

        openKeyMobileAndroidAppHamburgerMenuScreen.verifyHamburgerMenuClickAction();
        openKeyMobileAndroidAppHamburgerMenuScreen.verifySecurityClickAction();
    }

    @Then("^SECURITY screen features should be functional$")
    public void securityScreenFeaturesShouldBeFunctional() throws InterruptedException {

        Thread.sleep(5000);

        openKeyMobileAndroidAppHamburgerMenuScreen.verifySecurityLocks();
    }

    @When("^Guest clicks on SEARCH HOTELS menu item$")
    public void guest_clicks_on_search_hotels_menu_item() throws InterruptedException {

        Thread.sleep(5000);

        openKeyMobileAndroidAppHamburgerMenuScreen.verifyHamburgerMenuClickAction();
        openKeyMobileAndroidAppHamburgerMenuScreen.verifySearchHotelsClickAction();

    }

    @Then("^SEARCH HOTELS screen features should be functional$")
    public void search_hotels_screen_features_should_be_functional() {

        openKeyMobileAndroidAppHamburgerMenuScreen.verifyHotelSearchAction();
    }

    @When("^Guest clicks on SLEEP SOUNDS menu item$")
    public void guest_clicks_on_sleep_sounds_menu_item() throws InterruptedException {

        Thread.sleep(5000);

        openKeyMobileAndroidAppHamburgerMenuScreen.verifyHamburgerMenuClickAction();

        openKeyMobileAndroidAppHamburgerMenuScreen.verifySleepSoundsClickAction();


    }

    @Then("^SLEEP SOUNDS screen features should be functional$")
    public void sleep_sound_screen_features_should_be_functional() throws InterruptedException {

      openKeyMobileAndroidAppHamburgerMenuScreen.verifyTimerActionsSleepSounds();

    }





}