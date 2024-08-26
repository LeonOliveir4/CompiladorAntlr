package com.compiladoresufabc.PtBrLangCompiler.application.service;

import com.compiladoresufabc.PtBrLangCompiler.application.port.in.CompilerUseCase;
import com.compiladoresufabc.PtBrLangCompiler.application.helper.CompilerServiceHelper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompilerService implements CompilerUseCase {
	
	private final CompilerServiceHelper serviceHelper;
	
	public CompilerService(CompilerServiceHelper compilerHelper) {
        this.serviceHelper = compilerHelper;
    }
	
    @Override
    public ResponseEntity<?> compileJava(MultipartFile file) {
        return serviceHelper.processJavaFile(file);
    }

    @Override
    public ResponseEntity<?> compileC(MultipartFile file) {
        return serviceHelper.processCFile(file);
    }

    @Override
    public ResponseEntity<?> compilePython(MultipartFile file) {
        return serviceHelper.processPythonFile(file);
    }
}
