package com.mpj.miniproj.sentiment;

import java.util.Set;

public class SentimentAnalyzer {

    static Set<String> positive = Set.of(
            "good", "great", "amazing", "nice", "love"
    );

    static Set<String> negative = Set.of(
            "bad", "terrible", "hate", "awful"
    );

    public static String analyze(String text) {

        int score = 0;

        text = text.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (positive.contains(word)) score++;
            if (negative.contains(word)) score--;
        }

        if (score > 0) return "Positive";
        if (score < 0) return "Negative";
        return "Neutral";
    }
}