package com.securityia.api_analyze_docs.infrastructure.pdf;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PdfTextExtractor {
	
	public String extractText(MultipartFile file) {
		try(InputStream in = file.getInputStream(); PDDocument document = PDDocument.load(in)) {
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(document);
			log.info("Extracted text from PDF");
			return text;
		} catch (IOException e) {
			log.error("Error extracting text from PDF file: {}", file.getOriginalFilename(), e);
			throw new RuntimeException("Failed to extract text from PDF", e);
		}
	}

}
