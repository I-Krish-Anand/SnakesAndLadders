package com.snakesandladders.model;

public class Ladder {

    private int tailPosition;

    private int headPosition;

    public Ladder(int tailPosition, int headPosition) {
        this.tailPosition = tailPosition;
        this.headPosition = headPosition;
    }

    public int getTailPosition() {
        return tailPosition;
    }

    public int getHeadPosition() {
        return headPosition;
    }
}
