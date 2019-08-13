package com.tavisca.workshop.merchantGalaxy2;

import java.util.HashMap;

public class ConvertRomanToNumber {
    private HashMap<String, Integer> RomanToInteger = new HashMap<>(){{
        put("I",1);
        put("V",5);
        put("X",10);
        put("L",50);
        put("C",100);
        put("D",500);
        put("M",1000);
    }};

    private HashMap<String, String> checkForSubtraction = new HashMap<>(){{
        put("V", "I");
        put("X", "I");
        put("L", "X");
        put("C", "X");
        put("D", "C");
        put("M", "C");

    }};

    //public static int convert(String roman) {
    //    return  (change.get(roman));
    //}
    public int calculate(String romans[]) {
        int total = 0;
        for(int i=0; i<romans.length; i++) {
            if (i < romans.length - 1) {
                    try{
                        if (checkForSubtraction.get(romans[i + 1]).equals(romans[i])) {
                            //System.out.println(RomanToInteger.get(romans[i+1]) - RomanToInteger.get(romans[i]) + romans[i+1] +romans[i]);
                            total += RomanToInteger.get(romans[i + 1]) - RomanToInteger.get(romans[i]);
                            i++;
                        }
                        /*else if( checkForSubtraction.get(romans[i]) == null) {
                            continue;
                        }*/
                        else {
                            total += RomanToInteger.get(romans[i]);
                        }
                    }
                    catch(Exception e){
                        total += RomanToInteger.get(romans[i]);
                    }
            }
            else{
                total += RomanToInteger.get(romans[i]);
            }
            //System.out.println(total);
        }
        return total;
    }
}
