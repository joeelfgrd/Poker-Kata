package org.example;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class HandEvaluator {

    public HandWithPlayerIndex evaluateHand(List<PlayingCard> hand, List<PlayingCard> communityCards, int playerIndex) {
        EnumSet<HandRank> handRanks = EnumSet.noneOf(HandRank.class);

        for (HandRank handRank : HandRank.values()) {
            if (handRank.matches(hand, communityCards)) {
                handRanks.add(handRank);
            }
        }

        if (handRanks.contains(HandRank.FOUR_OF_A_KIND)) {
            return new HandWithPlayerIndex(HandRank.FOUR_OF_A_KIND, null, playerIndex, hand);
        } else if (handRanks.contains(HandRank.FULL_HOUSE)) {
            return new HandWithPlayerIndex(HandRank.FULL_HOUSE, null, playerIndex, hand);
        } else if (handRanks.contains(HandRank.FLUSH)) {
            return new HandWithPlayerIndex(HandRank.FLUSH, null, playerIndex, hand);
        }

        PlayingCard highCard = findHighCard(hand, communityCards);
        if (highCard != null) {
            return new HandWithPlayerIndex(HandRank.HIGH_CARD, highCard, playerIndex, hand);
        }
        return new HandWithPlayerIndex(HandRank.HIGH_CARD, findHighCard(hand, communityCards), playerIndex, hand);

    }

    private PlayingCard findHighCard(List<PlayingCard> hand, List<PlayingCard> communityCards) {
        List<PlayingCard> allCards = new ArrayList<>(hand);
        allCards.addAll(communityCards);

        if (allCards.isEmpty()) {
            return null;
        }

        return allCards.stream().parallel().max(PlayingCard::compareTo).orElse(null);
    }
}