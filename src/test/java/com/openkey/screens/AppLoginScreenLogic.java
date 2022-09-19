package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class AppLoginScreenLogic extends BaseScreen {
    By pushNotificationHeader= By.xpath("//android.widget.TextView[@text='PUSH NOTIFICATIONS']");
    By btnNext= By.xpath("//android.widget.TextView[@text='NEXT']");
    By titleFindReservation=By.xpath("//android.widget.TextView[@text='FIND MY RESERVATION']");
    By txtFieldMobileNumber=By.xpath("//android.widget.EditText");
    By btnSubmit=By.xpath("//android.widget.TextView[@text='SUBMIT']");
    By otpNotification = By.xpath("//android.widget.TextView[contains(@text,'Verification Code for Project Snowball.')]");
    By titleVerificationScreen=By.xpath("//android.widget.TextView[@text='VERIFICATION']");
    By editBoxOtpInput=By.xpath("//android.widget.EditText");

    String otpValue;
    public AppLoginScreenLogic(AndroidDriver driver) {
        super(driver);
    }

    public void verifySplashScreen (){


    }

    public void verifyPushNotificationScreen (){

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(pushNotificationHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(btnNext)).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnNext)).click();
        System.out.println("App is launched");
    }


    public void verifyReservationScreen () throws InterruptedException {
        System.out.println("Mobile Number Verification");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(titleFindReservation)).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldMobileNumber)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldMobileNumber)).sendKeys("+91-8826282580");
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit)).click();
        //Thread.sleep(5000);

    }

    public void readOTP (){

        driver.openNotifications();

        Boolean otpMsgBody=wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText().contains("Project Snowball");
        Assert.assertTrue(otpMsgBody);
        System.out.println("Login OTP is received");
        otpValue = wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText().split(" is")[0];
        driver.navigate().back();
    }

    public void verifyEnterOTPScreen () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(titleVerificationScreen)).isDisplayed();

        List<WebElement> otpEditTextArray = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editBoxOtpInput));

        for (int i=0;i<otpValue.length();i++) {
            otpEditTextArray.get(i).sendKeys(String.valueOf(otpValue.charAt(i)));
        }

    }

}
