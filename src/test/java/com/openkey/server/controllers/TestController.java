package com.openkey.server.controllers;

import com.openkey.basetest.TestRunner;
import com.openkey.server.errors.TestNotFoundException;
import com.openkey.server.listneners.CompletionListener;
import com.openkey.server.listneners.InvocationListener;
import com.openkey.server.objects.AutomationTest;
import com.openkey.server.repository.AutomationTestRepository;
import com.openkey.server.service.TestCreationService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestController {

    WebDriver driver;
    WebDriverWait wait;
    @Autowired
    private TestCreationService testCreationService;

    public void testRunner(AutomationTest newTest) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("rail", newTest.getRail().getRailName());
        params.put("device", newTest.getPhone().getDevice_name());
        params.put("os_version", newTest.getPhone().getOs_version());
        params.put("os", newTest.getPhone().getOs());
        params.put("invocationCount", String.valueOf(newTest.getInvocationCount()));
        params.put("appPack", newTest.getTestApp().getAppPackage());
        params.put("appAct", newTest.getTestApp().getAppActivity());





        // Running TestNG programmatically
        // http://testng.org/doc/documentation-main.html#running-testng-programmatically

        //Create an instance on TestNG
        TestNG testNG = new TestNG();
        testNG.addListener(new InvocationListener(newTest.getInvocationCount()));
        //testNG.addListener(new CompletionListener((newTest)));
        //Create an instance of XML Suite and assign a name for it.
        XmlSuite suite = getXmlSuite();

        //Create an instance of XmlTest and assign a name for it.
        XmlTest test = getXmlTest(suite);

        //Add any parameters that you want to set to the Test.
        test.setParameters(params);

        //Create a list which can contain the classes that you want to run.
        List<XmlClass> classes = getXmlClasses();

        //Assign that to the XmlTest Object created earlier.
        test.setXmlClasses(classes);


        //Create a list of XmlTests and add the Xmltest you created earlier to it.
        List<XmlTest> tests = new ArrayList<XmlTest>();
        tests.add(test);

        //add the list of tests to your Suite.
        suite.setTests(tests);

        //Add the suite to the list of suites.
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);

        //Set the list of Suites to the testNG object you created earlier.

        testNG.setXmlSuites(suites);




        //invoke run() - this will run your class.
        testNG.run();

    }

    private XmlSuite getXmlSuite() {
        XmlSuite suite = new XmlSuite();
        suite.setName("OpenKey Mobile App Automation");
        return suite;
    }

    private XmlTest getXmlTest(XmlSuite suite) {
        XmlTest test = new XmlTest(suite);

        test.setVerbose(2);
        test.setPreserveOrder(true);
        test.setName("GuestLoginTest");


        return test;
    }

    private List<XmlClass> getXmlClasses() {
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("com.openkey.basetest.TestRunner"));
        return classes;
    }
}
