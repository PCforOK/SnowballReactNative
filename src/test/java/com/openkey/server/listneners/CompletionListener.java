package com.openkey.server.listneners;

import com.openkey.server.objects.AutomationTest;
import com.openkey.server.service.TestCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CompletionListener implements ISuiteListener {
    @Autowired
    TestCreationService testCreationService;
     AutomationTest test;
    public CompletionListener(AutomationTest test){
        test = test;
    }
    @Override
    public void onFinish(ISuite suite) {
        testCreationService.updateTestStatus(test, "Complete");
        ISuiteListener.super.onFinish(suite);
    }
}
