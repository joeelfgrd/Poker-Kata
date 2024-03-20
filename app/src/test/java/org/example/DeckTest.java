package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckTest {

    @Test
    public void testInitializeDeck() {
        Deck deck = new Deck();
        
        // Obtener la lista de cartas en la baraja
        List<Card> cards = deck.getCards();
        
        // Verificar que la lista de cartas no esté vacía
        assertFalse(cards.isEmpty());
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        List<Card> originalOrder = new ArrayList<>(deck.getCards()); // Copia del orden original
        
        // Verificar que la lista de cartas no esté vacía antes de mezclar
        assertFalse(deck.getCards().isEmpty());
        
        // Mezclar la baraja
        deck.shuffle();
        
        // Verificar que las cartas se han mezclado
        assertNotEquals(originalOrder, deck.getCards());
    }
} 