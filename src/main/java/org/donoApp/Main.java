package org.donoApp;

import org.donoApp.Processors.ReadingRules;

public class Main {
    public static void main(String[] args) {

        String readText = "<speak>"
                + "Dono Ünal Seni Çook Sevıyor ve Çok Özledı"
                + "<prosody pitch='high'> Seni hep çok sevıcek </prosody>"
                + "<prosody rate='slow'> O sana kavusana kadar zaman gecmeyecek </prosody>"
                + "<prosody volume='loud'> Ama Dünya Dursa Bıle Senden Asla Vazgeçmeyecek </prosody>"
                + "</speak>";

        ReadingRules rules = new ReadingRules("ssml", readText, "Filiz", "mp3");
    }
}