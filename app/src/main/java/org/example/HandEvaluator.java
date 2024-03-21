package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandEvaluator {

    public HandWithPlayerIndex evaluateOnePair(List<List<PlayingCard>> playerHands, List<PlayingCard> communityCards) {
        HandWithPlayerIndex bestPairHand = null;

        for (int i = 0; i < playerHands.size(); i++) {
            List<PlayingCard> playerHand = playerHands.get(i);
            List<PlayingCard> allCards = new ArrayList<>(playerHand);
            allCards.addAll(communityCards);
            Map<String, Integer> valueCount = new HashMap<>();

            // Contar cuántas veces aparece cada valor de carta en la mano
            for (PlayingCard card : allCards) {
                String value = card.getValue();
                valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
            }

            // Buscar un par en la mano del jugador
            for (Map.Entry<String, Integer> entry : valueCount.entrySet()) {
                if (entry.getValue() == 2) {
                    PlayingCard pairCard = new PlayingCard("", entry.getKey()); // La carta del par
                    HandWithPlayerIndex pairHand = new HandWithPlayerIndex(HandRank.ONE_PAIR, pairCard, i);
                    if (bestPairHand == null || pairCard.compareTo(bestPairHand.getHighCard()) > 0) {
                        bestPairHand = pairHand;
                    }
                }
            }
        }

        return bestPairHand;
    }
}