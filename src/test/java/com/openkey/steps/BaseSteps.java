package com.openkey.steps;

import com.openkey.screens.*;
import com.openkey.setups.CapabilitiesManager;
import io.appium.java_client.android.AndroidDriver;

public class BaseSteps extends CapabilitiesManager {
    protected AppLoginScreenLogic appLoginScreenLogic;

    public void setupScreens(AndroidDriver driver) {

        appLoginScreenLogic = new AppLoginScreenLogic(driver);


    }

}
