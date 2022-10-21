package com.openkey.server.controllers;


import com.openkey.server.objects.Rail;
import com.openkey.server.objects.User;
import com.openkey.server.service.RailDetailsService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/railView")
public class RailViewController {
    @Autowired
    private RailDetailsService railDetailsService;

    @GetMapping("")
    public ResponseEntity<?> getRails(@AuthenticationPrincipal User user){
        Set<Rail> findAllRails = railDetailsService.findAllRails();
        return ResponseEntity.ok(findAllRails);
    }
    @GetMapping("{railId}")
    public ResponseEntity<?> getRail(@PathVariable Long railId, @AuthenticationPrincipal User user) {
        Optional<Rail> railOpt = railDetailsService.findById(railId);
        return ResponseEntity.ok(railOpt.orElse(new Rail()));
    }
}
