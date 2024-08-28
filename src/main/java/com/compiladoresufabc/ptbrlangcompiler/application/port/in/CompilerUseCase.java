package com.compiladoresufabc.ptbrlangcompiler.application.port.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CompilerUseCase {
    ResponseEntity<?> compileJava(MultipartFile file);
    ResponseEntity<?> compileC(MultipartFile file);
    ResponseEntity<?> compilePython(MultipartFile file);
}
