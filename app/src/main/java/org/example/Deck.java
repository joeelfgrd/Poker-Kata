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

 
    public List<Card> dealCards(boolean isTurnOrRiver) {
        if (isTurnOrRiver) {
            Card discardedCard = cards.remove(0);
            cards.add(discardedCard);
        } else {
            List<Card> dealtCards = new ArrayList<>();
            dealtCards.add(dealCard());
            return dealtCards;
        }
        return null;
    }

    
    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No hay cartas en el mazo");
        }
        return cards.remove(0); 
    }

    public List<Card> getCards() {
        return cards;
    }
}

