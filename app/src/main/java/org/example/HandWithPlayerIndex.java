package org.example;

import java.util.List;

public class HandWithPlayerIndex {
    private HandRank handRank;
    private PlayingCard highCard;
    private int playerIndex;
    private List<PlayingCard> hand;

    public HandWithPlayerIndex(HandRank handRank, PlayingCard highCard, int playerIndex, List<PlayingCard> hand) {
        this.handRank = handRank;
        this.highCard = highCard;
        this.playerIndex = playerIndex;
        this.hand = hand;
    }

    public HandRank getHandRank() {
        return handRank;
    }

    public PlayingCard getHighCard() {
        return highCard;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public List<PlayingCard> getHand() {
        return hand;
    }
}