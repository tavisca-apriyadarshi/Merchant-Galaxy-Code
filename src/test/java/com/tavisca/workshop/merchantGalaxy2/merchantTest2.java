package com.tavisca.workshop.merchantGalaxy2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class merchantTest2 {
    @Test
    void canIdentifyWordAndRoman(){
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        assertArrayEquals(new String[]{"glob","I"}, wordAndRomanParser.parse("glob is I"));
    }

    @Test
    void canIdentifyWordsItemsAndNumber(){
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        ItemList itemList = new ItemList();
        assertArrayEquals(new String[]{"2", "Silver", "34"}, wordItemAndNumberParser.parse("glob glob Silver is 34 Credits", itemList));
    }

    @Test
    void canConvertRomanToNumber(){
        ConvertRomanToNumber convertRomanToNumber = new ConvertRomanToNumber();
        assertEquals(51, convertRomanToNumber.calculate(new String[]{"L","I"}));
    }

    @Test
    void canConvertRomanToNumber_2(){
        ConvertRomanToNumber convertRomanToNumber = new ConvertRomanToNumber();
        assertEquals(1944, convertRomanToNumber.calculate(new String[]{"M","C","M","X","L","I","V"}));
    }

    @Test
    void canConvertRomanToNumber_3(){
        ConvertRomanToNumber convertRomanToNumber = new ConvertRomanToNumber();
        assertEquals(1903, convertRomanToNumber.calculate(new String[]{"M","C","M","I","I","I"}));
    }

    @Test
    void canConvertWordsToRoman(){
        ConvertWordsToRoman convertWordsToRoman = new ConvertWordsToRoman();
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        assertArrayEquals(new String[]{"I", "V"},convertWordsToRoman.convert(new String[]{"glob","prok"}, wordAndRomanParser));
    }

    @Test
    void canCalculateItemValue(){
        CalculateItemValue calculateItemValue = new CalculateItemValue();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        ItemList itemList = new ItemList();
        wordItemAndNumberParser.parse("glob glob Silver is 34 Credits", itemList);
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        assertEquals(17, calculateItemValue.calculate("Silver", wordItemAndNumberParser, wordAndRomanParser));
    }

    @Test
    void canCalculateItemValue1(){
        CalculateItemValue calculateItemValue = new CalculateItemValue();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        ItemList itemList = new ItemList();
        wordItemAndNumberParser.parse("glob prok Gold is 57800 Credits", itemList);
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        assertEquals(14450, calculateItemValue.calculate("Gold", wordItemAndNumberParser, wordAndRomanParser));
    }

    @Test
    void canCalculateItemValue2(){
        CalculateItemValue calculateItemValue = new CalculateItemValue();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        ItemList itemList = new ItemList();
        wordItemAndNumberParser.parse("pish pish Iron is 3910 Credits", itemList);
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        assertEquals(195, calculateItemValue.calculate("Iron", wordItemAndNumberParser, wordAndRomanParser));
    }

    //******************************************************************************************************************

    @Test
    void testForDifferentKindsOfStatement(){
        AnswerQueries answerQueries = new AnswerQueries();
        /*

        glob glob Silver is 34 Credits
        glob prok Gold is 57800 Credits
        pish pish Iron is 3910 Credits*/
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        ItemList itemList = new ItemList();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        wordItemAndNumberParser.parse("glob glob Silver is 34 Credits",itemList);
        wordItemAndNumberParser.parse("glob prok Gold is 57800 Credits",itemList);
        wordItemAndNumberParser.parse("pish pish Iron is 3910 Credits",itemList);

        assertEquals("value query", answerQueries.statementType("how much is pish tegj glob glob ?",wordAndRomanParser, wordItemAndNumberParser,itemList));
        assertEquals("item value query", answerQueries.statementType("how many Credits is glob prok Silver ?",wordAndRomanParser,wordItemAndNumberParser,itemList));
    }

    @Test
    void testForDifferentKindsOfStatement1(){
        AnswerQueries answerQueries = new AnswerQueries();
        /*

        glob glob Silver is 34 Credits
        glob prok Gold is 57800 Credits
        pish pish Iron is 3910 Credits*/
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();
        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        ItemList itemList = new ItemList();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        wordItemAndNumberParser.parse("glob glob Silver is 34 Credits",itemList);
        wordItemAndNumberParser.parse("glob prok Gold is 57800 Credits",itemList);
        wordItemAndNumberParser.parse("pish pish Iron is 3910 Credits",itemList);

        assertEquals("value query", answerQueries.statementType("how much is pish tegj glob glob ?",wordAndRomanParser, wordItemAndNumberParser,itemList));
        assertEquals("item value query", answerQueries.statementType("how many Credits is glob prok Silver ?",wordAndRomanParser,wordItemAndNumberParser,itemList));
        assertEquals("don't know what u r talkin abt...", answerQueries.statementType("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?",wordAndRomanParser,wordItemAndNumberParser,itemList));
    }

    @Test
    void testForHowMuchIsWords(){
        AnswerQueries answerQueries = new AnswerQueries();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();

        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        ItemList itemList = new ItemList();
        wordItemAndNumberParser.parse("glob glob Silver is 34 Credits",itemList);
        wordItemAndNumberParser.parse("glob prok Gold is 57800 Credits",itemList);
        wordItemAndNumberParser.parse("pish pish Iron is 3910 Credits",itemList);

        assertEquals(42, answerQueries.solve("how much is pish tegj glob glob ?", wordItemAndNumberParser,
                                                            wordAndRomanParser, itemList));//, calculateItemValue));
    }

    /*glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?*/

    @Test
    void testForHowManyCredits(){
        AnswerQueries answerQueries = new AnswerQueries();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        WordItemAndNumberParser wordItemAndNumberParser1 = new WordItemAndNumberParser();
        WordItemAndNumberParser wordItemAndNumberParser2 = new WordItemAndNumberParser();
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();

        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        ItemList itemList = new ItemList();
        wordItemAndNumberParser.parse("glob glob Silver is 34 Credits",itemList);
        wordItemAndNumberParser1.parse("glob prok Gold is 57800 Credits",itemList);
        wordItemAndNumberParser2.parse("pish pish Iron is 3910 Credits",itemList);

        assertEquals(68, answerQueries.solve("how many Credits is glob prok Silver ?", wordItemAndNumberParser,
                wordAndRomanParser, itemList));//, calculateItemValue));
    }

    @Test
    void testForHowManyCredits1(){
        AnswerQueries answerQueries = new AnswerQueries();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        WordItemAndNumberParser wordItemAndNumberParser1 = new WordItemAndNumberParser();
        WordItemAndNumberParser wordItemAndNumberParser2 = new WordItemAndNumberParser();
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();

        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        ItemList itemList = new ItemList();
        wordItemAndNumberParser.parse("glob glob Silver is 34 Credits",itemList);
        wordItemAndNumberParser1.parse("glob prok Gold is 57800 Credits",itemList);
        wordItemAndNumberParser2.parse("pish pish Iron is 3910 Credits",itemList);

        assertEquals(68, answerQueries.solve("how many Credits is glob prok Gold ?", wordItemAndNumberParser,
                wordAndRomanParser, itemList));//, calculateItemValue));
    }

    @Test
    void testForHowManyCredits2(){
        AnswerQueries answerQueries = new AnswerQueries();
        WordItemAndNumberParser wordItemAndNumberParser = new WordItemAndNumberParser();
        WordItemAndNumberParser wordItemAndNumberParser1 = new WordItemAndNumberParser();
        WordItemAndNumberParser wordItemAndNumberParser2 = new WordItemAndNumberParser();
        WordAndRomanParser wordAndRomanParser = new WordAndRomanParser();

        wordAndRomanParser.parse("glob is I");
        wordAndRomanParser.parse("prok is V");
        wordAndRomanParser.parse("pish is X");
        wordAndRomanParser.parse("tegj is L");
        ItemList itemList = new ItemList();
        wordItemAndNumberParser.parse("glob glob Silver is 34 Credits",itemList);
        wordItemAndNumberParser1.parse("glob prok Gold is 57800 Credits",itemList);
        wordItemAndNumberParser2.parse("pish pish Iron is 3910 Credits",itemList);

        assertEquals(68, answerQueries.solve("how many Credits is glob prok Iron ?", wordItemAndNumberParser,
                wordAndRomanParser, itemList));//, calculateItemValue));
    }
}