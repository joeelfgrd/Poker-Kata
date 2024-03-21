package org.example;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Card> communityCards;

    public Table() {
        this.communityCards = new ArrayList<>();
    }

    // Método para repartir las cartas del flop (primeras 3 cartas comunitarias)
    public void dealFlop(Deck deck) {
        dealCards(deck, 3);
    }

    // Método para repartir la carta del turn (cuarta carta comunitaria)
    public void dealTurn(Deck deck) {
        dealCards(deck, 1);
    }

    // Método para repartir la carta del river (quinta carta comunitaria)
    public void dealRiver(Deck deck) {
        dealCards(deck, 1);
    }

    // Método genérico para repartir cartas en la mesa
    private void dealCards(Deck deck, int numCards) {
        List<Card> cards = deck.getCards();
        for (int i = 0; i < numCards; i++) {
            communityCards.add(cards.remove(0)); // Remover la carta del mazo y agregarla a la mesa
        }
    }
      // Método para obtener las cartas comunitarias en la mesa
      public List<Card> getCommunityCards() {
        return communityCards;
    }
    // Otros métodos de la clase Table...
}
