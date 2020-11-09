import java.io.IOException;
import controller.HomeController;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        HomeController hc = new HomeController();
        hc.init();
    }
}
