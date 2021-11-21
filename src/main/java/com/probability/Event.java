package com.probability;

import java.util.HashMap;

public enum Event {
    HEAD("H", "NONE"),TAIL("T", "NONE"),
    HEAD_AND_HEAD("HH","AND"), HEAD_AND_TAIL("HT", "AND"),
    TAIL_AND_HEAD("TH", "AND"), TAIL_AND_TAIL("TT", "AND"),

    NOT_HEAD("H", "NOT"), NOT_TAIL("T", "NOT"),
    NOT_HEAD_HEAD("HH", "NOT"), NOT_HEAD_TAIL("HT", "NOT"),
    NOT_TAIL_HEAD("TH", "NOT"), NOT_TAIL_TAIL("TT", "NOT"),

    HEAD_OR_HEAD("HH", "OR"), HEAD_OR_TAIL("HT", "OR"),
    TAIL_OR_HEAD("TH", "OR"), TAIL_OR_TAIL("TT", "OR");

    public String probabilityOperand;
    public String event;


    public static final int MAX_PROBABILITY = 1;

    Event(String event, String probabilityOperand){
        this.event = event;
        this.probabilityOperand = probabilityOperand;
    }
}
