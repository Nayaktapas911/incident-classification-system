package com.IncidentClassificationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IncidentClassificationSystem.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
