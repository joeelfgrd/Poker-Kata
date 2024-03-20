package org.example;

public class Card {
    private String suit; 
    private String value; 

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
    public String toString() {
        return value + " of " + suit;
    }
}
