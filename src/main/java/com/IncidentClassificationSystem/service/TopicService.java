package com.IncidentClassificationSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IncidentClassificationSystem.entity.Topic;
import com.IncidentClassificationSystem.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public Topic save(Topic topic) {
		return topicRepository.save(topic);
	}

	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}
}
