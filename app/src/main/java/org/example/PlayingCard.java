package org.example;

public class PlayingCard implements Comparable<PlayingCard> {
    private String suit;
    private String value;

    public PlayingCard(String suit, String value) {
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
    public int compareTo(PlayingCard other) {
        // Asignar valores numéricos a las cartas
        int thisValue = getValueAsInt(this.value);
        int otherValue = getValueAsInt(other.getValue());
    
        // Comparar las cartas por sus valores numéricos
        return Integer.compare(thisValue, otherValue);
    }
    
    private int getValueAsInt(String value) {
        switch (value) {
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(value);
        }
    }
}