package com.picsartacademy.leetcodeclone.service;

import com.picsartacademy.leetcodeclone.domain.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Compiler {
    private Runner runner;

    @Autowired
    public Compiler(Runner runner) {
        this.runner = runner;
    }

    public void compile(Program program, String path) {
        String solutionPath =  program.save();
        runner.run(path, solutionPath);
    }
}
