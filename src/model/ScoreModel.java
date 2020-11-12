package model;

import config.App;

public class ScoreModel extends Model {

    public String player;
    public Integer score;
    public Integer rounds;

    public ScoreModel() {
    }

    @Override
    public void save() {
        String[] aStrings = new String[] { player, score.toString(), rounds.toString() };
        super.save(aStrings, App.dbFile("score.txt"));
    }

}
