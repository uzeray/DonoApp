package org.donoApp.Processors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GrammarRules {

    private final int waitDot = 1000;
    private final int waitComma = 500;

    public GrammarRules() {
        // constructor
    }

    public static String extractTextFromFile(String filePath) {
        StringBuilder readFile = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                readFile.append(line).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return readFile.toString();
    }
}
