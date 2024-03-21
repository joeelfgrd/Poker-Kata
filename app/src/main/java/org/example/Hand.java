package org.example;

public class Hand {
    private HandRank handRank;
    private Card highCard;
    private Player player;

    public Hand(HandRank handRank, Card highCard, Player player) {
        this.handRank = handRank;
        this.highCard = highCard;
        this.player = player;
    }

    public HandRank getHandRank() {
        return handRank;
    }

    public Card getHighCard() {
        return highCard;
    }

    public Player getPlayer() {
        return player;
    }
}