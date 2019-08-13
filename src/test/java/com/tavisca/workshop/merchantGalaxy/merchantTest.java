package com.tavisca.workshop.merchantGalaxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class merchantTest {
    /*@Test
    public void canParseWordToRomanNumeralStatement(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        assertArrayEquals(new String[]{"glob", "I"},
                wordToRomanParser.parse("glob is I"));
    }*/

    @Test
    void canParseWordItemAndNumber(){
        ParseWordItemAndNumber parseWordItemAndNumber = new ParseWordItemAndNumber();
        assertArrayEquals(new String[]{"2", "Silver", "34"},
                parseWordItemAndNumber.parse("glob glob Silver is 34 Credits"));
    }

    @Test
    void canParseWordsAndItemsForValue(){
        ParseWordsAndItemForValue parseWordsAndItemForValue = new ParseWordsAndItemForValue();

        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        wordToRomanParser.parse("glob is I");
        wordToRomanParser.parse("prok is V");
        wordToRomanParser.parse("pish is X");
        wordToRomanParser.parse("tegj is L");

        //parseWordsAndItemForValue.parse("how much is pish tegj glob glob ?");
        assertEquals(52, parseWordsAndItemForValue.parse("how much is pish tegj glob glob ?"));
    }
}
