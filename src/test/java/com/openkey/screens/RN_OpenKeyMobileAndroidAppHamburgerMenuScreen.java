package com.openkey.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class RN_OpenKeyMobileAndroidAppHamburgerMenuScreen extends BaseScreen {

By titleMyStays = MobileBy.accessibilityId("myStayTitle");
By btnHamburgerMenu=MobileBy.accessibilityId("myStayHamburgerMenu");

By btnProfileMenu = By.xpath("//android.widget.TextView[@text='PROFILE']");

    By btnUpcomingStaysMenu = By.xpath("//android.widget.TextView[@text='UPCOMING STAYS']");
    By btnSecurityMenu = By.xpath("//android.widget.TextView[@text='SECURITY']");
    By btnSearchHotelsMenu = By.xpath("//android.widget.TextView[@text='SEARCH HOTELS']");
    By btnSleepSoundsMenu = By.xpath("//android.widget.TextView[@text='SLEEP SOUNDS']");

    By txtSleepAidTitle = By.xpath("//android.widget.TextView[@text='SLEEP AID']");

    By btnStreamSound = By.xpath("//android.widget.TextView[@text='STREAM']");

    By btnRainSound = By.xpath("//android.widget.TextView[@text='RAIN']");

    By btnCricketSound =  By.xpath("//android.widget.TextView[@text='CRICKET']");

    By btnMinuteTime= By.xpath("//android.widget.TextView[@text='15 MINUTES']");

    By btnHourTime= By.xpath("//android.widget.TextView[@text='1 HOUR']");

    By btnInfinityTime= By.xpath("//android.widget.TextView[@text=' INFINITY']");

    By btnPauseSleepAid = By.xpath("//android.widget.TextView[@text='PAUSE']");

    By titleSearchHotelScreen = By.xpath("//android.widget.TextView[@text='Search']");

    By txtFieldSearch = By.xpath("//android.widget.EditText[@text='Search City']");

    By btnSearchICON= By.xpath("//android.widget.TextView");

    By txtHoteSearchResults = By.xpath("//android.widget.TextView[@text='ARC THE HOTEL DC']");

    By txtProfileTitle =  By.xpath("//android.widget.TextView[@text='PROFILE']");

    By txtFieldsProfileScreens = By.xpath("//android.widget.EditText");

    By btnUpdateProfile = By.xpath("//android.widget.TextView[@text='UPDATE PROFILE']");

    By textUpdateSuccess = By.xpath("//android.widget.TextView[@text='Profile updated successfully']");

    By btnClosePopup = By.xpath("//android.widget.TextView[@text='CLOSE']");

    By btnbackArrow = By.xpath("//android.widget.TextView");

    By titleSecurity = By.xpath("//android.widget.TextView[@text=' SECURITY ']");

    By txtPatternLock = By.xpath("//android.widget.TextView");

    By btnToggle = By.xpath("//android.widget.Switch");

    By btnBackHeader= By.xpath("//android.widget.TextView[@text='\uE61C']");

    By btnCountryDropDown = By.xpath("//android.widget.TextView[@text='\uE61D']");



    By txtFieldCountrySearch = By.xpath("//android.widget.EditText[@text='Enter country name']");

    By txtCountrySearchPickup = By.xpath("//android.widget.TextView[@text='United States']");


    public RN_OpenKeyMobileAndroidAppHamburgerMenuScreen(AndroidDriver driver) throws IOException {
        super(driver);
    }


public void verifyMyStaysScreen () {

    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(titleMyStays)).isDisplayed());


}

    public void verifyHamburgerMenuClickAction () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnHamburgerMenu)).click();

    }

