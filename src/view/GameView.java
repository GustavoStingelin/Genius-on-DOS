package view;

import java.util.Scanner;

import controller.GameController;
import controller.HomeController;
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
        System.out.println("*          Precione <Enter> para iniciar                 *");
        System.out.println("**********************************************************");
        //System.out.println(gc.gameModel.getRaffleds());

        Scanner kb = new Scanner(System.in);
        try {
            kb.nextLine();
            gc.nextColor();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            gc.nextColor();
        } finally {
            kb.close();
        }
        
        
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

    public static int makeQuestion(GameController gc) {
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
        System.out.println(" Digite o código das cores na sequencia apresentada       ");
        System.out.println(" 1 ->Vermelho, 2 ->Verde, 3-> Azul, 4-> Amarelo           ");
        //System.out.println(gc.gameModel.getRaffleds());
        System.out.print("Respostas: " + gc.gameModel.getResponses() + " -> ");

        Scanner kb = new Scanner(System.in);
        try {
            return Integer.parseInt(kb.nextLine());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return -1;
        }
        finally {
            //kb.close();
        }
    }

    public static void gameOver(GameController gc) {
        Header.make();
        System.out.println();
        System.out.println("                       GAME OVER                          ");
        System.out.println("  Rodadas: " + (gc.gameModel.getRaffleds().size() - 1));
        System.out.println("  Score: " + (int)Math.floor((((gc.gameModel.getRaffleds().size() - 1) / 3) * 450)));
        System.out.println("  Sequência correta: " + gc.gameModel.getRaffleds());
        System.out.println("|________________________________________________________|");
        System.out.println();
        System.out.println("  1 ->Jogar Novamente, 2 ->Salvar Recorde");
        System.out.print("  Escolha: ");
        Scanner kb = new Scanner(System.in);
        try {
            int response = Integer.parseInt(kb.nextLine());
            if (response == 1) {
                gc.init();
            }
            else if (response == 2) {
                System.out.println("Digite o nome de jogador para salvar:");
                String player = kb.nextLine();
                gc.saveScore(player, (int)Math.floor((((gc.gameModel.getRaffleds().size() - 1) / 3) * 450)), (gc.gameModel.getRaffleds().size() - 1));
                new HomeController().init();
            }
            else {
                gameOver(gc);
            }
        } catch (Exception e) {
            gameOver(gc);
        } finally {
            kb.close();
        }
    }




}