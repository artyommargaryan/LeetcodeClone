package com.picsartacademy.leetcodeclone.service;

import org.junit.jupiter.api.Test;

public class RunnerTest {
    @Test
    public void runTest() {
        Runner runner = new Runner();
        String solutionPath = "data/Solution.js";
        runner.run("src/main/resources/scripts/example.py", solutionPath);
    }
}
