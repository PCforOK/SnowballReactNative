package com.openkey.basetest;

import com.openkey.setups.CapabilitiesManager;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
    monochrome = true,
    tags = "not @MoreMenuAndroidApp and not @ShareKeyFeature",
    features = "src/main/com.openkey.resources/features",
    glue = "com.openkey.steps",
    publish = true
)

public class TestRunner extends CapabilitiesManager {

    private TestNGCucumberRunner testNGCucumberRunner;

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

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {

        //if (driver.removeApp(appPackage)) {
          //  System.out.println("App is now uninstalled");
        //}
        testNGCucumberRunner.finish();

    }

}
