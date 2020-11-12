package controller;

import java.util.Random;
import java.util.Scanner;

import model.GameModel;
import model.ScoreModel;
import view.GameView;

public class GameController {
    
    public GameModel gameModel = new GameModel();
    
    public GameController() {
    }

    public void init() {
        gameModel.dumpResponses();
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
            for (Integer raffled : gameModel.getRaffleds()) {
                int response = takeResponse();
                if (response == raffled.intValue()) {
                    gameModel.addResponseOnResponses(response);
                }
                else {
                    GameView.gameOver(this);
                }
            }
            System.out.println("Acertou!! Precione <Enter> para o próximo nível");
            Scanner kb = new Scanner(System.in);
            kb.nextLine();
            gameModel.dumpResponses();
            nextLevel();
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

    public void saveScore(String player, int score, int rounds) {
        ScoreModel scoreModel = new ScoreModel();
        scoreModel.player = player;
        scoreModel.rounds = rounds;
        scoreModel.score = score;
        scoreModel.save();
    }

}
