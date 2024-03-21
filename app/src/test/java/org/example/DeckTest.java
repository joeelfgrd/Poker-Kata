package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testDealCardsNormal() {
        List<Card> dealtCards = deck.dealCards(false);

        assertNotNull(dealtCards); // Verificar que se ha repartido al menos una carta
        assertEquals(1, dealtCards.size()); // Verificar que se ha repartido una sola carta
    }

    @Test
    public void testDealCardsTurn() {
        Card discardedCard = deck.getCards().get(0); // Obtener la carta que se descartará en el turn
        
        deck.dealCards(true);
        
        assertEquals(discardedCard, deck.getCards().get(deck.getCards().size() - 1)); // Verificar que la carta descartada está al final del mazo
    }

    @Test
    public void testDealCardsRiver() {
        Card discardedCard = deck.getCards().get(0); // Obtener la carta que se descartará en el river
        
        deck.dealCards(true);
        
        assertEquals(discardedCard, deck.getCards().get(deck.getCards().size() - 1)); // Verificar que la carta descartada está al final del mazo
    }

    @Test
    public void testDealCard() {
        Card dealtCard = deck.dealCard();

        assertNotNull(dealtCard); // Verificar que se ha repartido una carta
    }

    @Test(expected = IllegalStateException.class)
    public void testDealCardEmptyDeck() {
        // Vaciar la baraja
        while (!deck.getCards().isEmpty()) {
            deck.dealCard();
        }
        
        // Intentar repartir una carta cuando la baraja está vacía
        deck.dealCard();
    }
}