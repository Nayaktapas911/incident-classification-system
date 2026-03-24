package com.IncidentClassificationSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IncidentClassificationSystem.entity.ClassifiedText;
import com.IncidentClassificationSystem.repository.ClassifiedTextRepository;
import com.IncidentClassificationSystem.repository.DocumentRepository;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private ClassifiedTextRepository classifiedTextRepository;

	@GetMapping
	public Map<String, Object> getDashboard() {

		List<ClassifiedText> list = classifiedTextRepository.findAll();

		Map<String, Integer> distribution = new HashMap<>();

		for (ClassifiedText ct : list) {
			String topic = ct.getTopic() != null ? ct.getTopic().getTitle() : "Unclassified";

			distribution.put(topic, distribution.getOrDefault(topic, 0) + 1);
		}

		Map<String, Object> response = new HashMap<>();
		response.put("totalDocuments", documentRepository.count());
		response.put("totalChunks", list.size());
		response.put("topicDistribution", distribution);

		return response;
	}

}
