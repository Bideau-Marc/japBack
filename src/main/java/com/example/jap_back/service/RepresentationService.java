package com.example.jap_back.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.jap_back.model.Representation;
import com.example.jap_back.repository.RepresentationRepository;
import java.util.*;

public class RepresentationService {
    @Autowired
    private RepresentationRepository representationRepository;

    public Representation createRepresentation(Representation representation) {
        return representationRepository.save(representation);
    }

    public Representation getRepresentationById(Long id) {
        return representationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Representation not founded"));
    }

    public Representation updateRepresentation(Representation representation) {
        return representationRepository.save(representation);
    }

    public void deleteRepresentation(Representation representation) {
        representationRepository.delete(representation);
    }

    public List<Representation> getAllRepresentation() {
        return representationRepository.findAll();
    }
}