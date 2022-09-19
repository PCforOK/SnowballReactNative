package com.openkey.steps;

import com.openkey.screens.*;
import com.openkey.setups.CapabilitiesManager;
import io.appium.java_client.android.AndroidDriver;

public class BaseSteps extends CapabilitiesManager {

    protected AppLoginScreenLogic appLoginScreenLogic;
    protected OpenKeyDownloadMobileKeyScreen openKeyDownloadMobileKeyScreen;
    protected OpenKeyDoorLockScreen openDoorLockScreen;


    public void setupScreens(AndroidDriver driver) {

        appLoginScreenLogic= new AppLoginScreenLogic(driver);
        openKeyDownloadMobileKeyScreen = new OpenKeyDownloadMobileKeyScreen(driver);
        openDoorLockScreen = new OpenKeyDoorLockScreen(driver);


    }

}
