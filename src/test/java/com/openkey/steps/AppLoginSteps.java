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

public void appInstalledInTheDevice () {

        }

@When("^App is launched$")

public void appLaunched () {


        }

@And("^Splash screen should appear$")

public void splashScreenShouldAppear () {
        appLoginScreenLogic.verifySplashScreen();
        }

@Then("^User should be presented with Push Notifications screen$")

public void userShouldBePresentedWithPushNotificationsScreen() throws InterruptedException {

        appLoginScreenLogic.verifyPushNotificationScreen();
        appLoginScreenLogic.verifyReservationScreen();
        appLoginScreenLogic.readOTP();
        appLoginScreenLogic.verifyEnterOTPScreen();
        }

}
