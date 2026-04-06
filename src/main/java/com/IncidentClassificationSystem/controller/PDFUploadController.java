package com.IncidentClassificationSystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.IncidentClassificationSystem.entity.Document;
import com.IncidentClassificationSystem.service.DocumentService;
import com.IncidentClassificationSystem.util.PdfUtil;

@RestController
@RequestMapping("/api/pdf")
public class PDFUploadController {

	@Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) {

        String text = PdfUtil.extractText(file);

        Document doc = documentService.processDocument(text);

        Map<String, Object> res = new HashMap<>();
        res.put("documentId", doc.getId());

        return res;
    }
}

/*Resolve merge conflict*/