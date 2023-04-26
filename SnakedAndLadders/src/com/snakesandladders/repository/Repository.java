package com.snakesandladders.repository;

import com.snakesandladders.model.GameDetails;
import com.snakesandladders.model.Ladder;
import com.snakesandladders.model.Player;
import com.snakesandladders.model.Snake;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Repository {


    int[][] board ;

    Queue<Player> playerQueue = new LinkedList<>();

    private static Repository repository;

    private Repository() {
    }

    public static Repository getInstance() {

        if (repository == null) {
            repository = new Repository();
        }
        return repository;

    }

    public void setBoard(int size, Snake[] snakes, Ladder[] ladders, Player[] players) {

        GameDetails.size = size;
        board = new int[GameDetails.size][GameDetails.size];
        for (Snake snake : snakes) {
            int[] headPostion = GameDetails.calcPosition(snake.getHeadPosition());
            board[headPostion[0]][headPostion[1]] = snake.getTailPosition();
        }

        for (Ladder ladder : ladders) {
            int[] tailPosition = GameDetails.calcPosition(ladder.getTailPosition());
            board[tailPosition[0]][tailPosition[1]] = ladder.getHeadPosition();
        }

        for (Player player : players)
            playerQueue.add(player);


    }

    public Player playGame(int diceValue) {

        Player player = playerQueue.poll();
        int currPosition = player.getPlayerPositon();
        player.setPreviousPosition(currPosition);
        player.setDiceValue(diceValue);

        currPosition += diceValue;
        int[] currentPos = GameDetails.calcPosition(currPosition);

        while (currPosition < (GameDetails.size*GameDetails.size) && board[currentPos[0]][currentPos[1]] != 0) {
            currPosition = board[currentPos[0]][currentPos[1]];
            currentPos = GameDetails.calcPosition(currPosition);
        }

        if (currPosition == (GameDetails.size*GameDetails.size))
            player.setWinningPos(GameDetails.rank++);
        else if(currPosition < (GameDetails.size*GameDetails.size)){
            player.setPlayerPositon(currPosition);
            playerQueue.add(player);
        }
        else
            playerQueue.add(player);
        return player;
    }

    public boolean shouldGameContinue() {
        return playerQueue.size() > 1;
    }
}
