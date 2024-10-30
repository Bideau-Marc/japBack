package com.example.jap_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jap_back.model.Representation;

@Repository
public interface RepresentationRepository extends JpaRepository<Representation, Long> {

}
