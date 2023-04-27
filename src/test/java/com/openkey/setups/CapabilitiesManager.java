package com.openkey.setups;

import com.google.common.collect.ImmutableMap;
import com.openkey.utils.HooksManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CapabilitiesManager {

    /**
     * Make the driver static. This allows it to be created only once
     * and used across all the test classes.
     */
    //protected AppiumDriver driver;
    public static AndroidDriver driver;
    public static String appPackage;

    public static String appActivity;
    public static String platformName;
    public static String platformVersion;
    public static String deviceName;

    public static int lockCounter=0;

    public static HooksManager hooksManager;

    public static Logger logger = LogManager.getLogManager().getLogger("CapabilitiesManager.class");

    public static SessionId sessionId;

    /**
     * This method runs before any other method,
     * We are setting up our appium client in order to connect ios and android devices to appium server
     */
    @BeforeTest
    public void preparation() throws IOException {

        hooksManager = new HooksManager();
        // Use empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
        YamlConfigReader.inititializeyaml();

        // Reading capabilities from yaml file using getDesired_capabilities() method in YamlConfigReader class
        String [] desiredCapabilities= YamlConfigReader.getDesired_capabilities();
        platformName = desiredCapabilities[0];
        platformVersion = desiredCapabilities[1];
        deviceName = desiredCapabilities[2];
        appPackage = desiredCapabilities[3];
        appActivity = desiredCapabilities[4];
        String orientation = desiredCapabilities[5];
        lockCounter = Integer.parseInt(desiredCapabilities[6]);

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
        System.out.println("orientation : " +orientation);
        System.out.println("lock counter : " +lockCounter);

        // Read the DesiredCapabilities from ok-envds.yaml for OpenKey V5 Live-Debug App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability("appPackage",appPackage);
        capabilities.setCapability("appActivity",appActivity);
        /** Commented appPackage and appActivity because we've automated installing and launch app through app center*/

        // Set Device orientation
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, orientation);

        // Appium CapabilitiesManager
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
        capabilities.setCapability("no-reset", "false");
        //setting up chrome as browser capability
       // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        // capabilities.setCapability("app-package", "com.android.chrome");
        // capabilities.setCapability("app-activity", "com.google.android.apps.chrome.Main");
        // capabilities.setCapability("chromedriverExecutableDir", "chromedriver/chromedriver.exe");
        // capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));


        // Start Session in Android Device

        final URL server = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(server, capabilities);
        System.out.println("Appium server started..." + server);
        System.out.println("Android session started:" + capabilities);

        // Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("Browser Launched");
        //driver.get("https://hostdev.openkey.co/login");
        System.out.println("Host portal login link is opened");

        System.out.println(System.getenv());
        sessionId=driver.getSessionId();
    }

   // @AfterTest
    // Stop Appium Server
    //public void stopAppiumServer() {

      //  Runtime runtime = Runtime.getRuntime();
        //try {
          //  runtime.exec("killall node");
           // System.out.println("Appium server stopped...");
        //} catch (IOException e) {
          //  e.printStackTrace();
           // System.out.println("No matching appium processes belonging to you were found!");

        //}
    //}
}

