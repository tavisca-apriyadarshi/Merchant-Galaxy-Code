package com.tavisca.workshop.merchantGalaxy;

public class ParseWordItemAndNumber {
    public static String[] parse(String input) {
        String[] splitOnIs = input.split(" is ");
        String[] wordAndItem = splitOnIs[0].split(" ");
        String[] numberAndCredit = splitOnIs[1].split(" ");
        return new String[]{(wordAndItem.length - 1)+"", wordAndItem[wordAndItem.length-1], numberAndCredit[0] };
    }
}
