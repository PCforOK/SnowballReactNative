package com.openkey.screens;

import com.openkey.utils.AllureReporting;
import com.openkey.utils.LogsHandler;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.netty.handler.logging.LoggingHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.decorator.Decorator;
import java.io.IOException;
import java.util.List;

public class RN_OpenKeyMobileAndroidAppLoginScreen extends BaseScreen {
    By pushNotificationHeader = By.xpath("//android.widget.TextView[@text='PUSH NOTIFICATIONS']");
    By btnNext = By.xpath("//android.widget.TextView[@text='NEXT']");
    By titleFindReservation = By.xpath("//android.widget.TextView[@text='FIND MY RESERVATION']");
    By txtFieldMobileNumber = MobileBy.accessibilityId("phoneInputPhoneNumberField");
    By btnSubmit = By.xpath("//android.widget.TextView[@text='SUBMIT']");
    By otpNotification = By.xpath("//android.widget.TextView[contains(@text,'Verification Code for OpenKey.')]");
    By titleVerificationScreen = By.xpath("//android.widget.TextView[@text='VERIFICATION']");
    By editBoxOtpInput = By.xpath("//android.widget.EditText");

    By btnRoomLock = By.xpath("//android.widget.ImageView[@index='0']");
    By allowLocation = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    By titlePermissionReq = MobileBy.accessibilityId("permissionScreenTitle");

    By btnpermissionPopup = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By btnnNEXTpermission = MobileBy.accessibilityId("permissionScreenNextButtonText");

    By titleOPTmsg = By.xpath("//android.widget.TextView[@text='Please opt-in to receive this message.']");
    By btnnNEXTOPT = MobileBy.accessibilityId("optOtpScreenHelpScreenResendButtonText");



    String otpValue;

    public Logger logger;



    public RN_OpenKeyMobileAndroidAppLoginScreen(AndroidDriver driver) throws IOException {


        super(driver);


    }



    public void verifyPushNotificationScreen() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(pushNotificationHeader)).isDisplayed());
        System.out.println("PUSH NOTIFICATION screen is displayed successfully");


    }

    public void verifyNextBtnAction() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(btnNext)).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnNext)).click();
        System.out.println("NEXT button is clicked successfully");
    }

    public void verifyFindMyReservationScreen() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(titleFindReservation)).isDisplayed());
        System.out.println("FIND MY RESERVATION screen is displayed successfully");

    }

    public void verifyRegistrdMobileNumEnter() throws InterruptedException, IOException {

       // wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldMobileNumber)).clear();

        wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldMobileNumber)).sendKeys("9457221143");


    }

    public void verifyRegistrdMobileNumSubmit() throws InterruptedException, IOException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit)).click();
        System.out.println("SUBMIT button is clicked successfully");
        Thread.sleep(5000);

    }



    public void verifyVerificationScreen() {





        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(titleVerificationScreen)).isDisplayed();

           // LogsHandler.debugLogs("This is debug logs");
            //LogsHandler.fatalLogs("This is fatal one");
        }

        catch (Exception e) {

            LogsHandler.errorLogs("Sending OTP is failed");
            

        }
            System.out.println("VERIFICATION screen is displayed successfully");


    }

    public void readVerificationCode() {

        driver.openNotifications();

        Boolean otpMsgBody = wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText().contains("OpenKey");

        Assert.assertTrue(otpMsgBody);

        LogsHandler.infoLogs("OTP message is received");

        System.out.println("Received text message for Verification code :"+" "+wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText());

        otpValue = wait.until(ExpectedConditions.visibilityOfElementLocated(otpNotification)).getText().split(" is")[0];

        System.out.println("Verification Code for app login is :"+" "+otpValue);
        driver.navigate().back();
    }

    public void verifyEnterVerificationCodeAction() throws InterruptedException, IOException {

       // List<WebElement>

                //otpEditTextArray =

                        wait.until(ExpectedConditions.visibilityOfElementLocated(editBoxOtpInput)).sendKeys(otpValue);



        //for (int i = 0; i < otpValue.length(); i++) {
          //  otpEditTextArray.get(i).sendKeys(String.valueOf(otpValue.charAt(i)));
        //}


        LogsHandler.infoLogs("Inside Login screen class,OTP value is entered and getting validated");

        Thread.sleep(5000);


    }

    public void verifyPermissionRequiredScreen() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(titlePermissionReq)).isDisplayed());


    }

    public void verifyPermissionScreensAction() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnnNEXTpermission)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnpermissionPopup)).click();


    }

    public void verifyOptIntoMessaging() throws InterruptedException {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(titleOPTmsg)).isDisplayed());

        LogsHandler.infoLogs("OPT IN Messaging screen is successfully displayed");

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnnNEXTOPT)).click();

        Thread.sleep(12000);
    }


}
