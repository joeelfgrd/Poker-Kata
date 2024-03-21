package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HandEvaluatorTest {

    @Test
    public void testEvaluateOnePair() {
        // Jugador 1: Par de Ases (mejor mano)
        List<PlayingCard> player1Hand = Arrays.asList(new PlayingCard("Hearts", "A"), new PlayingCard("Spades", "A"));
        
        // Jugador 2: Par de Reyes
        List<PlayingCard> player2Hand = Arrays.asList(new PlayingCard("Diamonds", "K"), new PlayingCard("Clubs", "K"));

        // Cartas comunitarias
        List<PlayingCard> communityCards = Arrays.asList(new PlayingCard("Hearts", "J"), new PlayingCard("Diamonds", "Q"), new PlayingCard("Clubs", "10"));

        // Lista de manos de los jugadores
        List<List<PlayingCard>> playerHands = new ArrayList<>();
        playerHands.add(player1Hand);
        playerHands.add(player2Hand);

        // Evaluar las manos
        HandEvaluator handEvaluator = new HandEvaluator();
        HandWithPlayerIndex bestPairHand = handEvaluator.evaluateOnePair(playerHands, communityCards);

        // Verificar que se haya encontrado la mejor mano con un par
        assertNotNull(bestPairHand);
        assertEquals(HandRank.ONE_PAIR, bestPairHand.getHandRank());
        assertEquals("A", bestPairHand.getHighCard().getValue()); // Verificar que el par sea de Ases
        assertEquals(0, bestPairHand.getPlayerIndex()); // Verificar que el par sea del jugador 1
    }
}