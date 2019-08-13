package com.tavisca.workshop.merchantGalaxy2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordAndRomanParser {
    private HashMap<String, String> wordAndRomanMap = new HashMap<>();
    private List<String> validWords = new ArrayList<String>();
    public String[] parse(String input) {
        String splits[] = input.split(" ");
        validWords.add(splits[0]);
        wordAndRomanMap.put(splits[0], splits[2]);
        return new String[]{splits[0], splits[2]};
    }

    public String getRomanForWord(String word){
        return wordAndRomanMap.get(word);
    }

    public boolean containsWord(String[] word){
        for(int i =0 ; i<word.length; i++)
            if(!validWords.contains(word[i])){
               // System.out.println(word[i]);
                return false;
            }
        return true;
    }
}
