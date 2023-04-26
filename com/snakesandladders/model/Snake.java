package com.snakesandladders.model;

public class Snake{

    private int headPosition;

    private int tailPosition;

    public Snake(int headPosition, int tailPosition) {
        this.headPosition = headPosition;
        this.tailPosition = tailPosition;
    }

    public int getHeadPosition() {
        return headPosition;
    }

    public int getTailPosition() {
        return tailPosition;
    }
}
