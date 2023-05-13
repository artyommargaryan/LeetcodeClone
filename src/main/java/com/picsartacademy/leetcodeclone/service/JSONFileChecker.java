package com.picsartacademy.leetcodeclone.service;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class JSONFileChecker {
    public boolean checkJsonFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject json = new JSONObject(tokener);
            reader.close();

            return !json.has("error");
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
            return false;
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
            return false;
        } catch (JSONException ex) {
            System.out.println("Invalid JSON format: " + ex.getMessage());
            return false;
        }
    }
}