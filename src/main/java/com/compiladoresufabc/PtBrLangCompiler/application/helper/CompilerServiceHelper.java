package com.compiladoresufabc.PtBrLangCompiler.application.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class CompilerServiceHelper {

    @Value("${compiler.output-directory}")
    private String outputDirectory;

    public ResponseEntity<?> processJavaFile(MultipartFile file) {
        return processFile(file, ".java");
    }

    public ResponseEntity<?> processCFile(MultipartFile file) {
        return processFile(file, ".c");
    }

    public ResponseEntity<?> processPythonFile(MultipartFile file) {
        return processFile(file, ".py");
    }

    private ResponseEntity<?> processFile(MultipartFile file, String outputExtension) {
        File originalFile = null;
        File outputFile = null;

        try {
            originalFile = saveFileToOutputDirectory(file);
            outputFile = createOutputFile(originalFile, outputExtension);
            writeContentToOutputFile(originalFile, outputFile);
            return sendFileAsResponse(outputFile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

    private File saveFileToOutputDirectory(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        File outputDir = new File(outputDirectory);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, originalFilename);
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(file.getBytes());
        }
        return outputFile;
    }

    private File createOutputFile(File originalFile, String outputExtension) throws IOException {
        String originalNameWithoutExt = originalFile.getName().replaceFirst("[.][^.]+$", "");
        File outputFile = new File(originalFile.getParent(), originalNameWithoutExt + outputExtension);
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        return outputFile;
    }

    private void writeContentToOutputFile(File originalFile, File outputFile) throws IOException {
        String content = new String(Files.readAllBytes(originalFile.toPath()));

        String processedContent = content;

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(processedContent.getBytes());
        }
    }

    private ResponseEntity<?> sendFileAsResponse(File outputFile) throws IOException {
        FileSystemResource resource = new FileSystemResource(outputFile);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + outputFile.getName());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(resource.contentLength());

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
