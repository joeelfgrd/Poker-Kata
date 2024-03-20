package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testGetSuit() {
        Card card = new Card("Hearts", "A");
        assertEquals("Hearts", card.getSuit());
    }

    @Test
    public void testGetValue() {
        Card card = new Card("Spades", "10");
        assertEquals("10", card.getValue());
    }

    @Test
    public void testToString() {
        Card card = new Card("Diamonds", "J");
        assertEquals("J of Diamonds", card.toString());
    }
}