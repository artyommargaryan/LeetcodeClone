package com.picsartacademy.leetcodeclone.controller;

import com.picsartacademy.leetcodeclone.domain.Program;
import com.picsartacademy.leetcodeclone.service.Compiler;
import com.picsartacademy.leetcodeclone.service.JSONFileChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final Compiler compiler;
    private final JSONFileChecker jsonFileChecker;
    private final String pythonPath = "src/main/resources/scripts/example.py";
    private final String jsonPath = "data/output.json";

    @Autowired
    public ApiController(Compiler compiler, JSONFileChecker jsonFileChecker) {
        this.compiler = compiler;
        this.jsonFileChecker = jsonFileChecker;
    }

    @PostMapping("/test")
    public String test(@RequestBody Program program) {
        compiler.compile(program);//changeso that it returns json file path
        return "date/output.json";
    }

    @PostMapping("/submit")
    public String submit(@RequestBody Program program) {
        compiler.compile(program);//changeso that it returns json file path
        return null;
    }

}
