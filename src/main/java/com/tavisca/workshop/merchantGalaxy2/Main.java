package com.tavisca.workshop.merchantGalaxy2;

public class Main {
    public static void main(String[] args) {
        ConvertRomanToNumber convertRomanToNumber = new ConvertRomanToNumber();
        int result = convertRomanToNumber.calculate(new String[]{"M","C","M","X","L","I","V"});
        System.out.println(result);

        ConvertWordsToRoman convertWordsToRoman = new ConvertWordsToRoman();
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        String[] romans = convertWordsToRoman.convert(new String[]{"glob","prok"}, wordAndRomanParser);
        for(int i=0; i<2; i++){
            System.out.println(romans[i]);
        }

    }
}
