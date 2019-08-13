package com.tavisca.workshop.merchantGalaxy2;

public class CalculateItemValue {

    public int calculate(String item, WordItemAndNumberParser wordItemAndNumberParser, WordAndRomanParser wordAndRomanParser) {
        int value = 0;
        ConvertWordsToRoman convertWordsToRoman = new ConvertWordsToRoman();
        String[] romans = convertWordsToRoman.convert(wordItemAndNumberParser.wordsBeforeItem, wordAndRomanParser);
        ConvertRomanToNumber convertRomanToNumber = new ConvertRomanToNumber();
        value = convertRomanToNumber.calculate(romans);
        value = wordItemAndNumberParser.number/value;
        return value;
    }
}
