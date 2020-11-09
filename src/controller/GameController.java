package controller;

import model.GameModel;
import view.GameView;

public class GameController {
    
    public GameModel gameModel = new GameModel();
    
    public GameController() {
    }

    public void init() {
        teste();
        gameModel.setActualIndex(0);
        GameView.make(this);
    }

    public void start() {
        
    }


    public void nextColor() {
        if (gameModel.getActualIndex() < gameModel.getSorteds().size()) {
            gameModel.setActualIndex(gameModel.getActualIndex() + 1);
            GameView.showColor(gameModel.getSorteds().get(gameModel.getActualIndex() - 1), 1500, this);
        }
        else {
            GameView.make(this);
        }
    }


    public void teste() {
        gameModel.addSortedOnSorteds(3);
        gameModel.addSortedOnSorteds(2);
        gameModel.addSortedOnSorteds(4);
        gameModel.addSortedOnSorteds(3);
        gameModel.addSortedOnSorteds(1);
    }

}
