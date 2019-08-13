package com.tavisca.workshop.merchantGalaxy2;

import com.tavisca.workshop.merchantGalaxy.WordToRomanParser;

public class ConvertWordsToRoman {
    public String[] convert(String[] words, WordAndRomanParser wordAndRomanParser) {
        String[] splitWords = words;
        String[] romanNubersForWords = new String[splitWords.length];

        for(int i=0; i<splitWords.length; i++){
            romanNubersForWords[i] = wordAndRomanParser.getRomanForWord(splitWords[i]);
        }

        return romanNubersForWords;
    }
}
