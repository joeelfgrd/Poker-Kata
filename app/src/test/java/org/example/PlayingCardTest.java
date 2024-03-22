package org.example;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlayingCardTest {

    @Test
    public void testCompareTo_SameValue() {
        PlayingCard card1 = new PlayingCard("Hearts", "8");
        PlayingCard card2 = new PlayingCard("Clubs", "8");
        
        assertEquals(0, card1.compareTo(card2));
        assertEquals(0, card2.compareTo(card1));
    }
    
    @Test
    public void testCompareTo_DifferentValue() {
        PlayingCard card1 = new PlayingCard("Spades", "J");
        PlayingCard card2 = new PlayingCard("Diamonds", "Q");
        
        assertTrue(card1.compareTo(card2) < 0);
        assertTrue(card2.compareTo(card1) > 0);
    }
    
    @Test
    public void testCompareTo_AceAndNumber() {
        PlayingCard card1 = new PlayingCard("Diamonds", "A");
        PlayingCard card2 = new PlayingCard("Hearts", "5");
        
        assertTrue(card1.compareTo(card2) > 0);
        assertTrue(card2.compareTo(card1) < 0);
    }
    
    @Test
    public void testCompareTo_AceAndKing() {
        PlayingCard card1 = new PlayingCard("Clubs", "A");
        PlayingCard card2 = new PlayingCard("Spades", "K");
        
        assertTrue(card1.compareTo(card2) > 0);
        assertTrue(card2.compareTo(card1) < 0);
    }
}