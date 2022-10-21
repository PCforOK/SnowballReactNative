package com.openkey.server.service;

import com.openkey.server.objects.AutomationTest;
import com.openkey.server.objects.Rail;
import com.openkey.server.objects.TestApp;
import com.openkey.server.objects.User;
import com.openkey.server.repository.AutomationTestRepository;
import com.openkey.server.repository.TestAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class TestCreationService {

    @Autowired
    private AutomationTestRepository automationTestRepository;


    public AutomationTest createTest(User user, Rail rail){
        AutomationTest test = new AutomationTest();
        test.setRail(rail);
        test.setStatus("Incomplete");
        test.setUser(user);
        return automationTestRepository.save(test);
    }
    public AutomationTest createTest(User user, Rail rail, AutomationTest formTest, TestApp testApp){
        AutomationTest test = new AutomationTest();
        test.setRail(rail);
        test.setTestApp(testApp);
        test.setStatus("Incomplete");
        test.setUser(user);
        //test.setTestApp(formTest.getTestApp());

        test.setInvocationCount(formTest.getInvocationCount());
        test.setPlatform(formTest.getPlatform());

        if(formTest.getPlatform().equals("iphone")){
            test.setPhone(rail.getIPhone());
        } else if (formTest.getPlatform().equals("android")) {
            test.setPhone(rail.getAndroid());
        }

        test.setTestToRun(formTest.getTestToRun());
        test.setDateCreated(LocalDateTime.now());
        test.setLockType(rail.getLockType());
        return automationTestRepository.save(test);
    }
    public void updateTestStatus(AutomationTest test, String status){
        test.setStatus(status);
        automationTestRepository.save(test);
    }

    public Optional<AutomationTest> findById(Long id) { return automationTestRepository.findById(id); }
    public Set<AutomationTest> findByUser(User user) {
       return automationTestRepository.findByUser(user);
    }

    public Set<AutomationTest> findByRail(Rail rail) {
        return automationTestRepository.findByRail(rail);
    }
}
