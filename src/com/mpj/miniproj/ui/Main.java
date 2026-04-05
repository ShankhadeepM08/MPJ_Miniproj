package com.mpj.miniproj.ui;

import com.mpj.miniproj.audio.AudioRecorder;
import com.mpj.miniproj.speech.SpeechToTextService;
import com.mpj.miniproj.speech.FumbleDetector;
import com.mpj.miniproj.sentiment.SentimentAnalyzer;
import com.mpj.miniproj.database.SessionDAO;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Press ENTER to start speaking...");
            scanner.nextLine();

            File audioFile = AudioRecorder.recordAudio(5);

            System.out.println("Converting speech to text...");

            String text = SpeechToTextService.convertSpeechToText(audioFile.getPath());

            System.out.println("Recognized Speech: " + text);

            int fumbles = FumbleDetector.countFumbles(text);

            String sentiment = SentimentAnalyzer.analyze(text);

            SessionDAO.saveSession(text, fumbles, sentiment);

            System.out.println("Fumbles Detected: " + fumbles);
            System.out.println("Sentiment: " + sentiment);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
