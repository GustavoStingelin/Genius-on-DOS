package view;

import java.util.Scanner;
import controller.GameController;
import controller.HomeController;
import view.components.Header;

public class HomeView {
    
    public GameController gc = new GameController();

    public void make() {
        Header.make();

        Scanner kb = new Scanner(System.in);
        System.out.println(" 1 ->Novo Jogo, 2 ->Carregar jogo salvo");
        System.out.print(" Esolha: ");
        try {
            HomeController hc = new HomeController();
            Integer escolha = Integer.parseInt(kb.nextLine());
            if (escolha == 1) {
                gc.init();
            }
            else if (escolha == 2) {
                gc.continueGame();
            }
            else {
                hc.init();
            }
        } catch (Exception e) {
            System.err.println(e);
            kb.nextLine();

            try {
                HomeController hc = new HomeController();
                hc.init();
            } catch (Exception e2) {
                System.err.println(e.getMessage() + e2.getMessage());
            }
        }
        finally {
            kb.close();
        }
    }
}
