package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppLoginSteps extends BaseSteps {

    @Before

    public void setups () {

        setupScreens(driver);

    }

    @Given("^App is installed in the device$")

     public void Appisinstalledinthedevice () {

     }

    @When("^App is launched$")

    public void Appislaunched () {


    }

    @And("^Splash screen should appear$")

    public void Splashscreenshouldappear () {
        appLoginScreenLogic.verifySplashScreen();
    }

    @Then("^User should be presented with Push Notifications screen$")

    public void UsershouldbepresentedwithPushNotificationsscreen() throws InterruptedException {

        appLoginScreenLogic.verifyPushNotificationScreen();
        appLoginScreenLogic.verifyReservationScreen();
        appLoginScreenLogic.readOTP();
        appLoginScreenLogic.verifyenterOTPScreen();
    }





}
