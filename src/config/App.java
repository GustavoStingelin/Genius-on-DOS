package config;

public class App {
    public static final String DIR_ROOT = "\\\\localhost\\c$\\genius\\";
    public static final String DIR_DB = DIR_ROOT + "db\\";

    public static final Integer LEVEL_1 = 10000; //milliseconds
    public static final Integer LEVEL_2 = 8000; //milliseconds
    public static final Integer LEVEL_3 = 5000; //milliseconds
    public static final Integer LEVEL_4 = 1500; //milliseconds

    public static String dbFile(String fileName) {
        return App.DIR_DB + fileName;
    }

    public static Integer milOfLevel(Integer level) {
        if (level == 1) return LEVEL_1;
        else if (level == 2) return LEVEL_2;
        else if (level == 3) return LEVEL_3;
        else if (level == 4) return LEVEL_4;
        else return 0;
    }

}
