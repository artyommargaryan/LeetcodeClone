package com.picsartacademy.leetcodeclone.service;

import com.picsartacademy.leetcodeclone.domain.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class Compiler {
    private Runner runner;

    @Autowired
    public Compiler(Runner runner) {
        this.runner = runner;
    }

    private String checker(String language) {
        language = language.toLowerCase();
        switch (language) {
            case "java" -> language = "java";
            case "c++" -> language = "cpp";
            case "javascript" -> language = "js";
            case "python" -> language = "py";
        }
        return language;
    }

    public String save(Program program) {
        String extension = checker(program.lang());
        File file = new File("data/Solution." + extension);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(program.script());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file.getPath();
    }

    public void compile(Program program) {
        String solutionPath = save(program);
        runner.run(solutionPath);
    }
}
