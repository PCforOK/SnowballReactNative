package com.openkey.steps;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

//import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class OpenKeyDoorLockOpenSteps extends BaseSteps {

    @Before

    public void setups() throws IOException {

        setupScreens(driver);

    }






    @When("^Guest clicks on Key Icon on My Key Screen$")
    public void guestClicksOnKeyIconOnMyKeyScreen() throws InterruptedException {
        openDoorLockScreen.verifyRoomClick();
        Thread.sleep(8000);
        System.out.println("Lock opens successfully for first time");
    }

    @Then("Permissions should be allowed")
    public void permissionsShouldBeAllowed() throws InterruptedException {
        openDoorLockScreen.accessGrantedCheck();
    }

    @And("^Guest door lock should open$")
    public void verifyDoorOpens() {
        // openDoorLockScreen.verifyLockOpen();
        // System.out.println("lock opens successfully!");
    }

    @And("message this key unlocks your room should display")
    public void messageThisKeyUnlocksYourRoomShouldDisplay() {
        String message = openDoorLockScreen.verifyMessage();
        Assert.assertEquals(message, "This key unlocks your room and common areas.");
    }

    @When("I click the main key multiple times")
    public void iClickTheMainKeyMultipleTimes() throws InterruptedException {
        openDoorLockScreen.clickMyKeyMultipleTimes();
    }

    @Then("it should open the lock successfully each time")
    public void itShouldOpenTheLockSuccessfullyEachTime() throws InterruptedException {
        // openDoorLockScreen.clickMyKeyMultipleTimes();

    }
}
