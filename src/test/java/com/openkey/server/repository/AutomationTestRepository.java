package com.openkey.server.repository;

import com.openkey.server.objects.AutomationTest;
import com.openkey.server.objects.Rail;
import com.openkey.server.objects.TestApp;
import com.openkey.server.objects.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AutomationTestRepository extends JpaRepository<AutomationTest, Long> {
        Set<AutomationTest> findByUser(User user);
        Optional<AutomationTest> findById(Long id);
        Set<AutomationTest> findByRail(Rail rail);

}
