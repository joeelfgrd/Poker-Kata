package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    
    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    
    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    
    public List<List<Card>> dealCards(int numPlayers) {
        
        shuffle();

        
        int cardsPerPlayer = cards.size() / numPlayers;

        
        List<List<Card>> hands = new ArrayList<>();

        
        for (int i = 0; i < numPlayers; i++) {
            List<Card> hand = new ArrayList<>();
            for (int j = 0; j < cardsPerPlayer; j++) {
                hand.add(cards.remove(0)); // Quitar la carta de la parte superior de la baraja y agregarla a la mano del jugador
            }
            hands.add(hand);
        }

        return hands;
    }

    
    public List<Card> getCards() {
        return cards;
    }
}

