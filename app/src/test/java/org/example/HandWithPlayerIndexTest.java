package org.example;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HandWithPlayerIndexTest {

    @Test
    public void testGetters() {
        PlayingCard card = new PlayingCard("Hearts", "A");
        HandWithPlayerIndex hand = new HandWithPlayerIndex(HandRank.HIGH_CARD, card, 0);

        assertEquals(HandRank.HIGH_CARD, hand.getHandRank());
        assertEquals(card, hand.getHighCard());
        assertEquals(0, hand.getPlayerIndex());
    }

    @Test
    public void testConstructorAndGetters() {
        PlayingCard highCard = new PlayingCard("Hearts", "A");
        HandRank handRank = HandRank.HIGH_CARD;
        int playerIndex = 0;

        HandWithPlayerIndex handWithPlayerIndex = new HandWithPlayerIndex(handRank, highCard, playerIndex);

        assertEquals(handRank, handWithPlayerIndex.getHandRank());
        assertEquals(highCard, handWithPlayerIndex.getHighCard());
        assertEquals(playerIndex, handWithPlayerIndex.getPlayerIndex());
    }
}