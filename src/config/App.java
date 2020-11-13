package config;

public class App {
    public static final String DIR_ROOT = "\\\\localhost\\c$\\genius\\";
    public static final String DIR_DB = DIR_ROOT + "db\\";

    public static String dbFile(String fileName) {
        return App.DIR_DB + fileName;
    }
}
