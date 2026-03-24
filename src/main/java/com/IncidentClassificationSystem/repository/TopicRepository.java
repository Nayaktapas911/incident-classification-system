package com.IncidentClassificationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IncidentClassificationSystem.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
