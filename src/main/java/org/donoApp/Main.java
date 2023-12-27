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



        String readText = "<speak>"
                + "Dono Ünal Seni Çook Sevıyor ve Çok Özledı"
                + "<prosody pitch='high'> Seni hep çok sevıcek </prosody>"
                + "<prosody rate='slow'> O sana kavusana kadar zaman gecmeyecek </prosody>"
                + "<prosody volume='loud'> Ama Dünya Dursa Bıle Senden Asla Vazgeçmeyecek </prosody>"
                + "</speak>";








    }
}