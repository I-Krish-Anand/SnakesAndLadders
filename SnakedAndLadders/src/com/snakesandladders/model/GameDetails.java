package com.snakesandladders.model;

public class GameDetails {

    private int noOfPlayers;
    public static int rank = 1;
    public static int size;
    public static int[] calcPosition(int position){

        int row= size -1-(position-1)/ size;
        int col= (row%2== size %2)? size -1-(position-1)% size :(position-1)% size;
        return new int[]{row,col};

    }

}
