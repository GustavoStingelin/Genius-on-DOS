package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import config.App;

public class ScoreModel extends Model<ScoreModel> {

    public String player;
    public Integer rounds;
    public List<Integer> responses;
    public Date date;
    public Integer level;

    public ScoreModel() {
    }

    public String getPlayer() {
        return this.player;
    }

    public Integer getRounds() {
        return this.rounds;
    }

    public List<Integer> getResponses() {
        return this.responses;
    }

    public Date getDate() {
        return this.date;
    }

    public int getMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate());
        return cal.get(Calendar.MONTH);
    }

    public int getWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate());
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public Integer getLevel() {
        return this.level;
    }

    @Override
    public void save() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

        String[] aStrings = new String[] { 
            player,
            rounds.toString(),
            responses.toString(),
            sfd.format(date),
            level.toString() 
        };
        super.save(aStrings, App.dbFile("score.csv"));
    }

    @Override
    public List<ScoreModel> load() {
        try {
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
            List<String> rawList = super.load(App.dbFile("score.csv"));
            List<ScoreModel> scoreList = new ArrayList<>();
            for (String line : rawList) {
                String[] aLine = line.split(";");
                ScoreModel model = new ScoreModel();

                model.player = aLine[0];
                model.rounds = Integer.parseInt(aLine[1]);
                model.responses = Arrays // [2]
                    .stream(aLine[2].substring(1, aLine[2].length() - 1).replace(" ", "").split(","))
                    .map(Integer::parseInt).collect(Collectors.toList())
                ;
                model.date = sfd.parse(aLine[3]);
                model.level = Integer.parseInt(aLine[4]);

                scoreList.add(model);
            }
            return scoreList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void truncate() {
        super.truncate(App.dbFile("score.csv"));
    }

    @Override
    public String toString() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        return "| " + sfd.format(date) + "  | " + level + "   | " + rounds + "   | " + player;
    }
    
}
