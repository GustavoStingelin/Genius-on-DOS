package view;

import java.util.List;
import java.util.Scanner;

import config.App;
import controller.HomeController;
import controller.ReportController;
import model.ScoreModel;
import view.components.Header;

public interface ReportView {
    
    public static void make() {
        Header.make();
        System.out.println("  1 -> Sequência mais longa");
        System.out.println("  2 -> Melhores 5 jogadores por nível");
        System.out.println("  3 -> Melhores 5 jogadores por mês");
        System.out.println("  4 -> Melhores 5 jogadores por semana");
        System.out.print("  Escolha: ");
        Scanner kb = new Scanner(System.in);
        try {
            int response = Integer.parseInt(kb.nextLine());
            if (response == 1) {
                new ReportController().longestPlay();
            }
            else if (response == 2) {
                new ReportController().betterPlayersByLevel();
            }
            else if (response == 3) {
                new ReportController().betterPlayersByMonth();
            }
            else if (response == 4) {
                new ReportController().betterPlayersByWeek();
            }
            else {
                make();
            }
            kb.close();
        } catch (Exception e) {
            make();
        }
    }

    public static void betterPlayersByLevel(List<ScoreModel> scoreList) {
        Header.make();
        System.out.println("|Data         |Lvl. |Pts. |Jogador");
        int cont = 0;
        for (ScoreModel scoreModel : scoreList) {
            if (cont != scoreModel.getLevel()) {
                System.out.println("----------------------------------------------------------");
            }
            cont = scoreModel.getLevel();
            System.out.println(scoreModel);
        }

        Scanner kb = new Scanner(System.in);
        kb.nextLine();
        new HomeController().init();
        kb.close();
    }

    
    public static void betterPlayersByMonth(List<ScoreModel> scoreList) {
        Header.make();
        System.out.println("|Data         |Lvl. |Pts. |Jogador");
        int cont = 0;
        for (ScoreModel scoreModel : scoreList) {
            if (cont != scoreModel.getMonth()) {
                System.out.println("----------------------------------------------------------");
            }
            cont = scoreModel.getMonth();
            System.out.println(scoreModel);
        }

        Scanner kb = new Scanner(System.in);
        kb.nextLine();
        new HomeController().init();
        kb.close();
    }
    
    public static void betterPlayersByWeek(List<ScoreModel> scoreList) {
        Header.make();
        System.out.println("|Data         |Lvl. |Pts. |Jogador");
        int cont = 0;
        for (ScoreModel scoreModel : scoreList) {
            if (cont != scoreModel.getWeek()) {
                System.out.println("----------------------------------------------------------");
            }
            cont = scoreModel.getWeek();
            System.out.println(scoreModel);
        }

        Scanner kb = new Scanner(System.in);
        kb.nextLine();
        new HomeController().init();
        kb.close();
    }

    public static void longestPlay(ScoreModel score) {
        for (Integer response : score.getResponses()) {
            GameView.showColor(
                response, 
                App.milOfLevel(
                    score.getLevel()
                )
            );
        }
        Header.make();
        System.out.println("|Data         |Lvl. |Pts. |Jogador");
        System.out.println(score);
        Scanner kb = new Scanner(System.in);
        kb.nextLine();
        new HomeController().init();
        kb.close();
    }
}
