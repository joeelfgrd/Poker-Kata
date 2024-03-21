package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // Método para añadir una carta a la mano del jugador
    public void addToHand(Card card) {
        hand.add(card);
    }

    // Método para obtener la mano del jugador
    public List<Card> getHand() {
        return hand;
    }

    // Método para obtener el nombre del jugador
    public String getName() {
        return name;
    }
}

