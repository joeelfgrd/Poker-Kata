package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    // Constructor
    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    // Método para inicializar la baraja con todas las cartas
    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    // Método para mezclar la baraja
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Método para repartir cartas a los jugadores y a la mesa
    public List<Card> dealCards(boolean isTurnOrRiver) {
        if (isTurnOrRiver) {
            // Descartar la primera carta (A de picas en el caso del turn, 3 de picas en el caso del river)
            Card discardedCard = cards.remove(0);
            // Agregar la carta descartada al final del mazo
            cards.add(discardedCard);
        } else {
            // Repartir una carta normalmente para los jugadores
            List<Card> dealtCards = new ArrayList<>();
            dealtCards.add(dealCard());
            return dealtCards;
        }
        return null; // Devolver null ya que no estamos repartiendo cartas a los jugadores en este caso
    }

    // Método para repartir una carta del mazo
    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No hay cartas en el mazo");
        }
        return cards.remove(0); // Retirar y devolver la primera carta del mazo
    }

    // Método para obtener la lista de cartas en la baraja
    public List<Card> getCards() {
        return cards;
    }
}

