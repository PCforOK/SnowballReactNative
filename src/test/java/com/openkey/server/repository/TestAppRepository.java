package com.openkey.server.repository;

import com.openkey.server.objects.Rail;
import com.openkey.server.objects.TestApp;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestAppRepository extends JpaRepository<TestApp, Long> {
    List<TestApp> findAll(Sort sort);
    Optional<TestApp> findById(Long id);
}
