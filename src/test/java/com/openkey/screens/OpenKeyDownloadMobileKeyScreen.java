package com.openkey.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class OpenKeyDownloadMobileKeyScreen extends BaseScreen {

    By animatedImage = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By roomNumberLabel = By.xpath("//android.widget.TextView[@text='Room 111']");

    By labelMyStays = MobileBy.accessibilityId("myStayTitle");
            By btnGetMyKey = By.xpath("//android.widget.TextView[@text='GET MY KEY']");


    public OpenKeyDownloadMobileKeyScreen(AndroidDriver driver) throws IOException {
        super(driver);
    }

    /**
     * Actions
     */
    public void verifyKeyDownloadingScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(animatedImage)).isDisplayed();
    }

    public void verifyActiveKeyScreen() {
    }

    public void verifyAccessToRoomNumber() {
        System.out.println("Access to Room Number : " + wait.until(ExpectedConditions.visibilityOfElementLocated(roomNumberLabel)).getText());
    }

    public void verifyPushNotificationForAccess() {

    }

    public void verifyContentOnActiveKeyScreen() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(roomNumberLabel)).isDisplayed();
        //System.out.println("Access to Room number : "+driver.findElement(roomNumberLabel).getText());
    }


    public void verifyMyStays() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(labelMyStays)).isDisplayed());
    }

    public void verifyGetMyKeyActions () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnGetMyKey)).click();
    }



}
