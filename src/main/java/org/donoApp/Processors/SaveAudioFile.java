package org.donoApp.Processors;

import org.joda.time.DateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveAudioFile {

    private DateTime currentTime = new DateTime(DateTime.now());
    private String formattedStemp = currentTime.toString().replace("-", "_").replace(":", "_");
    private final String rootDir = "C://Users/uzera/OneDrive/Desktop/";
    private final String fileFormat = ".mp3";

    public SaveAudioFile(byte[] audioData) {
        saveProcess(audioData, this.rootDir, this.formattedStemp, this.fileFormat);
    }

    private void saveProcess(byte[] audioData, String rootDir, String timeStemp, String fileFormat) {
        try {
            File outputDir = new File(rootDir + timeStemp + fileFormat);
            if (outputDir.exists()) outputDir.mkdirs();
            FileOutputStream fileOS = new FileOutputStream(outputDir);
            fileOS.write(audioData);
            fileOS.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
