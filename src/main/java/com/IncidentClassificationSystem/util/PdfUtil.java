package com.IncidentClassificationSystem.util;

import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

public class PdfUtil {

	public static String extractText(MultipartFile file) {
		try {

			byte[] fileBytes = file.getBytes(); // convert to byte[]

			PDDocument document = Loader.loadPDF(fileBytes);

			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(document);

			document.close();

			return text;

		} catch (IOException e) {
			throw new RuntimeException("Error reading PDF file");
		}
	}
}
