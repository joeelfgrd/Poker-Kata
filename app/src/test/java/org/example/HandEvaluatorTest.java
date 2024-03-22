package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class HandEvaluatorTest {

    @Test
    public void testEvaluateHand_FourOfAKind() {
        // Arrange
        HandEvaluator evaluator = new HandEvaluator();
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("Hearts", "A"));
        hand.add(new PlayingCard("Diamonds", "A"));
        hand.add(new PlayingCard("Clubs", "A"));
        hand.add(new PlayingCard("Spades", "A"));

        // Act
        HandWithPlayerIndex result = evaluator.evaluateHand(hand, new ArrayList<>(), 0);

        // Assert
        assertEquals(HandRank.FOUR_OF_A_KIND, result.getHandRank());
    }

    @Test
    public void testEvaluateHand_HighCard() {
        // Arrange
        HandEvaluator evaluator = new HandEvaluator();
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("Hearts", "A"));
        hand.add(new PlayingCard("Diamonds", "K"));

        // Act
        HandWithPlayerIndex result = evaluator.evaluateHand(hand, new ArrayList<>(), 0);

        // Assert
        assertEquals(HandRank.HIGH_CARD, result.getHandRank());
        assertEquals(new PlayingCard("Hearts", "A"), result.getHighCard());
    }

    @Test
    public void testContainsFourOfAKind_FourOfAKindPresent() {
        // Arrange
        HandEvaluator evaluator = new HandEvaluator();
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("Hearts", "3"));
        hand.add(new PlayingCard("Diamonds", "3"));
        hand.add(new PlayingCard("Clubs", "3"));
        hand.add(new PlayingCard("Spades", "3"));
        List<PlayingCard> communityCards = new ArrayList<>();

        // Act
        boolean result = evaluator.containsFourOfAKind(hand, communityCards);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testContainsFourOfAKind_NoFourOfAKindPresent() {
        // Arrange
        HandEvaluator evaluator = new HandEvaluator();
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("Hearts", "A"));
        hand.add(new PlayingCard("Diamonds", "K"));
        hand.add(new PlayingCard("Clubs", "Q"));
        hand.add(new PlayingCard("Spades", "J"));
        List<PlayingCard> communityCards = new ArrayList<>();

        // Act
        boolean result = evaluator.containsFourOfAKind(hand, communityCards);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testEvaluateHand_FullHouse() {
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("Spades", "A"));
        hand.add(new PlayingCard("Hearts", "A"));
        
        List<PlayingCard> communityCards = new ArrayList<>();
        communityCards.add(new PlayingCard("Diamonds", "3"));
        communityCards.add(new PlayingCard("Clubs", "Q"));
        communityCards.add(new PlayingCard("Clubs", "Q"));
        communityCards.add(new PlayingCard("Clubs", "Q"));
        
        HandEvaluator evaluator = new HandEvaluator();
        HandWithPlayerIndex result = evaluator.evaluateHand(hand, communityCards, 0);
        

        assertEquals(HandRank.FULL_HOUSE, result.getHandRank());
    }

    @Test
    public void testEvaluateHand_NotFullHouse() {
        // Creamos una mano y cartas comunitarias que no formen un full house
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("Spades", "A"));
        hand.add(new PlayingCard("Hearts", "A"));
        
        List<PlayingCard> communityCards = new ArrayList<>();
        communityCards.add(new PlayingCard("Diamonds", "A"));
        communityCards.add(new PlayingCard("Clubs", "K"));
        communityCards.add(new PlayingCard("Clubs", "Q"));
        communityCards.add(new PlayingCard("Clubs", "J"));
        
        HandEvaluator evaluator = new HandEvaluator();
        HandWithPlayerIndex result = evaluator.evaluateHand(hand, communityCards, 0);
        
        // Verificamos que la mano no sea clasificada como un full house
        assertNotEquals(HandRank.FULL_HOUSE, result.getHandRank());
    }
    
}
    
