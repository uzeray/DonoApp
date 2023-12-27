package org.donoApp;

import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import org.donoApp.Assets.AccessPoints;
import org.joda.time.DateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        AccessPoints.awsProperty(); // called aws access
        AmazonPollyClient pollyClient = new AmazonPollyClient();

        String readText = "<speak>"
                + "Dono Ünal Seni Çook Sevıyor ve Çok Özledı"
                + "<prosody pitch='high'> Seni hep çok sevıcek </prosody>"
                + "<prosody rate='slow'> O sana kavusana kadar zaman gecmeyecek </prosody>"
                + "<prosody volume='loud'> Ama Dünya Dursa Bıle Senden Asla Vazgeçmeyecek </prosody>"
                + "</speak>";

        SynthesizeSpeechRequest speechRequest = new SynthesizeSpeechRequest()
                .withTextType("ssml")
                .withText(readText)
                .withVoiceId("Filiz")
                .withOutputFormat("mp3");

        SynthesizeSpeechResult speechRes = pollyClient.synthesizeSpeech(speechRequest);

        DateTime time = new DateTime(DateTime.now());
        String times = time.toString().replace("-", "_").replace(":", "_");

        try {
            byte[] audioData = speechRes.getAudioStream().readAllBytes();
            File audioFile = new File("C://Users/uzera/OneDrive/Desktop/" + times + ".mp3");
            if (audioFile.exists()) audioFile.mkdirs();

            FileOutputStream fileOS = new FileOutputStream(audioFile);
            fileOS.write(audioData);
            fileOS.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}