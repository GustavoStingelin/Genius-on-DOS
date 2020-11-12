package config;

public class App {
    public static final String DIR_DB = "\\\\localhost\\c$\\genius\\db\\";

    public static String dbFile(String fileName) {
        return App.DIR_DB + fileName;
    }
}
