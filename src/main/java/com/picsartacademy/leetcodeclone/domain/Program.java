package com.picsartacademy.leetcodeclone.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    private final String script;
    private String progLang;

    public Program(String script, String extension) {
        this.script = script;
        this.progLang = extension;
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

    public String save() {
        progLang = checker(progLang);
        File file = new File("data/Solution." + progLang);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(script);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file.getPath();
    }
}
