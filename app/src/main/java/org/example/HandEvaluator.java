package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandEvaluator {
    
    public HandWithPlayerIndex evaluateHand(List<PlayingCard> hand, List<PlayingCard> communityCards, int playerIndex) {
        if (containsFourOfAKind(hand, communityCards)) {
            return new HandWithPlayerIndex(HandRank.FOUR_OF_A_KIND, null, playerIndex, hand);
        } else if (containsFullHouse(hand, communityCards)) {
            return new HandWithPlayerIndex(HandRank.FULL_HOUSE, null, playerIndex, hand);
        } else {
            PlayingCard highCard = findHighCard(hand, communityCards);
            if (highCard != null) {
                return new HandWithPlayerIndex(HandRank.HIGH_CARD, highCard, playerIndex, hand);
            } else {
                return new HandWithPlayerIndex(HandRank.HIGH_CARD, findHighCard(hand, communityCards), playerIndex, hand);
            }
        }
    }

    private PlayingCard findHighCard(List<PlayingCard> hand, List<PlayingCard> communityCards) {
        List<PlayingCard> allCards = new ArrayList<>(hand);
        allCards.addAll(communityCards);
        
        if (allCards.isEmpty()) {
            return null; 
        }
        
        return allCards.stream().parallel().max(PlayingCard::compareTo).orElse(null);
    }

    public boolean containsFourOfAKind(List<PlayingCard> hand, List<PlayingCard> communityCards) {
        List<PlayingCard> allCards = new ArrayList<>(hand);
        allCards.addAll(communityCards);
        
        Map<String, Integer> valueCount = new HashMap<>();
        for (PlayingCard card : allCards) {
            String value = card.getValue();
            valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
        }
        
        for (int count : valueCount.values()) {
            if (count >= 4) {
                return true; 
            }
        }
        
        return false; 
    }

    public boolean containsFullHouse(List<PlayingCard> hand, List<PlayingCard> communityCards) {
        List<PlayingCard> allCards = new ArrayList<>(hand);
        allCards.addAll(communityCards);
        
        Map<String, Integer> valueCount = new HashMap<>();
        for (PlayingCard card : allCards) {
            String value = card.getValue();
            valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
        }
        
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        
        for (int count : valueCount.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }
        
        return hasThreeOfAKind && hasPair;
    }
}