package com.mpj.miniproj.audio;

import javax.sound.sampled.*;
import java.io.File;

public class AudioRecorder {

    public static File recordAudio(int seconds) throws Exception {

        AudioFormat format = new AudioFormat(16000,16,1,true,true);

        TargetDataLine line = AudioSystem.getTargetDataLine(format);
        line.open(format);
        line.start();

        System.out.println("Recording...");

        AudioInputStream ais = new AudioInputStream(line);

        File file = new File("speech.wav");

        Thread stopper = new Thread(() -> {
            try {
                Thread.sleep(seconds * 1000);
                line.stop();
                line.close();
                System.out.println("Recording finished");
            } catch(Exception e){
                e.printStackTrace();
            }
        });

        stopper.start();

        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, file);

        return file;
    }
}