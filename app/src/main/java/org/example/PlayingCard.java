package org.example;
import java.util.Objects;

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
        int thisValue = getValueAsInt(this.value);
        int otherValue = getValueAsInt(other.getValue());

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
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    return -1;
                }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlayingCard other = (PlayingCard) obj;
        return Objects.equals(suit, other.suit) && Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}