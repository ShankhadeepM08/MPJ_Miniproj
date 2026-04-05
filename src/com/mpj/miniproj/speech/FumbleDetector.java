package com.mpj.miniproj.speech;

import java.util.Set;

public class FumbleDetector {

    static Set<String> fillers = Set.of(
            "uh", "um", "like", "hmm", "ah"
    );

    public static int countFumbles(String text) {

        int count = 0;

        String[] words = text.toLowerCase().split(" ");

        for (String word : words) {
            if (fillers.contains(word)) {
                count++;
            }
        }

        return count;
    }
}