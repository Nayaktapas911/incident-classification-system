package com.IncidentClassificationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IncidentClassificationSystem.entity.ClassifiedText;

public interface ClassifiedTextRepository extends JpaRepository<ClassifiedText, Long> {

}
