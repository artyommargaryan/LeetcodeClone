package com.picsartacademy.leetcodeclone.service;

import com.picsartacademy.leetcodeclone.domain.Program;
import org.junit.jupiter.api.Test;

public class CompilerTest {
    @Test
    public void compileTest() {
        Runner runner = new Runner(new JSONFileChecker());
        Compiler compiler = new Compiler(runner);
        Program program = new Program("some text", "C++");
        compiler.compile(program);
    }

    @Test
    public void saveTest() {
        Runner runner = new Runner(new JSONFileChecker());
        Compiler compiler = new Compiler(runner);
        Program program = new Program("console.log(\"Hello, world!\");", "javascript");
        System.out.println(compiler.save(program));
    }
}
