package com.tavisca.workshop.merchantGalaxy;
import java.util.HashMap;

public class ParseRomanToInteger {

        private static HashMap<String, Integer> change = new HashMap<>(){{
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",250);
            put("C",100);
            put("D",500);
            put("M",1000);
        }};

        public static int convert(String roman) {
            return  (change.get(roman));
        }

}
