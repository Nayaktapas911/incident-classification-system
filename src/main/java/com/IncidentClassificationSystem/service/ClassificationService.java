package com.IncidentClassificationSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.IncidentClassificationSystem.entity.Topic;

@Service
public class ClassificationService {

	public Topic classify(String text, List<Topic> topics) {

		int maxScore = 0;
		Topic bestTopic = null;

		for (Topic topic : topics) {
			int score = 0;

			for (String keyword : topic.getKeywords()) {
				if (text.toLowerCase().contains(keyword.toLowerCase())) {
					score++;
				}
			}

			if (score > maxScore) {
				maxScore = score;
				bestTopic = topic;
			}
		}

		return bestTopic;
	}

	public double calculateConfidence(String text, Topic topic) {
		if (topic == null)
			return 0.0;

		int match = 0;

		for (String keyword : topic.getKeywords()) {
			if (text.toLowerCase().contains(keyword.toLowerCase())) {
				match++;
			}
		}

		return (double) match / topic.getKeywords().size();
	}
}
