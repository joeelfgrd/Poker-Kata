package org.example;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HandRankTest {

    @Test
    public void testEnumValues() {
        assertEquals("HIGH_CARD", HandRank.HIGH_CARD.name());
    }
}