package com.IncidentClassificationSystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IncidentClassificationSystem.entity.ClassifiedText;
import com.IncidentClassificationSystem.entity.Document;
import com.IncidentClassificationSystem.repository.ClassifiedTextRepository;
import com.IncidentClassificationSystem.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@Autowired
	private ClassifiedTextRepository classifiedTextRepository;

	@PostMapping
	public Map<String, Object> uploadDocument(@RequestBody Map<String, String> request) {

		String text = request.get("text");

		Document doc = documentService.processDocument(text);

		Map<String, Object> response = new HashMap<>();
		response.put("documentId", doc.getId());

		return response;
	}

	@GetMapping("/{id}/results")
	public Map<String, Object> getResults(@PathVariable("id") Long id) {

		List<ClassifiedText> list = classifiedTextRepository.findAll();

		List<Map<String, Object>> results = new ArrayList<>();

		for (ClassifiedText ct : list) {

			if (!ct.getDocument().getId().equals(id))
				continue;

			Map<String, Object> map = new HashMap<>();
			map.put("text", ct.getTextChunk());
			map.put("assignedTopic", ct.getTopic() != null ? ct.getTopic().getTitle() : "UNCLASSIFIED");
			map.put("confidence", ct.getConfidenceScore());

			results.add(map);
		}

		Map<String, Object> response = new HashMap<>();
		response.put("documentId", id);
		response.put("results", results);

		return response;
	}
}
