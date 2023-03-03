package com.openkey.steps;

import com.openkey.screens.*;
import com.openkey.setups.CapabilitiesManager;
import io.appium.java_client.android.AndroidDriver;
//import io.cucumber.plugin.event.Step;

import java.io.IOException;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Method;

public class BaseSteps extends CapabilitiesManager {





    protected RN_OpenKeyMobileAndroidAppLoginScreen openKeyMobileAndroidAppLoginScreen;
    protected RN_OpenKeyMobileAndroidAppLaunchScreen openKeyMobileAndroidAppLaunchScreen;
    protected OpenKeyDownloadMobileKeyScreen openKeyDownloadMobileKeyScreen;
    protected OpenKeyDoorLockScreen openDoorLockScreen;

    protected RN_OpenKeyMobileAndroidAppHamburgerMenuScreen openKeyMobileAndroidAppHamburgerMenuScreen;
    //protected OpenKeyAndroidHostPortalLoginScreen openKeyAndroidHostPortalLoginScreen;
    //protected OpenKeyAndroidHostPortalCreateSessionScreen openKeyAndroidHostPortalCreateSessionScreen;
    //protected OpenKeyWelcomeMessageScreen openKeyWelcomeMessageScreen;
    public void setupScreens(AndroidDriver driver) throws IOException {

        openKeyMobileAndroidAppLaunchScreen = new RN_OpenKeyMobileAndroidAppLaunchScreen(driver);
        openKeyMobileAndroidAppLoginScreen = new RN_OpenKeyMobileAndroidAppLoginScreen(driver);
        openDoorLockScreen = new OpenKeyDoorLockScreen(driver);
        openKeyDownloadMobileKeyScreen = new OpenKeyDownloadMobileKeyScreen(driver);
        openKeyMobileAndroidAppHamburgerMenuScreen = new RN_OpenKeyMobileAndroidAppHamburgerMenuScreen(driver);
        //openKeyAndroidHostPortalLoginScreen= new OpenKeyAndroidHostPortalLoginScreen(driver);
        //openKeyAndroidHostPortalCreateSessionScreen = new OpenKeyAndroidHostPortalCreateSessionScreen(driver);
        //openKeyWelcomeMessageScreen = new OpenKeyWelcomeMessageScreen(driver);
    }
}





