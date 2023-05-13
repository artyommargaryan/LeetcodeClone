package com.picsartacademy.leetcodeclone.service;

import org.json.JSONObject;

import java.io.*;

public class JsonChecker {
    public String jsonCheckerForError(String path) {
        String str = "error";
        try {
            File jsonFile = new File(path);
            FileReader reader = new FileReader(jsonFile);
            StringBuilder sb = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                sb.append((char) character);
            }
            String jsonStr = sb.toString();
            JSONObject json = new JSONObject(jsonStr);
            reader.close();
            if (!json.has("error")) {
                JSONObject errorJson = json;
                errorJson.put("---- - status------", "---- >"+str);
                File errorFile = new File(path);
                FileWriter writer = new FileWriter(errorFile);
                writer.write(errorJson.toString());
                writer.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}
