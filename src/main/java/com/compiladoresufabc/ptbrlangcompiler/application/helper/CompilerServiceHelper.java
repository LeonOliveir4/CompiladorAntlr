package com.compiladoresufabc.ptbrlangcompiler.application.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.RecognitionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.compiladoresufabc.ptbrlangcompiler.commons.antlr.PtBrLangGrammarLexer;
import com.compiladoresufabc.ptbrlangcompiler.commons.antlr.PtBrLangGrammarParser;
import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;
import com.compiladoresufabc.ptbrlangcompiler.commons.errors.SemanticException;
import com.compiladoresufabc.ptbrlangcompiler.commons.errors.SyntaxErrorListener;
import com.compiladoresufabc.ptbrlangcompiler.commons.generator.Program;
import com.compiladoresufabc.ptbrlangcompiler.framework.adapter.in.CompilerAdapter;

@Component
public class CompilerServiceHelper {
	
	private static final Logger log = LoggerFactory.getLogger(CompilerAdapter.class);

	@Value("${compiler.output-directory}")
	private String outputDirectory;
	
	private List<String> syntaxErrors;

	public ResponseEntity<?> processJavaFile(MultipartFile file) {
		log.info("Linguagem a ser gerada: {}",  LanguageType.JAVA);
		return processFile(file, LanguageType.JAVA);
	}

	public ResponseEntity<?> processCFile(MultipartFile file) {
		log.info("Linguagem a ser gerada: {}",  LanguageType.C);
		return processFile(file, LanguageType.C);
	}

	public ResponseEntity<?> processPythonFile(MultipartFile file) {
		log.info("Linguagem a ser gerada: {}",  LanguageType.PYTHON);
		return processFile(file, LanguageType.PYTHON);
	}

	private ResponseEntity<?> processFile(MultipartFile file, LanguageType language) {
		File outputFile = null;

		try {
			String extension = language.getLanguageExtension();
			outputFile = createOutputFile(file.getOriginalFilename(), extension);
			processFileWithANTLR(file, outputFile, language);
			return sendFileAsResponse(outputFile);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao processar o arquivo: " + e.getMessage());
		}
	}

	private File createOutputFile(String fileName, String outputExtension) throws IOException {
		String originalNameWithoutExt = fileName.replaceFirst("[.][^.]+$", "");
		File outputFile = new File(outputDirectory, originalNameWithoutExt + outputExtension);
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		return outputFile;
	}

	// Retornando apenas o que veio em caso de sucesso, se não exception específica
	private void processFileWithANTLR(MultipartFile originalFile, File outputFile, LanguageType language) throws IOException {
		try {
			syntaxErrors = new ArrayList<>();
			PtBrLangGrammarLexer lexer = new PtBrLangGrammarLexer(
					CharStreams.fromFileName(outputDirectory + originalFile.getOriginalFilename()));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			PtBrLangGrammarParser parser = new PtBrLangGrammarParser(tokenStream);
			
			parser.setErrorHandler(new DefaultErrorStrategy());
			
			parser.removeErrorListeners();  // Remove listeners padrão
	        parser.addErrorListener(new SyntaxErrorListener(syntaxErrors));
	        String separator = "=".repeat(50);
	        String end = "=".repeat(130);

	        log.info("{} LOGS E WARNINGS PARSER/LEXER {}", separator, separator);
			parser.programa();
			log.info("{}", end);
			
			if (!syntaxErrors.isEmpty()) {
	            throw new IOException("Erros de sintaxe encontrados: \n" + String.join("\n", syntaxErrors));
	        }
			
			Program program = parser.getProgram();

			String generatedCode = program.generateCode(language);
			
			log.info("Código gerado: {}",  generatedCode);
			
			FileWriter fW = new FileWriter(outputFile);
			PrintWriter pW = new PrintWriter(fW);
			pW.println(generatedCode);
			pW.close();
		} catch (RecognitionException e) {
			throw new IOException("Erro de análise léxica ou sintática: " + e.getMessage());
		} catch (IOException e) {
			throw new IOException("Erro ao processar o arquivo: " + e.getMessage());
		} catch (SemanticException e) {
			throw new IOException("Erro ao processar o arquivo: " + e.getMessage());
		}
	}

	private ResponseEntity<?> sendFileAsResponse(File outputFile) throws IOException {
		FileSystemResource resource = new FileSystemResource(outputFile);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + outputFile.getName());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentLength(resource.contentLength());

		return ResponseEntity.ok().headers(headers).body(resource);
	}
}
