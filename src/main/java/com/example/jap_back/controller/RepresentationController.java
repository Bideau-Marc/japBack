package com.example.jap_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.jap_back.model.Representation;
import com.example.jap_back.repository.RepresentationRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/representation")
public class RepresentationController {
    @Autowired
    private RepresentationRepository representationRepository;

    @GetMapping()
    public List<Representation> getRepresentation() {
        return representationRepository.findAll();
    }

}
