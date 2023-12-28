package org.donoApp.Processors;

import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import org.donoApp.Assets.AccessPoints;

import java.io.IOException;

public class ReadingRules {

    private int waitForDot = 1000; // waiting after Dot 1 sec
    private int waitForComma = 500; // waiting after comma 0.5 sec

    private AmazonPollyClient pollyClient;

    public ReadingRules(String textType, String text, String voiceId, String outputFormat) {
        AccessPoints.awsProperty(); // called aws access
        this.pollyClient = new AmazonPollyClient();
        SynthesizeSpeechRequest request = speechRequest(textType, text, voiceId, outputFormat);
        speechResult(request, pollyClient);
    }

    private SynthesizeSpeechRequest speechRequest(String textType, String text, String voiceId, String outputFormat) {
        return new SynthesizeSpeechRequest()
                .withTextType(textType)
                .withText(text)
                .withVoiceId(voiceId)
                .withOutputFormat(outputFormat);
    }

    private void speechResult(SynthesizeSpeechRequest speechRequest, AmazonPollyClient pollyClient) {
        try {
            SynthesizeSpeechResult speechResult = pollyClient.synthesizeSpeech(speechRequest);
            byte[] audioData = speechResult.getAudioStream().readAllBytes();
            SaveAudioFile save = new SaveAudioFile(audioData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
