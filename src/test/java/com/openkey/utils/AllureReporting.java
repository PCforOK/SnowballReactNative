package com.openkey.utils;

import com.openkey.screens.OpenKeyDoorLockScreen;
import com.openkey.setups.CapabilitiesManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AllureReporting extends CapabilitiesManager {

    String path;
    Properties pr;

    public void envFileWriter() throws IOException {

       /* System.out.println("Hi in envFileWriter"+deviceName);
        System.out.println("Hi in envFileWriter"+platformName);
        System.out.println("Hi in envFileWriter"+platformVersion);
        System.out.println("Hi in envFileWriter"+appPackage);
        System.out.println("Hi in envFileWriter"+String.valueOf(OpenKeyDoorLockScreen.totalNumberOfLockOpeningAttempts));
        System.out.println("Hi in envFileWriter"+String.valueOf(OpenKeyDoorLockScreen.lockOpenFailureCount));
*/
        path = "allure-results\\environment.properties";
        System.out.println("Path :"+path);
        FileOutputStream outputStream = new FileOutputStream(path, true);
         pr = new Properties();

        pr.put("Total number of times the test executed", String.valueOf(OpenKeyDoorLockScreen.totalNumberOfLockOpeningAttempts));
        pr.put("Number of times lock opens successfully : ", String.valueOf(OpenKeyDoorLockScreen.lockOpenSuccessCount));
        pr.put("Number of times lock opening failed  : ",  String.valueOf(OpenKeyDoorLockScreen.lockOpenFailureCount));
        pr.put("Device Name :", deviceName);
        pr.put("deviceType : ", platformName);
        pr.put("platformVersion : ", platformVersion);
        pr.store(outputStream,"Allure Report Results");



        }




        }
