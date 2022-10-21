package com.openkey.server.service;

import com.openkey.server.objects.Phone;
import com.openkey.server.objects.Rail;
import com.openkey.server.repository.RailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RailDetailsService {
    @Autowired
    private RailsRepository railsRepository;

    public Set<Rail> findAllRails(){
        List<Rail> rails = railsRepository.findAll(Sort.by(Sort.Direction.ASC,"railName"));
        Set<Rail> railSet = new HashSet<Rail>(rails);
        railSet.addAll(rails);
        return railSet;
    }

    public Optional<Rail> findById(Long railId) {
        return railsRepository.findById(railId);
    }
}
