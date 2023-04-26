package com.snakesandladders.model;

public class Player {


    @Override
    public String toString() {

       if ( winningPos == -1)
        return (playerName+" "+" Prev Pos:"+previousPosition +" Current Pos:"+playerPositon+" "+" Rolled dice value:"+diceValue);
       else
        return (playerName+" WON. Rank:"+winningPos+" Rolled dice value:"+diceValue);
    }

    private static int playerIdGenerator=1;

    private String playerName;

    private int playerPositon;

    private int previousPosition = -1;

    private int diceValue;

    private int player_id;

    private int winningPos = -1;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerPositon = 1;
        this.player_id=playerIdGenerator++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Player setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public int getPlayerPositon() {
        return playerPositon;
    }

    public Player setPlayerPositon(int playerPositon) {
        this.playerPositon = playerPositon;
        return this;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public Player setPreviousPosition(int previousPosition) {
        this.previousPosition = previousPosition;
        return this;
    }

    public Player setDiceValue(int diceValue) {
        this.diceValue = diceValue;
        return this;
    }

    public int getPreviousPosition() {
        return previousPosition;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public int getWinningPos() {
        return winningPos;
    }

    public Player setWinningPos(int winningPos) {
        this.winningPos = winningPos;
        return this;
    }
}
