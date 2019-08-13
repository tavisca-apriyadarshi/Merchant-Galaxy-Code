package com.tavisca.workshop.merchantGalaxy;

import java.lang.reflect.Array;
import java.util.HashMap;

public class ParseWordsAndItemForValue {
    public int parse(String input) {
        String[] splitOnIs = input.split(" is ");
        String[] wordsAfterIS = splitOnIs[1].split(" ");
        int value=0;
        if(splitOnIs[0].equals("how much")){
            value = valueOfWords(wordsAfterIS);
        }
        return value;
    }

    private HashMap<String, String> checkForSubtraction = new HashMap<>(){{
        put("V", "I");
        put("X", "I");
        put("L", "X");
        put("C", "X");
        put("D", "C");
        put("M", "C");

    }};
    public int valueOfWords(String[] words) {
        int number[] = new int[words.length-1];
        int total=0;
        String[] romanForWords = new String[words.length-1];
        for(int i=0; i<words.length-2; i++){
            romanForWords[i] = WordToRomanParser.mappedValue(words[i]);
        }

        for(int i=0; i<words.length-2; i++){
            if(i+1 < words.length-2) {
                //To be deleted
                //System.out.println("----------------------------" + checkForSubtraction.get(romanForWords[i + 1]));
                if(checkForSubtraction.get(romanForWords[i + 1]) != null){
                    if (checkForSubtraction.get(romanForWords[i + 1]).equals(romanForWords[i])) {
                        total += ParseRomanToInteger.convert(romanForWords[i + 1]) - ParseRomanToInteger.convert(romanForWords[i]);
                    } else {
                        total += ParseRomanToInteger.convert(romanForWords[i]);
                    }
                }
            }else{
                total += ParseRomanToInteger.convert(romanForWords[i]);
            }
        }

        return total;
    }
}
