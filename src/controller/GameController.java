package controller;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import config.App;
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
        gameModel.dumpAttempt();
        gameModel.addRaffledOnRaffleds(raffleColor());
        gameModel.setActualIndex(0);
        int response;
        do {
            response = GameView.makeLevel(this);
        } while (response < 1 || response > 4);
        gameModel.setLevel(response);

        GameView.make(this);
    }

    public void continueGame() {
        List<GameModel> listGame = gameModel.load();
        gameModel.setLevel(listGame.get(listGame.size()-1).getLevel());
        gameModel.setRaffleds(listGame.get(listGame.size()-1).getRaffleds());
        gameModel.truncate();
        gameModel.dumpResponses();
        gameModel.dumpAttempt();
        gameModel.setActualIndex(0);
        GameView.make(this);
    }

    public void nextLevel() {
        gameModel.addRaffledOnRaffleds(raffleColor());
        gameModel.dumpAttempt();
        gameModel.setActualIndex(0);
        GameView.make(this);
    }

    public void nextColor() {
        if (gameModel.getActualIndex() < gameModel.getRaffleds().size()) {
            gameModel.setActualIndex(gameModel.getActualIndex() + 1);
            GameView.showColor(
                gameModel.getRaffleds().get(
                    gameModel.getActualIndex() - 1
                ),
                App.milOfLevel(
                    gameModel.getLevel()
                ),
                this
            );
        }
        else {
            for (Integer raffled : gameModel.getRaffleds()) {
                int response;
                do {
                    response = takeResponse();
                } while (response <= 0);

                if (response == raffled.intValue()) {
                    gameModel.addResponseOnResponses(response);
                }
                else {
                    System.out.println("res: " + response + " - raf: " + raffled.intValue());
                    Scanner kb = new Scanner(System.in);
                    kb.nextLine();
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
        try {
            int response = GameView.makeQuestion(this);
            if (response >= 1 && response <= 4) {
                gameModel.tryAttempt();
                return response;
            }
            else if (response == 9) {
                gameModel.save();
                new HomeController().init();
                return -3;
            }
            else if (response == 0 && gameModel.haveAttempt()) {
                gameModel.tryAttempt();
                gameModel.setActualIndex(0);
                gameModel.dumpResponses();
                nextColor();
                return -1;
            }
            else {
                return -2;
            }
        } catch (Exception e) {
            return -99;
        }
    }

    public int raffleColor() {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }

    public void saveScore(String player, int rounds) {
        ScoreModel scoreModel = new ScoreModel();
        scoreModel.player = player;
        scoreModel.rounds = rounds;
        scoreModel.responses =  gameModel.getRaffleds().subList(
            0,
            gameModel.getRaffleds().size() - 1
        );
        scoreModel.save();
    }

}
