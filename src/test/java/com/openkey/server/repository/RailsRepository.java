package com.openkey.server.repository;

import com.openkey.server.objects.Rail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RailsRepository extends JpaRepository<Rail, Long> {
    List<Rail> findAll(Sort sort);
    Optional<Rail> findById(Long id);
    Set<Rail> findByRailName(String railName);
}
