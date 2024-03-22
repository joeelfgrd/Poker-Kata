package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum HandRank {
    HIGH_CARD {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            return false; // TODO: Implement this
        }
    },
    ONE_PAIR {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            return false; // TODO: Implement this
        }
    },
    TWO_PAIR {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            return false; // TODO: Implement this
        }
    },
    THREE_OF_A_KIND {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            return false; // TODO: Implement this
        }
    },
    STRAIGHT {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            return false; // TODO: Implement this
        }
    },
    FLUSH {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            List<PlayingCard> allCards = new ArrayList<>(hand);
            allCards.addAll(communityCards);

            Map<String, Integer> suitCount = new HashMap<>();
            for (PlayingCard card : allCards) {
                String suit = card.getSuit();
                suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
            }

            for (int count : suitCount.values()) {
                if (count >= 5) {
                    return true;
                }
            }

            return false;
        }
    },
    FULL_HOUSE {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
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
    },
    FOUR_OF_A_KIND {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
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
    },
    STRAIGHT_FLUSH {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            return false; // TODO: Implement this
        }
    },
    ROYAL_FLUSH {
        @Override
        public boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards) {
            return false; // TODO: Implement this
        }
    };

    public abstract boolean matches(List<PlayingCard> hand, List<PlayingCard> communityCards);
}