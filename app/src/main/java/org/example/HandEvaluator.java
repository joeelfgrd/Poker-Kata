package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandEvaluator {
    private HandWithPlayerIndex winner;

    public void evaluateHands(List<List<PlayingCard>> playerHands, List<PlayingCard> communityCards) {
        HandWithPlayerIndex bestHand = null;
        int bestScore = 0;
    
        for (int i = 0; i < playerHands.size(); i++) {
            List<PlayingCard> hand = playerHands.get(i);
            HandWithPlayerIndex currentHand = evaluateHand(hand, communityCards, i);
            int currentScore = calculateHandScore(currentHand);
            if (bestHand == null || currentScore > bestScore) {
                bestHand = currentHand;
                bestScore = currentScore;
            }
        }
    
        if (bestHand != null) {
            winner = bestHand;
        } else {
            throw new IllegalStateException("No se pudo evaluar ninguna mano correctamente.");
        }
    }

    private HandWithPlayerIndex evaluateHand(List<PlayingCard> hand, List<PlayingCard> communityCards, int playerIndex) {
        Map<String, Integer> valueCount = getValueCount(hand, communityCards);
        boolean hasPair = containsPair(valueCount);
        boolean hasTwoPair = containsTwoPair(valueCount);
        boolean hasThreeOfAKind = containsThreeOfAKind(valueCount);
        boolean hasStraight = containsStraight(hand);
        boolean hasFlush = containsFlush(hand);
    
        if (hasStraight && hasFlush) {
            return new HandWithPlayerIndex(HandRank.STRAIGHT_FLUSH, null, playerIndex, hand);
        } else if (hasThreeOfAKind) {
            return new HandWithPlayerIndex(HandRank.THREE_OF_A_KIND, null, playerIndex, hand);
        } else if (hasTwoPair) {
            return new HandWithPlayerIndex(HandRank.TWO_PAIR, null, playerIndex, hand);
        } else if (hasFlush) {
            return new HandWithPlayerIndex(HandRank.FLUSH, null, playerIndex, hand);
        } else if (hasStraight) {
            return new HandWithPlayerIndex(HandRank.STRAIGHT, null, playerIndex, hand);
        } else if (hasPair) {
            return new HandWithPlayerIndex(HandRank.ONE_PAIR, null, playerIndex, hand);
        }
    
        return new HandWithPlayerIndex(HandRank.HIGH_CARD, null, playerIndex, hand);
    }

    public int calculateHandScore(HandWithPlayerIndex hand) {
        HandRank rank = hand.getHandRank();
        int baseScore = 0;
    
        switch (rank) {
            case ROYAL_FLUSH:
                baseScore = 10;
                break;
            case STRAIGHT_FLUSH:
                baseScore = 9;
                break;
            case FOUR_OF_A_KIND:
                baseScore = 8;
                break;
            case FULL_HOUSE:
                baseScore = 7;
                break;
            case FLUSH:
                baseScore = 6;
                break;
            case STRAIGHT:
                baseScore = 5;
                break;
            case THREE_OF_A_KIND:
                baseScore = 4;
                break;
            case TWO_PAIR:
                baseScore = 3;
                break;
            case ONE_PAIR:
                baseScore = 2;
                break;
            case HIGH_CARD:
                baseScore = 1;
                break;
        }
    
        return baseScore;
    }

    private Map<String, Integer> getValueCount(List<PlayingCard> hand, List<PlayingCard> communityCards) {
        List<PlayingCard> allCards = new ArrayList<>(hand);
        allCards.addAll(communityCards);
        Map<String, Integer> valueCount = new HashMap<>();

        for (PlayingCard card : allCards) {
            String value = card.getValue();
            valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
        }

        return valueCount;
    }

    private boolean containsPair(Map<String, Integer> valueCount) {
        for (int count : valueCount.values()) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean containsTwoPair(Map<String, Integer> valueCount) {
        int pairCount = 0;
        for (int count : valueCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount >= 2; // Se requieren al menos dos pares para cumplir con la condición de dos pares
    }

    private boolean containsThreeOfAKind(Map<String, Integer> valueCount) {
        for (int count : valueCount.values()) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean containsStraight(List<PlayingCard> hand) {
        Collections.sort(hand);
        // Verifica si hay una escalera
        for (int i = 0; i <= hand.size() - 5; i++) {
            boolean isStraight = true;
            for (int j = i; j < i + 4; j++) {
                if (hand.get(j).compareTo(hand.get(j + 1)) != -1) {
                    isStraight = false;
                    break;
                }
            }
            if (isStraight) {
                return true;
            }
        }
        return false;
    }
    private boolean containsFlush(List<PlayingCard> hand) {
        // Implementa lógica para verificar si la mano contiene un color
        // Necesitas verificar si todas las cartas tienen el mismo palo
        String firstSuit = hand.get(0).getSuit();
        for (int i = 1; i < hand.size(); i++) {
            if (!hand.get(i).getSuit().equals(firstSuit)) {
                return false;
            }
        }
        return true;
    }

    public HandWithPlayerIndex getWinner() {
        return winner;
    }

    public void setWinner(HandWithPlayerIndex winner) {
        this.winner = winner;
    }
}