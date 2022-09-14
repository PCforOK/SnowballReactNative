package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AppLoginScreenLogic extends BaseScreen {
    By pushNotificationHeader= By.xpath("//android.widget.TextView[@text='PUSH NOTIFICATIONS']");
By btnNext= By.xpath("//android.widget.TextView[@text='NEXT']");
By titleFindReservation=By.xpath("//android.widget.TextView[@text='FIND MY RESERVATION']");
By txtFieldMobileNumber=By.xpath("//android.widget.EditText[@text='MOBILE NUMBER OR EMAIL']");
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
    }


    public void verifyReservationScreen () throws InterruptedException {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(titleFindReservation)).isDisplayed());
        //wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldMobileNumber)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldMobileNumber)).sendKeys("+91-9457221143");
        //driver.navigate().back();
        driver.hideKeyboard();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit)).isEnabled());
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit)).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit)).click();
        System.out.println("submit action is performed");
        Thread.sleep(5000);

    }

    public void readOTP (){

        driver.openNotifications();

        Boolean otpMsgBody=wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText().contains("Project Snowball");

        Assert.assertTrue(otpMsgBody);

        System.out.println("Login OTP message is :" +wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText());

       otpValue = wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText().split(" is")[0];

       System.out.println("OTP Value is :" +otpValue);
       driver.navigate().back();
    }

    public void verifyenterOTPScreen () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(titleVerificationScreen)).isDisplayed();

        List<WebElement> otpEditTextArray = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editBoxOtpInput));

        for (int i=0;i<otpValue.length();i++) {
            otpEditTextArray.get(i).sendKeys(String.valueOf(otpValue.charAt(i)));
        }

    }

}