public void verifyHamburgerMenuItems() {

    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(btnProfileMenu)).isEnabled());

    System.out.println("'PROFILE' menu is enabled and displayed successfully");

    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(btnUpcomingStaysMenu)).isEnabled());

    System.out.println("'UPCOMING STAYS' menu is enabled and displayed successfully");

    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(btnSecurityMenu)).isEnabled());

    System.out.println("'SECURITY' menu is enabled and displayed successfully");

    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearchHotelsMenu)).isEnabled());

    System.out.println("'SEARCH HOTELS' menu is enabled and displayed successfully");

    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(btnSleepSoundsMenu)).isEnabled());

    System.out.println("'SLEEP SOUNDS' menu is enabled and displayed successfully");


    }


    public void verifyProfileClickAction () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnProfileMenu)).click();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(txtProfileTitle)).getText(),"PROFILE");

        System.out.println("SLEEP AID screen is displayed successfully");

    }


    public void verifyProfileScreenActions () throws InterruptedException {

        List<WebElement> profileTextFields = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(txtFieldsProfileScreens));


        profileTextFields.get(0).clear();
        profileTextFields.get(0).sendKeys("TestAnkit"+Math.round(Math.random()*100));

        profileTextFields.get(1).clear();
        profileTextFields.get(1).sendKeys("Ankit"+Math.round(Math.random()*100));

        profileTextFields.get(3).clear();
        profileTextFields.get(3).sendKeys("ankit"+Math.round(Math.random()*100)+"@eno8.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnUpdateProfile)).click();

        Assert.assertEquals( wait.until(ExpectedConditions.visibilityOfElementLocated(textUpdateSuccess)).getText(),"Profile updated successfully");

        System.out.println ("Profile is updated successfully");

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnClosePopup)).click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnbackArrow)).get(0).click();





    }

public void verifySecurityClickAction() {


    wait.until(ExpectedConditions.visibilityOfElementLocated(btnSecurityMenu)).click();

    Assert.assertEquals( wait.until(ExpectedConditions.visibilityOfElementLocated(titleSecurity)).getText()," SECURITY ");

}

    public void verifySecurityLocks() {

        String securitylockTypes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(txtPatternLock)).get(2).getText();

        System.out.println("Available Secutity Lock type is :" + securitylockTypes);


        switch (securitylockTypes) {

            case "PATTERN LOCK":

                wait.until(ExpectedConditions.visibilityOfElementLocated(btnToggle)).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(btnBackHeader)).click();

                driver.navigate().back();



                break;


            //case "TOUCH ID":

            //  System.out.println("Touch ID is available");

            // driver.navigate().back();

            // break;

            // case "FACE ID" :

            //   System.out.println("FACE ID is available");

            // driver.navigate().back();

            // break;
            //}

        }

    }
   public void verifySleepSoundsClickAction() {

       wait.until(ExpectedConditions.visibilityOfElementLocated(btnSleepSoundsMenu)).click();

       Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(txtSleepAidTitle)).getText(),"SLEEP AID");

       System.out.println("SLEEP AID screen is displayed successfully");

   }

    public void verifyTimerActionsSleepSounds() throws InterruptedException {



        wait.until(ExpectedConditions.visibilityOfElementLocated(btnStreamSound)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnMinuteTime)).click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPauseSleepAid)).click();

        driver.navigate().back();
    }

public void verifySearchHotelsClickAction () {

    wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearchHotelsMenu)).click();

    Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(titleSearchHotelScreen)).getText(),"Search");

    System.out.println("Search hotel screen is displayed successfully");

}

public void verifyHotelSearchAction () {

  // wait.until(ExpectedConditions.visibilityOfElementLocated(btnCountryDropDown)).click();

  // wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldCountrySearch)).sendKeys("United States");

   // wait.until(ExpectedConditions.visibilityOfElementLocated(txtCountrySearchPickup)).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(txtFieldSearch)).sendKeys("Washington");

    List<WebElement> searchIconList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnSearchICON));

    searchIconList.get(6).click();

   Assert.assertEquals( wait.until(ExpectedConditions.visibilityOfElementLocated(txtHoteSearchResults)).getText(),"ARC THE HOTEL DC");

   wait.until(ExpectedConditions.visibilityOfElementLocated(txtHoteSearchResults)).click();

   driver.navigate().back();
    driver.navigate().back();
    driver.navigate().back();

    }


}