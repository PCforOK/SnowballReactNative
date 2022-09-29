package com.openkey.utils;

import com.openkey.screens.OpenKeyDoorLockScreen;
import com.openkey.screens.RN_OpenKeyMobileAndroidAppLoginScreen;
import com.openkey.setups.CapabilitiesManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AllureReporting extends CapabilitiesManager {

    String path;

    public void envFileWriter() throws IOException {


        path = "allure-results/environment.properties";
        FileOutputStream outputStream = new FileOutputStream(path);
        Properties pr = new Properties();

        //pr.setProperty("set OTP VALUE IS",RN_OpenKeyMobileAndroidAppLoginScreen.otpValue);
        pr.setProperty("Device Name :", deviceName);
        pr.setProperty("deviceType : ", platformName);
        pr.setProperty("platformVersion : ", platformVersion);
        pr.setProperty("appPackage : ", appPackage);
        pr.setProperty("appActivity : ", appActivity);
        pr.setProperty("orientation : ", orientation);
        pr.setProperty("Lock Counter Value", String.valueOf(OpenKeyDoorLockScreen.lockCounter));
        pr.store(new FileOutputStream(path),"test ankit reports");



        }




        }
