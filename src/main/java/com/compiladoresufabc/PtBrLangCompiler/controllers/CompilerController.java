package com.compiladoresufabc.PtBrLangCompiler.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compiler")
public class CompilerController {

    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World!");
    }
}
