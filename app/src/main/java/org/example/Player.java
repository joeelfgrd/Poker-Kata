package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}

