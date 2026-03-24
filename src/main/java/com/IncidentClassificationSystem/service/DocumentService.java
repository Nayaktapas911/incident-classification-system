package com.IncidentClassificationSystem.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IncidentClassificationSystem.entity.ClassifiedText;
import com.IncidentClassificationSystem.entity.Document;
import com.IncidentClassificationSystem.entity.Topic;
import com.IncidentClassificationSystem.repository.ClassifiedTextRepository;
import com.IncidentClassificationSystem.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ClassifiedTextRepository classifiedTextRepository;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ClassificationService classificationService;

    public Document processDocument(String text) {

        Document document = new Document();
        document.setOriginalText(text);
        document.setCreatedAt(LocalDateTime.now());

        document = documentRepository.save(document);

        List<Topic> topics = topicService.getAllTopics();

        // Split into sentences
        List<String> sentences = Arrays.asList(text.split("\\."));

        for (String sentence : sentences) {

            if (sentence.trim().isEmpty()) continue;

            Topic topic = classificationService.classify(sentence, topics);

            double confidence = classificationService.calculateConfidence(sentence, topic);

            ClassifiedText ct = new ClassifiedText();
            ct.setDocument(document);
            ct.setTextChunk(sentence.trim());
            ct.setTopic(topic);
            ct.setConfidenceScore(confidence);

            classifiedTextRepository.save(ct);
        }

        return document;
    }
}
