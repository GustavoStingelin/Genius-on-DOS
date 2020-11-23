package view.components;

public interface Header {
    public static void make(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("**********************************************************");
        System.out.println("*                     GENIUS in DOS                      *");
        System.out.println("**********************************************************");
    }
}
