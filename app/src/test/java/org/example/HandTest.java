package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HandTest {

    @Test
    public void testHandCreation() {
        // Arrange
        HandRank expectedRank = HandRank.HIGH_CARD;
        Player player = new Player("John");

        // Act
        Hand hand = new Hand(expectedRank, player);

        // Assert
        assertEquals(expectedRank, hand.getHandRank());
        assertEquals(player, hand.getPlayer());
    }

}