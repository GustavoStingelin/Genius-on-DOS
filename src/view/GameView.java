package view;

import java.util.Scanner;

import controller.GameController;
import helpers.Color;
import view.components.Header;

public class GameView {
    
    public static void make(GameController gc) {
        Header.make();
        System.out.print("\n");
        System.out.println( Color.RED + "              ************" + Color.GREEN + "      ************              ");
        System.out.println( Color.RED + "              ************" + Color.GREEN + "      ************              ");
        System.out.println( Color.RED + "              ************" + Color.GREEN + "      ************              ");
        System.out.println( Color.RED + "              ************" + Color.GREEN + "      ************              ");
        System.out.print("\n\n");
        System.out.println( Color.CYAN + "              ************" + Color.YELLOW + "      ************              ");
        System.out.println( Color.CYAN + "              ************" + Color.YELLOW + "      ************              ");
        System.out.println( Color.CYAN + "              ************" + Color.YELLOW + "      ************              ");
        System.out.println( Color.CYAN + "              ************" + Color.YELLOW + "      ************              ");
        System.out.print(Color.RESET);

        System.out.println("\n");
        System.out.println("**********************************************************");
        System.out.println("*          Precione <Enter> para iniciar o jogo          *");
        System.out.println("**********************************************************");

        Scanner kb = new Scanner(System.in);
        kb.nextLine();
        gc.nextColor();
        
    }

    public static void showColor(Integer color, Integer miliseconds, GameController gc) {
        Header.make();
        System.out.print("\n");
        if (color == 1) {
            System.out.println( Color.RED + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RED + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RED + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RED + "              ************" + Color.RESET + "      ************              ");
            System.out.print("\n\n");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        }
        else if (color == 2) {
            System.out.println( Color.RESET + "              ************" + Color.GREEN + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.GREEN + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.GREEN + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.GREEN + "      ************              ");
            System.out.print("\n\n");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        }
        else if (color == 3) {
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.print("\n\n");
            System.out.println( Color.CYAN + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.CYAN + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.CYAN + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.CYAN + "              ************" + Color.RESET + "      ************              ");
        }
        else if (color == 4) {
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
            System.out.print("\n\n");
            System.out.println( Color.RESET + "              ************" + Color.YELLOW + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.YELLOW + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.YELLOW + "      ************              ");
            System.out.println( Color.RESET + "              ************" + Color.YELLOW + "      ************              ");
            System.out.print( Color.RESET);
        }
        
        try {
            Thread.currentThread();
            Thread.sleep(miliseconds);   
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Header.make();
        System.out.print("\n");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        System.out.print("\n\n");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");
        System.out.println( Color.RESET + "              ************" + Color.RESET + "      ************              ");

        try {
            Thread.currentThread();
            Thread.sleep(100);  
            
            gc.nextColor();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}