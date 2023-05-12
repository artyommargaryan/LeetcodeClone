package models;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Adapter {
    private static String checker(String language) {
        language = language.toLowerCase();
        switch (language) {
            case "java" -> language = "java";
            case "c++" -> language = "cpp";
            case "javascript" -> language = "js";
            case "python" -> language = "py";
        }
        return language;
    }

    public static String convertTo(String value, String key) {
        key = checker(key);
        File file = new File("/src/main/resources/Solution." + key);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file.getAbsolutePath();
    }
}
