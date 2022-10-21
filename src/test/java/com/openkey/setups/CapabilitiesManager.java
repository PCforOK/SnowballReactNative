package com.openkey.setups;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CapabilitiesManager {

    /**
     * Make the driver static. This allows it to be created only once
     * and used across all the test classes.
     */
    //protected AppiumDriver driver;
    public static AndroidDriver driver;
    public String appPackage ;

    /*// BrowserStack CapabilitiesManager
    public static String userName = "monalirajgor_jbYTIH";
    public static String accessKey = "dHT1pQpC7gmB3xnEdAuh";*/

    // Appium Local service
    //protected AppiumDriverLocalService service;

    /**
     * This method runs before any other method,
     * We are setting up our appium client in order to connect ios and android devices to appium server
     */

    //Enables Tests to be run through webpage or intellij
    @Parameters({"rail", "device", "os", "os_version", "appPack", "appAct"})
    @BeforeTest
    public void preparation(@Optional String rail, @Optional String device, @Optional String os,
                            @Optional String os_version, @Optional String appPack, @Optional String appAct) throws IOException {
        // Use empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
        YamlConfigReader.inititializeyaml();

        // Reading capabilities from yaml file using getDesired_capabilities() method in YamlConfigReader class
        String [] desiredCapabilities= YamlConfigReader.getDesired_capabilities();

        //Comment Out if not using Webpage
        if(rail != null) {
            desiredCapabilities[0] = os;
            desiredCapabilities[1] = os_version;
            desiredCapabilities[2] = device;
            desiredCapabilities[3] = appPack;
            desiredCapabilities[4] = appAct;
        }

        String platformName = desiredCapabilities[0];
        String platformVersion = desiredCapabilities[1];
        String deviceName = desiredCapabilities[2];
        appPackage = desiredCapabilities[3];
        String appActivity = desiredCapabilities[4];
        String orientation = desiredCapabilities[5];

        String [] getCredentials= YamlConfigReader.getCredentials();
        String appId = getCredentials[0];
        String userName = getCredentials[1];
        String password = getCredentials[2];

        System.out.println("App Center credentials :");
        System.out.println("Id : " +appId);
        System.out.println("user : " +userName);
        System.out.println("Password : " +password);

        System.out.println("Desired CapabilitiesManager");
        System.out.println("Device Name : " +deviceName);
        System.out.println("deviceType : " +platformName);
        System.out.println("platformVersion : " +platformVersion);
        System.out.println("appPackage : " +appPackage);
        System.out.println("appActivity : " +appActivity);
        System.out.println("orientation : " +orientation);

        // Read the DesiredCapabilities from ok-envds.yaml for OpenKey V5 Live-Debug App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        /*// Set the DesiredCapabilities for OpenKey V5 Live-Debug App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8N603SCCB");
        capabilities.setCapability("appPackage", "com.openkey.guest");
        capabilities.setCapability("appActivity", "com.openkey.guest.ui.activities.LauncherActivity");*/

        // Set Device orientation
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, orientation);

        // Appium CapabilitiesManager
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("ignoreHiddenApiPolicyError", "true");

        // Start Appium Server - Using appium command in Terminal


        // Start Session in Android Device
        final URL server = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(server, capabilities);
        System.out.println("Appium server started..." + server);
        System.out.println("Android session started:" + capabilities);

        // Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


}

