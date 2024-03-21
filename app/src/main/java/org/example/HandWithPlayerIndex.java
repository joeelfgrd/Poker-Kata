package org.example;

public class HandWithPlayerIndex {
    private HandRank handRank;
    private PlayingCard highCard;
    private int playerIndex;

    public HandWithPlayerIndex(HandRank handRank, PlayingCard highCard, int playerIndex) {
        this.handRank = handRank;
        this.highCard = highCard;
        this.playerIndex = playerIndex;
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
}