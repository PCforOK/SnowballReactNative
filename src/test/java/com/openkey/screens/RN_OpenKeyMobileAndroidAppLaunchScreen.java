package com.openkey.screens;

import com.openkey.utils.LogsHandler;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.openkey.utils.LogsHandler;

import java.io.IOException;

public class RN_OpenKeyMobileAndroidAppLaunchScreen extends BaseScreen {



    By splashLocator = By.xpath("//android.widget.TextView[@content-desc=\"OpenKey\"]");

    public RN_OpenKeyMobileAndroidAppLaunchScreen(AndroidDriver driver) throws IOException {
        super(driver);


    }

    public void verifyIfAppInstalled() {

        if (driver.isAppInstalled("co.openkey.guest.dev")) {

            System.out.println("App is already installed in the device");
        } else {

            System.out.println("App is not Installed in the Device,Install it first to continue");

        }

    }


    public void verifySplashScreen() {

        if (driver.currentActivity().equalsIgnoreCase("co.openkey.guest.MainActivity")) ;

        System.out.println("Splash screen is displayed successfully");

        LogsHandler.infoLogs("Inside Launch Screen class, Splash is displayed");


    }


}
