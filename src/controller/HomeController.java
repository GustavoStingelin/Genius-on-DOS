package controller;

import view.HomeView;

public class HomeController implements HomeView {
    
    public HomeController() {
    }

    public void init() {
        HomeView.make();
    }

}
