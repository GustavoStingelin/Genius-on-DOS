package view;

import java.util.Scanner;
import controller.GameController;
import controller.HomeController;
import controller.ReportController;
import view.components.Header;

public interface HomeView {

    public static void make() {
        Header.make();

        Scanner kb = new Scanner(System.in);
        System.out.println(" 1 ->Novo Jogo, 2 ->Carregar jogo salvo, 3 ->Relatórios");
        System.out.print(" Esolha: ");
        try {
            Integer escolha = Integer.parseInt(kb.nextLine());
            if (escolha == 1) {
                new GameController().init();
            }
            else if (escolha == 2) {
                new GameController().continueGame();
            }
            else if (escolha == 3) {
                new ReportController().init();
            }
            else {
                new HomeController().init();
            }
        } catch (Exception e) {
            System.err.println(e);
            kb.nextLine();

            try {
                new HomeController().init();
            } catch (Exception e2) {
                System.err.println(e.getMessage() + e2.getMessage());
            }
        }
        finally {
            kb.close();
        }
    }
}
