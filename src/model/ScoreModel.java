package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import config.App;

public class ScoreModel extends Model {

    public String player;
    public Integer rounds;

    public ScoreModel() {
    }

    @Override
    public void save() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
        
        String[] aStrings = new String[] { player, rounds.toString(), sfd.format(date)};
        super.save(aStrings, App.dbFile("score.txt"));
    }

}
