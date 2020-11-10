package controller;

import java.util.Random;

import model.GameModel;
import view.GameView;

public class GameController {
    
    public GameModel gameModel = new GameModel();
    
    public GameController() {
    }

    public void init() {
        gameModel.dumpRaffleds();
        gameModel.addRaffledOnRaffleds(raffleColor());
        gameModel.setActualIndex(0);
        GameView.make(this);
    }

    public void nextLevel() {
        gameModel.addRaffledOnRaffleds(raffleColor());
        gameModel.setActualIndex(0);
        GameView.make(this);
    }

    public void nextColor() {
        if (gameModel.getActualIndex() < gameModel.getRaffleds().size()) {
            gameModel.setActualIndex(gameModel.getActualIndex() + 1);
            GameView.showColor(gameModel.getRaffleds().get(gameModel.getActualIndex() - 1), 1500, this);
        }
        else {
            int response = takeResponse();
            if (response == gameModel.getRaffleds().get(gameModel.getActualIndex() - 1)) {
                nextLevel();
            }
            else {
                System.out.println("Errou");
            }
        }
    }

    private int takeResponse() {
        int response = GameView.makeQuestion(this);
        if (response >= 1 && response <= 4) {
            return response;
        }
        else {
            takeResponse();
            return 0;
        }
    }


    public int raffleColor() {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }

}
