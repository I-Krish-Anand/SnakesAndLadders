package com.snakesandladders.game;

import com.snakesandladders.model.Ladder;
import com.snakesandladders.model.Player;
import com.snakesandladders.model.Snake;

import java.util.Scanner;

public class GameView {

    Scanner scanner = new Scanner(System.in);
    GameViewModel gameViewModel;

    GameView() {
        gameViewModel = new GameViewModel(this);
    }

    public static void main(String[] args) {
        new GameView().setupGame();
    }

    private void setupGame() {

        System.out.println("Enter board size NxN:");
        int size = scanner.nextInt();

        System.out.println("Enter number of snakes");
        int noOfSnakes = scanner.nextInt();

        Snake[] snakes = new Snake[noOfSnakes];
        for (int i = 0; i < noOfSnakes; i++) {

            System.out.println("Enter Head Position of the snake:");
            int head = scanner.nextInt();
            System.out.println("Enter Tail Position of the snake");
            int tail = scanner.nextInt();
            snakes[i] = new Snake(head, tail);

        }

        System.out.println("Enter number of ladders");
        int noOfLadders = scanner.nextInt();

        Ladder[] ladders = new Ladder[noOfLadders];
        for (int i = 0; i < noOfLadders; i++) {

            System.out.println("Enter Tail Position of the ladder:");
            int tail = scanner.nextInt();
            System.out.println("Enter Head Position of the ladder");
            int head = scanner.nextInt();
            ladders[i] = new Ladder(tail, head);

        }

        System.out.println("Enter number of players");
        int noOfPlayeres = scanner.nextInt();

        Player[] players = new Player[noOfPlayeres];
        for (int i = 0; i < noOfPlayeres; i++) {

            String playerName = scanner.next();
            players[i] = new Player(playerName);

        }

        gameViewModel.setUpGame(size,snakes, ladders, players);
        playGame();

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
