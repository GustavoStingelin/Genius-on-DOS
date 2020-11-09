package controller;

import java.io.IOException;
import view.HomeView;

public class HomeController {
    
    public HomeController() {
    }

    public void init() throws InterruptedException, IOException{
        HomeView hv = new HomeView();
        hv.make();
    }

}
