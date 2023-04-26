package com.snakesandladders.game;

import com.snakesandladders.model.Ladder;
import com.snakesandladders.model.Player;
import com.snakesandladders.model.Snake;
import com.snakesandladders.repository.Repository;

public class GameViewModel {

    GameView gameView;

    GameViewModel(GameView gameView){
       this.gameView = gameView;
    }

    public void setUpGame(int size, Snake[] snakes, Ladder[] ladders, Player[] players){

        Repository.getInstance().setBoard(size, snakes, ladders, players);
    }

    public Player playGame(){

        int diceMove1 = (int) (Math.random() * 6) + 1;
        int diceMove2 = (int) (Math.random() * 6) + 1;
        return Repository.getInstance().playGame(diceMove1+diceMove2);

    }

    public boolean shouldGameContinue(){
       return Repository.getInstance().shouldGameContinue();
    }
}
