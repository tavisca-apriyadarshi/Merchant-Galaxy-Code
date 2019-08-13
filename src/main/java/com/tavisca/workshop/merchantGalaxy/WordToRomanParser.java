package com.tavisca.workshop.merchantGalaxy;

import java.util.HashMap;

public class WordToRomanParser {
    public void parse(String input) {
        String splits[] = input.split(" ");
        wordAndValueMap(splits);
        //return new String[]{splits[0], splits[2]};
    }

    private static HashMap<String, String> valueMap = new HashMap<>();

    private void wordAndValueMap(String[] strArr) {
        valueMap.put(strArr[0], strArr[2]);
    }

    public static String mappedValue(String word){
        return valueMap.get(word);
    }
}
