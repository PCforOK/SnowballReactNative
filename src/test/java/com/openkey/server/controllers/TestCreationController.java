package com.openkey.server.controllers;

import com.openkey.server.errors.AppNotFoundException;
import com.openkey.server.objects.AutomationTest;
import com.openkey.server.objects.Rail;
import com.openkey.server.errors.RailNotFoundException;
import com.openkey.server.objects.TestApp;
import com.openkey.server.objects.User;
import com.openkey.server.service.RailDetailsService;
import com.openkey.server.service.TestAppDetailsService;
import com.openkey.server.service.TestCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tests")
public class TestCreationController {

    @Autowired
    private TestCreationService testCreationService;
    @Autowired
    private RailDetailsService railDetailsService;
    @Autowired
     private TestAppDetailsService testAppDetailsService;
    TestController testController = new TestController();

    @PostMapping("{railId}")
    public ResponseEntity<?> createAutomationTest (@PathVariable Long railId, @RequestBody AutomationTest test, @AuthenticationPrincipal User user) throws RailNotFoundException, AppNotFoundException {
        Rail rail = railDetailsService.findById(railId).orElseThrow(() -> new RailNotFoundException("Error: Rail " + railId + " not found"));
      /* test.setTestApp(testAppDetailsService.findById(Long.parseLong(test.getAppId())).orElseThrow(() ->
                new AppNotFoundException("Error: TestApp " + test.getAppId() + " not found")));*/
        TestApp app = testAppDetailsService.findById(Long.parseLong(test.getAppId())).orElseThrow(() ->
                new AppNotFoundException("Error: TestApp " + test.getAppId() + " not found"));
        System.out.println(test.getAppId());
        AutomationTest newTest = testCreationService.createTest(user, rail, test, app);


        testController.testRunner(newTest);
        return ResponseEntity.ok(newTest);
    }
   @GetMapping("{testId}")
   public ResponseEntity<?>  getAutomationTest(@AuthenticationPrincipal User user, @PathVariable Long testId){
        Optional<AutomationTest> automationTestOptional = testCreationService.findById(testId);
        AutomationTest newTest = Objects.requireNonNull(automationTestOptional.stream().findFirst().orElse(null));


        return ResponseEntity.ok(newTest);
   }
   @GetMapping("/apps")
   public ResponseEntity<?> getApps(@AuthenticationPrincipal User user){
       Set<TestApp> findAllApps = testAppDetailsService.findAllApps();
       return ResponseEntity.ok(findAllApps);
   }


    @GetMapping("")
    public ResponseEntity<?> getUserAutomationTests(@AuthenticationPrincipal User user){
        Set<AutomationTest> automationTests = testCreationService.findByUser(user);
        return ResponseEntity.ok(automationTests);
    }
}
