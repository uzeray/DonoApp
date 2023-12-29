package org.donoApp;

import org.donoApp.Processors.GrammarRules;
import org.donoApp.Processors.SpeechConfigurations;

public class Main {
    public static void main(String[] args) {

        String textPath = "C://Users/uzera/OneDrive/Desktop/someText.txt";
        String readText = GrammarRules.extractTextFromFile(textPath);
        SpeechConfigurations rules = new SpeechConfigurations(readText, "Filiz", "mp3");
    }
}