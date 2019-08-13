package com.tavisca.workshop.merchantGalaxy2;

public class AnswerQueries {
    int valueOfWords = 0;
    int valueWithItem = 0;

    public String statementType(String query, WordAndRomanParser wordAndRomanParser, WordItemAndNumberParser wordItemAndNumberParser,  ItemList itemList) {
        if(query.startsWith("how much is")){
            String[] splitQuery = query.split(" is ");
            String[] removeQMark = splitQuery[1].split(" \\?");
            String[] splitForWords = removeQMark[0].split(" ");
            ConvertRomanToNumber convertRomanToNumber = new ConvertRomanToNumber();
            ConvertWordsToRoman convertWordsToRoman = new ConvertWordsToRoman();

            valueOfWords = convertRomanToNumber.calculate(convertWordsToRoman.convert(splitForWords, wordAndRomanParser));

            if(wordAndRomanParser.containsWord(splitForWords)){
                return "value query";
            }
        }
        if(query.startsWith("how many Credits is")){
            String[] splitQuery = query.split(" is ");
            String[] removeQMark = splitQuery[1].split(" \\?");
            String[] splitForWords = removeQMark[0].split(" ");
            String[] words = new String[splitForWords.length-1];
            ConvertRomanToNumber convertRomanToNumber = new ConvertRomanToNumber();
            ConvertWordsToRoman convertWordsToRoman = new ConvertWordsToRoman();
            CalculateItemValue calculateItemValue = new CalculateItemValue();

            for(int i =0; i<splitForWords.length-1; i++){
                words[i] = splitForWords[i];
            }

            String item = splitForWords[splitForWords.length-1];

            valueOfWords = convertRomanToNumber.calculate(convertWordsToRoman.convert(words, wordAndRomanParser));
            int itemValue = calculateItemValue.calculate(item,wordItemAndNumberParser, wordAndRomanParser);
            valueWithItem = valueOfWords*itemValue;
            if(wordAndRomanParser.containsWord(words) && itemList.items.contains(item)){
                return "item value query";
            }
        }
        return "don't know what u r talkin abt...";
    }

    public int solve(String query, WordItemAndNumberParser wordItemAndNumberParser, WordAndRomanParser wordAndRomanParser, ItemList itemList) {
        if(statementType(query, wordAndRomanParser, wordItemAndNumberParser,itemList).equals("value query")){
            return valueOfWords;
        }
        else if(statementType(query, wordAndRomanParser, wordItemAndNumberParser,itemList).equals("item value query")){
            return valueWithItem;
        }
        return 0;
    }
}
