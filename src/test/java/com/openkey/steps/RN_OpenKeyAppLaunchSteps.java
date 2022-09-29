package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RN_OpenKeyAppLaunchSteps extends BaseSteps {

    @Before

    public void setups() {

        setupScreens(driver);

    }

    @Given("^RN Snowball App is installed in the device$")

    public void RN_snowball_app_is_installed_in_the_device() {

        openKeyMobileAndroidAppLaunchScreen.verifyIfAppInstalled();
    }

    @When("^App is launched$")

    public void app_is_launched() {

        System.out.println("App is launched Successfully");

    }

    @Then("^Splash screen should appear$")

    public void splash_screen_should_appear() {

        openKeyMobileAndroidAppLaunchScreen.verifySplashScreen();
    }


}
