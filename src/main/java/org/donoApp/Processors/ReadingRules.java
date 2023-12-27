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

    public ReadingRules() {
        AccessPoints.awsProperty(); // called aws access
        this.pollyClient = new AmazonPollyClient();
    }

    private SynthesizeSpeechRequest speechRequest(String textType, String text, String voiceId, String outputFormat) {
        return new SynthesizeSpeechRequest()
                .withTextType(textType)
                .withText(text)
                .withVoiceId(voiceId)
                .withOutputFormat(outputFormat);
    }

    private byte[] speechResult (SynthesizeSpeechRequest speechRequest, AmazonPollyClient pollyClient) throws IOException {
        SynthesizeSpeechResult speechResult = pollyClient.synthesizeSpeech(speechRequest);
        return speechResult.getAudioStream().readAllBytes();
    }

}
