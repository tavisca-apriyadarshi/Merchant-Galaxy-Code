package com.tavisca.workshop.merchantGalaxy2;

public class WordItemAndNumberParser {
    public String[] splitOnIs;
    public String[] wordsBeforeItem;
    public String[] wordAndItem;
    public String[] numberAndCredit;
    //public ItemList itemList = new ItemList();

    public String item;
    int number =0;
    public String[] parse(String input, ItemList itemList) {
        splitOnIs = input.split(" is ");
        wordAndItem = splitOnIs[0].split(" ");
        numberAndCredit = splitOnIs[1].split(" ");
        item = wordAndItem[wordAndItem.length-1];
        wordsBeforeItem = new String[wordAndItem.length-1];
        for(int i=0; i<wordAndItem.length-1; i++){
            wordsBeforeItem[i] = wordAndItem[i];
        }
        itemList.items.add(item);
        number = Integer.parseInt(numberAndCredit[0]);
        return new String[]{(wordAndItem.length - 1)+"", wordAndItem[wordAndItem.length-1], numberAndCredit[0] };
    }
}
