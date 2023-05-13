package com.picsartacademy.leetcodeclone.domain;

import org.junit.jupiter.api.Test;

public class ProgramTest {
    @Test
    public void saveTest() {
        Program program = new Program("console.log(\"Hello, world!\");", "javascript");
        System.out.println(program.save());
    }
}
