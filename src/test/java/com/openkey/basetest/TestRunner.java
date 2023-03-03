



package com.openkey.basetest;

import com.openkey.setups.CapabilitiesManager;
import com.openkey.utils.AllureReporting;
import com.openkey.utils.DataBaseHandler;
import com.openkey.utils.HooksManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.testng.*;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.SQLException;

    @CucumberOptions(
            plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","com.openkey.utils.HooksManager"},
            monochrome = true,
            //tags = {"~@LoginToHostPortalInAndroidMobileDevice", "~@Tag2"},//"not @LoginToHostPortalInAndroidMobileDevice",// and not @CreateGuestSessionInHostPortalInAndroidMobileDevice and not @WelcomeMessageReactNativeAndroidApp",
            features = "src/main/com.openkey.resources/features",
            glue = {"com.openkey.steps","com/openkey/utils"},
            publish = true,
            dryRun = false
    )

    public class TestRunner extends CapabilitiesManager{


        ITestResult result;

        private TestNGCucumberRunner testNGCucumberRunner;
        static AllureReporting allureReporting ;
        static DataBaseHandler dataBaseHandler;

        public TestRunner() throws IOException {

          allureReporting = new AllureReporting();
          dataBaseHandler=new DataBaseHandler();

        }

        @BeforeClass(alwaysRun = true)
        public void setUpClass() {

          testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

        }

        @BeforeTest(alwaysRun = true)

        public void cleanOldReportsData() throws IOException {

          allureReporting.cleanUpAllureDirectory();


        }


        @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
        public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {


            testNGCucumberRunner.runScenario(pickleWrapper.getPickle());


            }



     @AfterMethod
       public void haltExecutionOnFailure(ITestResult result) {

         if (result.getStatus() == ITestResult.FAILURE) {

             testNGCucumberRunner.finish();

         }
      }



       @DataProvider
        public Object[][] scenarios() {

          return testNGCucumberRunner.provideScenarios();

        }

       @AfterTest (alwaysRun = true)

        public void createpropFile() throws IOException, SQLException, ClassNotFoundException {

          allureReporting.envFileWriter();
           allureReporting.executorFileWriter();
            dataBaseHandler.setupConnection();

        }


       @AfterClass(alwaysRun = true)
        public void tearDownClass()  {


           testNGCucumberRunner.finish();

        }

    }




