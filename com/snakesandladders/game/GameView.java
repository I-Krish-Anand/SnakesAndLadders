package com.snakesandladders.game;

import com.snakesandladders.model.Ladder;
import com.snakesandladders.model.Player;
import com.snakesandladders.model.Snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameView {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    GameViewModel gameViewModel;

    GameView() {
        gameViewModel = new GameViewModel(this);
    }

    public static void main(String[] args) {
        new GameView().setupGame();
    }

    private void setupGame() {

        try {
            System.out.println("Enter board size NxN:");
            int size = Integer.parseInt(reader.readLine());

            System.out.println("Enter number of snakes");
            int noOfSnakes = Integer.parseInt(reader.readLine());

            Snake[] snakes = new Snake[noOfSnakes];
            for (int i = 0; i < noOfSnakes; i++) {
                System.out.println("Enter Head Position of the snake:");
                int head = Integer.parseInt(reader.readLine());
                System.out.println("Enter Tail Position of the snake");
                int tail = Integer.parseInt(reader.readLine());
                snakes[i] = new Snake(head, tail);
            }

            System.out.println("Enter number of ladders");
            int noOfLadders = Integer.parseInt(reader.readLine());

            Ladder[] ladders = new Ladder[noOfLadders];
            for (int i = 0; i < noOfLadders; i++) {
                System.out.println("Enter Tail Position of the ladder:");
                int tail = Integer.parseInt(reader.readLine());
                System.out.println("Enter Head Position of the ladder");
                int head = Integer.parseInt(reader.readLine());
                ladders[i] = new Ladder(tail, head);
            }

            System.out.println("Enter number of players");
            int noOfPlayers = Integer.parseInt(reader.readLine());

            Player[] players = new Player[noOfPlayers];
            for (int i = 0; i < noOfPlayers; i++) {
                System.out.println("Enter Player Name:");
                String playerName = reader.readLine();
                players[i] = new Player(playerName);

            }
            gameViewModel.setUpGame(size,snakes, ladders, players);
            playGame();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void playGame(){

       while (shouldGameContinue()) {
           Player player = gameViewModel.playGame();
           System.out.println(player);
       }

    }

    private boolean shouldGameContinue(){
        return gameViewModel.shouldGameContinue();
    }


}
