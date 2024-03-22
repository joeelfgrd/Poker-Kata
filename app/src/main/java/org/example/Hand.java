package org.example;

public class Hand {
    private HandRank handRank;
    private Player player;

    public Hand(HandRank handRank, Player player) {
        this.handRank = handRank;
        this.player = player;
    }

    public HandRank getHandRank() {
        return handRank;
    }

    public Player getPlayer() {
        return player;
    }
}