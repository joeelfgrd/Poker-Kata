package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayingCardTest {

    @Test
    public void testCompareTo() {
        PlayingCard card1 = new PlayingCard("Hearts", "A");
        PlayingCard card2 = new PlayingCard("Diamonds", "K");

        assertEquals(1, card1.compareTo(card2)); // A (14) > K (13)
    }
}