package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HandWithPlayerIndexTest {

    @Test
    public void testGetters() {
        PlayingCard highCard = new PlayingCard("Hearts", "A");
        HandRank handRank = HandRank.HIGH_CARD;
        int playerIndex = 0;
        List<PlayingCard> hand = new ArrayList<>();

        HandWithPlayerIndex handWithPlayerIndex = new HandWithPlayerIndex(handRank, highCard, playerIndex, hand);

        assertNotNull(handWithPlayerIndex);
        assertEquals(handRank, handWithPlayerIndex.getHandRank());
        assertEquals(highCard, handWithPlayerIndex.getHighCard());
        assertEquals(playerIndex, handWithPlayerIndex.getPlayerIndex());
        assertEquals(hand, handWithPlayerIndex.getHand());
    }

    @Test
    public void testConstructorAndGetters() {
        PlayingCard highCard = new PlayingCard("Hearts", "A");
        HandRank handRank = HandRank.HIGH_CARD;
        int playerIndex = 0;
        List<PlayingCard> hand = new ArrayList<>();

        HandWithPlayerIndex handWithPlayerIndex = new HandWithPlayerIndex(handRank, highCard, playerIndex, hand);

        assertEquals(handRank, handWithPlayerIndex.getHandRank());
        assertEquals(highCard, handWithPlayerIndex.getHighCard());
        assertEquals(playerIndex, handWithPlayerIndex.getPlayerIndex());
        assertEquals(hand, handWithPlayerIndex.getHand());
    }
}