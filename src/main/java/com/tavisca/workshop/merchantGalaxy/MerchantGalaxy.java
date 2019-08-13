package com.tavisca.workshop.merchantGalaxy;

import java.util.HashMap;

public class MerchantGalaxy {
    private static HashMap<String, String> creditMap = new HashMap<>();

    public static String creditConverter(String input) {

        return null;
    }
    public void addCredit(String input) {
        String strArr[] = input.split(" ");
        creditMap.put(strArr[0], strArr[2]);
    }
}
