package org.example;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Card> communityCards;

    public Table() {
        this.communityCards = new ArrayList<>();
    }

    
    public void dealFlop(Deck deck) {
        dealCards(deck, 3);
    }

    
    public void dealTurn(Deck deck) {
        dealCards(deck, 1);
    }

    
    public void dealRiver(Deck deck) {
        dealCards(deck, 1);
    }

    
    private void dealCards(Deck deck, int numCards) {
        List<Card> cards = deck.getCards();
        for (int i = 0; i < numCards; i++) {
            communityCards.add(cards.remove(0));
        }
    }
      
      public List<Card> getCommunityCards() {
        return communityCards;
    }
}
