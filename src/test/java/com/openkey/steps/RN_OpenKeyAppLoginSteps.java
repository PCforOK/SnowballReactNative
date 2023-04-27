package com.openkey.steps;

import com.openkey.utils.AllureReporting;
import com.openkey.utils.HooksManager;
import com.openkey.utils.LogsHandler;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;




public class RN_OpenKeyAppLoginSteps extends BaseSteps {



    @Before

    public void setups() throws IOException {

        setupScreens(driver);



    }


    @Given("^User is at Permission Required Screen$")
    public void user_Is_At_Permission_Required_Screen() {

        openKeyMobileAndroidAppLoginScreen.verifyPermissionRequiredScreen();

        System.out.println("Permission Required Screen is displayed successfully");

        hooksManager.stepsScreenshots();

    }


    @When("^User clicks NEXT over Permission Required Screen$")
    public void user_Clicks_NEXT_Over_Permission_Required_Screen() {

        openKeyMobileAndroidAppLoginScreen.verifyPermissionScreensAction();
        hooksManager.stepsScreenshots();
    }

    @Then("^User should be presented with Find My Reservation Screen$")

    public void user_should_be_presented_with_find_my_reservation_screen() throws IOException {

        openKeyMobileAndroidAppLoginScreen.verifyFindMyReservationScreen();
        hooksManager.stepsScreenshots();

    }



    @Given("^User is at Find My Reservation screen$")
    public void userIsAtFindMyReservationScreen() {
    }


    @When("^User enters registered mobile number and clicks 'SUBMIT'$")

    public void user_enters_registered_mobile_number_and_clicks_submit() throws InterruptedException, IOException {

        openKeyMobileAndroidAppLoginScreen.verifyRegistrdMobileNumEnter();
        hooksManager.stepsScreenshots();

        openKeyMobileAndroidAppLoginScreen.verifyRegistrdMobileNumSubmit();
        hooksManager.stepsScreenshots();

    }

    @Then("^OPT INTO MESSAGING Screen should be displayed$")
    public void opt_INTOMESSAGING_Screen_Should_Be_Displayed() {
    }

    @Given("^User is at OPT INTO MESSAGING Screen$")
    public void user_Is_At_OPT_INTO_MESSAGING_Screen() {
    }

    @When("^User click Next button over OPT INTO MESSAGING screen$")
    public void userClickNextButtonOverOPTINTOMESSAGINGScreen() throws InterruptedException {

        openKeyMobileAndroidAppLoginScreen.verifyOptIntoMessaging();

    }

    @Then("^User should be presented with VERIFICATION Screen$")
    public void userShouldBePresentedWithVERIFICATIONScreen() {

        //openKeyMobileAndroidAppLoginScreen.verifyVerificationScreen();

        //hooksManager.stepsScreenshots();

    }




    @When("^User receives the verification code$")

    public void user_receives_the_verification_code() throws IOException {

        openKeyMobileAndroidAppLoginScreen.readVerificationCode();
        hooksManager.stepsScreenshots();


    }

    @And("^User Enters received verification code$")

    public void user_enters_received_verification_code() throws InterruptedException, IOException {

        openKeyMobileAndroidAppLoginScreen.verifyEnterVerificationCodeAction();

        hooksManager.stepsScreenshots();


    }

    @Then("^Verification Code should be validated successfully$")

    public void verification_code_should_be_validated_successfully() throws IOException {

        System.out.println("VERIFICATION CODE is entered successfully");
        hooksManager.stepsScreenshots();

    }













}
