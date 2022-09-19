package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class OpenKeyDoorLockScreen extends BaseScreen {

    static int lockCounter = 0;
    /**
     * Mobile Elements
     */
    By btnRoomLock = By.xpath("//android.widget.ImageView[@index='0']");
    By allowAccess = By.id("com.android.permissioncontroller:id/permission_allow_button");
    //By checkDoorOpen = By.xpath("");
    By allowLocation = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By txtElementOnLockOpen = By.xpath("//android.widget.TextView[contains(@text,'This key unlocks your room and common areas')]");
    By doorOpenTxtMessage = By.xpath("//android.widget.TextView[contains(@text,'Your door is now unlocked.')]");
    String keyMessage;

    public OpenKeyDoorLockScreen(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Actions
     */

    public void verifyRoomClick() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> lockUIElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnRoomLock));
        lockUIElements.get(1).click();
        lockCounter = lockCounter + 1;
    }

    public void clickMyKeyMultipleTimes() throws InterruptedException {
        System.out.println("Clicking key multiple times");
        while (lockCounter < 3) {
            Thread.sleep(30000);
            verifyRoomClick();
            String msg = driver.findElement(doorOpenTxtMessage).getText();
            if (driver.findElement(doorOpenTxtMessage).isDisplayed()) {
                System.out.println(msg + "for : " + lockCounter + " times");
                Assert.assertEquals(msg, "Your door is now unlocked.");
            } else {
                System.out.println("Error in opening the lock");
            }

        }
    }

    public void accessGrantedCheck() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(allowAccess)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowAccess)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowLocation)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowLocation)).click();
    }


    public String verifyMessage() {
        //System.out.println("Message is :" + driver.findElement(txtElementOnLockOpen).getText());
        return driver.findElement(txtElementOnLockOpen).getText();

    }
}
