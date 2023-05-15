package com.picsartacademy.leetcodeclone.service;

import org.junit.jupiter.api.Test;

public class RunnerTest {
    @Test
    public void runTest() {
        Runner runner = new Runner(new JSONFileChecker());
        String solutionPath = "data/Solution.js";
        runner.run(solutionPath);
    }
}
