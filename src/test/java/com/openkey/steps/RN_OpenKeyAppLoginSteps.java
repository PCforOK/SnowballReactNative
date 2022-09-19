package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RN_OpenKeyAppLoginSteps extends BaseSteps {

    @Before

    public void setups() {

        setupScreens(driver);

    }


    @Given("^User is at Push Notifications Screen$")

    public void user_is_at_push_notifications_screen() {

        openKeyMobileAndroidAppLoginScreen.verifyPushNotificationScreen();

    }

    @When("^User clicks 'NEXT' over Push Notifications Screen$")

    public void user_clicks_next_over_push_notifications_screen() {

        openKeyMobileAndroidAppLoginScreen.verifyNextBtnAction();

    }

    @Then("^User should be presented with Find My Reservation Screen$")

    public void user_should_be_presented_with_find_my_reservation_screen() {

        openKeyMobileAndroidAppLoginScreen.verifyFindMyReservationScreen();

    }

    @When("^User enters registered mobile number and clicks 'SUBMIT'$")

    public void user_enters_registered_mobile_number_and_clicks_submit() throws InterruptedException {

        openKeyMobileAndroidAppLoginScreen.verifyRegistrdMobileNumSubmit();
    }

    @Then("^VERIFICATION Screen should be displayed$")

    public void verification_screen_should_be_displayed() {

        openKeyMobileAndroidAppLoginScreen.verifyVerificationScreen();
    }

    @When("^User receives the verification code$")

    public void user_receives_the_verification_code() {

        openKeyMobileAndroidAppLoginScreen.readVerificationCode();

    }

    @And("^User Enters received verification code$")

    public void user_enters_received_verification_code() throws InterruptedException {

        openKeyMobileAndroidAppLoginScreen.verifyEnterVerificationCodeAction();

    }

    @Then("^Verification Code should be validated successfully$")

    public void verification_code_should_be_validated_successfully() {

        System.out.println("VERIFICATION CODE is entered successfully");

    }


}
