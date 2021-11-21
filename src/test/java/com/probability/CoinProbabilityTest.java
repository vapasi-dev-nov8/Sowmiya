package com.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinProbabilityTest {

    @Test
    public void checkIfHeadProbabilityEqualsTailProbability() {
        assertEquals(new CoinProbability(Event.HEAD), new CoinProbability(Event.TAIL));
    }

    @Test
    public void checkProbabilityOfTwoIndependentEvents() {
        assertDoesNotThrow(() -> new CoinProbability(Event.HEAD_AND_HEAD));
        assertEquals(new CoinProbability(Event.HEAD_AND_HEAD), new CoinProbability(Event.TAIL_AND_HEAD));
    }

    @Test
    public void checkProbabilityOfEventNotOccurring() {
        assertDoesNotThrow(() -> new CoinProbability(Event.NOT_HEAD_TAIL));
    }

    @Test
    public void checkProbabilityOfEitherEventsOccurring() {
        assertDoesNotThrow(() -> new CoinProbability(Event.TAIL_OR_HEAD));
    }
}
