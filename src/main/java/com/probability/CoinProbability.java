package com.probability;

import java.util.HashMap;
import java.util.Objects;

public class CoinProbability {

    private double probabilityOfEvent;
    private static final HashMap<String, Integer> possibleEventsOfACoin = new HashMap<String, Integer>(){{
                                                                          put(Event.HEAD.event, 1);
                                                                          put(Event.TAIL.event, 1);
                                                                          }};

    public CoinProbability(Event event){
        calculateProbability(event.event, event.probabilityOperand);
    }

    public void calculateProbability(String event, String operand){
        switch (operand){
            case "AND":
                this.probabilityOfEvent = this.getProbabilityForIntersection(event);
                break;
            case "NOT":
                this.probabilityOfEvent = Event.MAX_PROBABILITY - this.getProbabilityForIntersection(event);
                break;
            case "OR":
                this.calculateProbabilityForOR(event);
                break;
            case "NONE":
                this.probabilityOfEvent = getProbabilityOfSingleEvent(event);
                break;
        }
    }

    public double getProbabilityForIntersection(String event) {
        int headCount = (int)event.chars().filter(ch -> ch == 'H').count();
        int tailCount = (int)event.chars().filter(ch -> ch == 'T').count();
        int summationOfHeadAndTailCount = headCount + tailCount;
        double probability = Event.MAX_PROBABILITY;

        if (summationOfHeadAndTailCount == 0) {
            probability = 0;
            return probability;
        }
        for (int i = 0; i < headCount; i++)
            probability *= getProbabilityOfSingleEvent(Event.HEAD.event);
        for (int i = 0; i < tailCount; i++)
            probability *= getProbabilityOfSingleEvent(Event.TAIL.event);
        return probability;
    }

    public void calculateProbabilityForOR(String event) {
        char[] events = event.toCharArray();
        double summation = 0;
        for(char eventChar : events)
            summation += getProbabilityOfSingleEvent(Character.toString(eventChar));
        double probabilityOfIntersection = getProbabilityForIntersection(event);
        probabilityOfEvent = summation - probabilityOfIntersection;
    }

    public double getProbabilityOfSingleEvent(String event){
        return possibleEventsOfACoin.get(event)/getTotalNumberOfEvents();
    }

    public double getTotalNumberOfEvents(){
        return possibleEventsOfACoin.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CoinProbability that = (CoinProbability) o;
        return this.probabilityOfEvent == that.probabilityOfEvent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probabilityOfEvent);
    }

    public static void main(String[] args){
        CoinProbability coinProbability = new CoinProbability(Event.HEAD_OR_HEAD);
        System.out.println("probability : "+ coinProbability.probabilityOfEvent);
    }
}
