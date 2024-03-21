package org.example;

public class Card {
    private String suit; // Palos: corazones, diamantes, tréboles, picas
    private String value; // Valor de la carta: 2-10, J (Jack), Q (Queen), K (King), A (Ace)

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    // Métodos para obtener el palo y el valor de la carta
    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    // Método para representar la carta como una cadena de texto
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
