package com.openkey.basetest;

import com.openkey.setups.CapabilitiesManager;
import com.openkey.utils.AllureReporting;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import java.io.IOException;

@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,
        tags = "@AppLaunchRNAndroidApp or @AppLoginRNAndroidApp or @DownloadMobileKey or @OpenKeyDoorLockReactNativeApp",
        features = "src/main/com.openkey.resources/features",
        glue = "com.openkey.steps",
        publish = true
)

public class TestRunner extends CapabilitiesManager {

    private TestNGCucumberRunner testNGCucumberRunner;

    public TestRunner() throws IOException {
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());


    }

    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {

        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());

    }

    @DataProvider
    public Object[][] scenarios() {

        return testNGCucumberRunner.provideScenarios();

    }

@AfterTest (alwaysRun = true)

public void createpropFile() throws IOException {

  AllureReporting allureReporting = new AllureReporting();
    allureReporting.envFileWriter();

    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws IOException {


        testNGCucumberRunner.finish();

    }

}
