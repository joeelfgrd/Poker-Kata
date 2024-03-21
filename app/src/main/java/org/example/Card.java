package org.example;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {
    private String suit;
    private String value;
    
    private static final Map<String, Integer> VALUE_MAP = new HashMap<>();
    static {
        VALUE_MAP.put("2", 2);
        VALUE_MAP.put("3", 3);
        VALUE_MAP.put("4", 4);
        VALUE_MAP.put("5", 5);
        VALUE_MAP.put("6", 6);
        VALUE_MAP.put("7", 7);
        VALUE_MAP.put("8", 8);
        VALUE_MAP.put("9", 9);
        VALUE_MAP.put("10", 10);
        VALUE_MAP.put("J", 11);
        VALUE_MAP.put("Q", 12);
        VALUE_MAP.put("K", 13);
        VALUE_MAP.put("A", 14); 
    }

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Card otherCard) {
        
        int valueComparison = Integer.compare(getNumericValue(), otherCard.getNumericValue());
        if (valueComparison == 0) {
            return suit.compareTo(otherCard.getSuit());
        } else {
            return valueComparison;
        }
    }
    
    private int getNumericValue() {
        return VALUE_MAP.get(value);
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
