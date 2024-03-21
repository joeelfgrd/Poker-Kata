package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandEvaluatorTest {

    @Test
    public void testEvaluateHands() {
        PlayingCard card1 = new PlayingCard("Hearts", "2");
        PlayingCard card2 = new PlayingCard("Hearts", "3");
        PlayingCard card3 = new PlayingCard("Hearts", "4");
        PlayingCard card4 = new PlayingCard("Hearts", "5");
        PlayingCard card5 = new PlayingCard("Hearts", "6");
        
        List<PlayingCard> hand1 = Arrays.asList(card1, card2, card3, card4, card5);
        List<PlayingCard> hand2 = Arrays.asList(card1, card2, card3, card4, card5);
        List<List<PlayingCard>> playerHands = new ArrayList<>();
        playerHands.add(hand1);
        playerHands.add(hand2);

        List<PlayingCard> communityCards = new ArrayList<>();

        HandEvaluator evaluator = new HandEvaluator();
        evaluator.evaluateHands(playerHands, communityCards);

        HandWithPlayerIndex winner = evaluator.getWinner();
        assertNotNull(winner);

        assertEquals(HandRank.STRAIGHT_FLUSH, winner.getHandRank());
    }
    @Test
    public void testEvaluateHands_OnePlayerHighCard() {
        // Preparar datos de prueba
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("A", "Spades"));
        hand.add(new PlayingCard("K", "Hearts"));

        List<List<PlayingCard>> playerHands = new ArrayList<>();
        playerHands.add(hand);

        List<PlayingCard> communityCards = new ArrayList<>();

        // Evaluar manos
        HandEvaluator evaluator = new HandEvaluator();
        evaluator.evaluateHands(playerHands, communityCards);
        HandWithPlayerIndex winner = evaluator.getWinner();

        // Verificar resultado esperado
        assertNotNull(winner);
        assertEquals(0, winner.getPlayerIndex());
        assertEquals(HandRank.HIGH_CARD, winner.getHandRank());
    }
    @Test
    public void testEvaluateHands_OnePlayerTwoPairs() {
        // Preparar datos de prueba
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("A", "Spades"));
        hand.add(new PlayingCard("A", "Hearts"));
        hand.add(new PlayingCard("K", "Diamonds"));
        hand.add(new PlayingCard("K", "Clubs"));

        List<List<PlayingCard>> playerHands = new ArrayList<>();
        playerHands.add(hand);

        List<PlayingCard> communityCards = new ArrayList<>();

        // Evaluar manos
        HandEvaluator evaluator = new HandEvaluator();
        evaluator.evaluateHands(playerHands, communityCards);
        HandWithPlayerIndex winner = evaluator.getWinner();

        // Verificar resultado esperado
        assertNotNull(winner);
        assertEquals(0, winner.getPlayerIndex());
        assertEquals(HandRank.TWO_PAIR, winner.getHandRank());
    }
}