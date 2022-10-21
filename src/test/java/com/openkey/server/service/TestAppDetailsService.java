package com.openkey.server.service;

import com.openkey.server.objects.Rail;
import com.openkey.server.objects.TestApp;
import com.openkey.server.repository.TestAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TestAppDetailsService {
    @Autowired
   private TestAppRepository testAppRepository;

    public Set<TestApp> findAllApps(){
        List<TestApp> testApps = testAppRepository.findAll(Sort.by(Sort.Direction.ASC,"appName"));
        Set<TestApp> appSet = new HashSet<TestApp>(testApps);
        appSet.addAll(testApps);
        return appSet;
    }
    public Optional<TestApp> findById(Long testAppId) {
        return testAppRepository.findById(testAppId);
    }

}
