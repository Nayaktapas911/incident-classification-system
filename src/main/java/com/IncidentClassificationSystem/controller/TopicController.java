package com.IncidentClassificationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IncidentClassificationSystem.entity.Topic;
import com.IncidentClassificationSystem.service.TopicService;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@PostMapping
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.save(topic);
	}
}
