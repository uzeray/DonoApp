package org.donoApp.Processors;

import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import org.donoApp.Assets.AccessPoints;

import java.io.IOException;

public class SpeechConfigurations {

    private AmazonPollyClient pollyClient;

    public SpeechConfigurations(String text, String voiceId, String outputFormat) {
        AccessPoints.awsProperty(); // called aws access
        this.pollyClient = new AmazonPollyClient();
        SynthesizeSpeechRequest request = speechRequest(text, voiceId, outputFormat);
        speechResult(request, pollyClient);
    }

    private SynthesizeSpeechRequest speechRequest(String text, String voiceId, String outputFormat) {
        return new SynthesizeSpeechRequest()
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
