package com.picsartacademy.leetcodeclone.service;

import com.picsartacademy.leetcodeclone.domain.Program;
import org.junit.jupiter.api.Test;

public class CompilerTest {
    @Test
    public void compileTest() {
        Runner runner = new Runner();
        Compiler compiler = new Compiler(runner);
        Program program = new Program("some text", "C++");
        compiler.compile(program, "src/main/resources/scripts/example.py");
    }
}
