package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import config.App;

public class GameModel extends Model<GameModel>{

    protected Integer actualIndex;
    protected List<Integer> raffleds = new ArrayList<>();
    protected List<Integer> responses = new ArrayList<>();
    protected Integer attempt = 0;
    protected Integer level = 0;

    public GameModel() {

    }

    public boolean haveAttempt() {
        return (attempt > 1) ? false : true;
    }

    public void tryAttempt() {
        attempt += 1;
    }

    public void dumpAttempt() {
        attempt = 0;
    }

    public Integer getActualIndex() {
        return this.actualIndex;
    }

    public void setActualIndex(Integer actualIndex) {
        this.actualIndex = actualIndex;
    }

    public List<Integer> getRaffleds() {
        return this.raffleds;
    }

    public List<Integer> getResponses() {
        return this.responses;
    }

    public void setRaffleds(List<Integer> raffleds) {
        this.raffleds = raffleds;
    }

    public void addRaffledOnRaffleds(Integer raffled) {
        raffleds.add(raffled);
    }

    public void addResponseOnResponses(Integer response) {
        responses.add(response);
    }

    public void dumpRaffleds() {
        raffleds.clear();
    }

    public void dumpResponses() {
        responses.clear();
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public void save() {
        String[] aStrings = new String[] { raffleds.toString(), level.toString()};
        super.save(aStrings, App.dbFile("saveGame.csv"));
    }

    @Override
    public String toString() {
        return "GameModel [actualIndex=" + actualIndex + ", attempt=" + attempt + ", level=" + level + ", raffleds="
                + raffleds + ", responses=" + responses + "]";
    }

    @Override
    public List<GameModel> load() {
        List<String> rawList = super.load(App.dbFile("saveGame.csv"));
        List<GameModel> gameList = new ArrayList<>();
        for (String line : rawList) {
            String[] aLine = line.split(";"); 
            GameModel model = new GameModel(); 
            model.level = Integer.parseInt(aLine[1]);
            model.raffleds = Arrays
                .stream(
                    aLine[0].substring(1, aLine[0].length() - 1)
                    .replace(" ", "")
                    .split(",")
                )
                .map(Integer::parseInt)
                .collect(Collectors.toList()
            );
            gameList.add(model);
        }
        return gameList;
    }

    @Override
    public void truncate() {
        super.truncate(App.dbFile("saveGame.csv"));
    }
}
