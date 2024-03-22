package org.example;
import java.util.Map;
import static java.util.Map.entry;

public class Card implements Comparable<Card> {
    private final String suit;
    private final String value;
    
    private static final Map<String, Integer> VALUE_MAP = Map.ofEntries(
        entry("2", 2),
        entry("3", 3),
        entry("4", 4),
        entry("5", 5),
        entry("6", 6),
        entry("7", 7),
        entry("8", 8),
        entry("9", 9),
        entry("10", 10),
        entry("J", 11),
        entry("Q", 12),
        entry("K", 13),
        entry("A", 14)
    );

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
        }
        return valueComparison;
    }
    
    private int getNumericValue() {
        return VALUE_MAP.get(value);
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
