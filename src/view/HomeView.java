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
        System.out.println(" 1 ->Novo Jogo ");
        System.out.print(" Esolha: ");
        try {
            HomeController hc = new HomeController();
            Integer escolha = Integer.parseInt(kb.nextLine());
            if (escolha == 1) {
                gc.init();
            }
            else {
                hc.init();
            }
        } catch (Exception e) {
            try {
                HomeController hc = new HomeController();
                hc.init();
            } catch (Exception e2) {
                System.err.println(e.getMessage());
            }
        }
        finally {
            kb.close();
        }
    }
}
