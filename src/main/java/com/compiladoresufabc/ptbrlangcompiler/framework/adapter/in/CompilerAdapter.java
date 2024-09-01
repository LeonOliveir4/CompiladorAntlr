package com.compiladoresufabc.ptbrlangcompiler.framework.adapter.in;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compiladoresufabc.ptbrlangcompiler.application.port.in.CompilerUseCase;

@RestController
@RequestMapping("/compiler")
public class CompilerAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(CompilerAdapter.class);

	@Autowired
    private CompilerUseCase compileUseCase;
    
    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file,
                                              @RequestParam("language") String language) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".ptbrlang")) {
        	log.error("arquivo invalido: {}", file);
            return ResponseEntity.badRequest().body("Arquivo inválido. Por favor, envie um arquivo suportado.");
        }
        log.info("Iniciando conversão de arquivo {} para o formato {}", file.getOriginalFilename(),
        		language.toLowerCase());

        try {
            LanguageType languageType = LanguageType.fromString(language);
            return switch (languageType) {
                case JAVA -> compileUseCase.compileJava(file);
                case C -> compileUseCase.compileC(file);
                case PYTHON -> compileUseCase.compilePython(file);
                default -> ResponseEntity.badRequest().body("Linguagem não suportada: " + language);
            };
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
