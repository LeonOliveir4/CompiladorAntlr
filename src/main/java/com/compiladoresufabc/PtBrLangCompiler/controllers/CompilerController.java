package com.compiladoresufabc.PtBrLangCompiler.controllers;


import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/compiler")
public class CompilerController {

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".ptbrlang")) {
            return ResponseEntity.badRequest().body("Tipo de arquivo inválido. Por favor, envie um arquivo .ptbrlang");
        }

        File tempFile = null;
        File javaFile = null;

        try {
            tempFile = File.createTempFile("temp", ".ptbrlang");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(file.getBytes());
            }

            javaFile = new File(tempFile.getAbsolutePath().replace(".ptbrlang", ".java"));
            if (!tempFile.renameTo(javaFile)) {
                return ResponseEntity.badRequest().body("Erro ao renomear arquivo temporário.");
            }

            FileSystemResource resource = new FileSystemResource(javaFile);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + javaFile.getName());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentLength(resource.contentLength());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Erro ao processar arquivo.");
        } finally {
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }
}
