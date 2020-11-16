package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import config.App;

public class ScoreModel extends Model<ScoreModel> {

    public String player;
    public Integer rounds;
    public List<Integer> responses;

    public ScoreModel() {
    }

    @Override
    public void save() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        
        String[] aStrings = new String[] { player, rounds.toString(), responses.toString(), sfd.format(date)};
        super.save(aStrings, App.dbFile("score.csv"));
    }

    @Override
    public List<ScoreModel> load() {
        return new ArrayList<>();
    }

    @Override
    public void truncate() {
        super.truncate(App.dbFile("score.csv"));
    }
}
