package com.picsartacademy.leetcodeclone.controller;

import com.picsartacademy.leetcodeclone.domain.Program;
import com.picsartacademy.leetcodeclone.service.Compiler;
import com.picsartacademy.leetcodeclone.service.JSONFileChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String test(@ModelAttribute("script") String script, @ModelAttribute("lang") String lang) {
        Program program = new Program(script, lang);
        compiler.compile(program, "src/main/resources/scripts/example.py");//changeso that it returns json file path
        if (jsonFileChecker.checkJsonFile(jsonPath)){
            return jsonPath;
        } else {
            return "data/erroroutput.json";
        }
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute("script") String script, @ModelAttribute("lang") String lang) {
        Program program = new Program(script, lang);
        compiler.compile(program, pythonPath);

        String jsonPath = ""; //Tyomi func
        return jsonPath;
    }

}
