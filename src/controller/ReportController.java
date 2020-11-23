package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.ScoreModel;
import view.ReportView;

public class ReportController implements ReportView {

    public void init() {
        ReportView.make();
    }

    public void betterPlayersByLevel() {
        List<ScoreModel> scoreList = new ScoreModel().load();
        scoreList.sort(Comparator.comparing(ScoreModel::getDate).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getRounds).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getLevel).reversed());

        List<Integer> levels = new ArrayList<>();
        for (ScoreModel score : scoreList) {
            levels.add(score.getLevel());
        }
        levels = levels.stream().distinct().collect(Collectors.toList());

        List<ScoreModel> newScoreList = new ArrayList<>();
        for (Integer integer : levels) {
            List<ScoreModel> scoreLevel = scoreList.stream().filter(s -> s.level == integer).limit(5).collect(Collectors.toList());
            newScoreList.addAll(scoreLevel);
        }
        ReportView.betterPlayersByLevel(newScoreList);
    }

    public void betterPlayersByMonth() {
        Calendar cal = Calendar.getInstance();
        List<ScoreModel> scoreList = new ScoreModel().load();
        scoreList.sort(Comparator.comparing(ScoreModel::getDate).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getRounds).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getLevel).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getMonth).reversed());
        
        List<Integer> months = new ArrayList<>();
        for (ScoreModel score : scoreList) {
            cal.setTime(score.getDate());
            months.add(cal.get(Calendar.MONTH));
        }
        months = months.stream().distinct().collect(Collectors.toList());

        List<ScoreModel> newScoreList = new ArrayList<>();
        for (Integer integer : months) {
            List<ScoreModel> scoreMonth = scoreList.stream().filter(s -> s.getMonth() == integer).limit(5).collect(Collectors.toList());
            newScoreList.addAll(scoreMonth);
        }

        ReportView.betterPlayersByMonth(newScoreList);
    }

    public void betterPlayersByWeek() {
        Calendar cal = Calendar.getInstance();
        List<ScoreModel> scoreList = new ScoreModel().load();
        scoreList.sort(Comparator.comparing(ScoreModel::getDate).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getRounds).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getLevel).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getWeek).reversed());
        
        List<Integer> weeks = new ArrayList<>();
        for (ScoreModel score : scoreList) {
            cal.setTime(score.getDate());
            weeks.add(cal.get(Calendar.WEEK_OF_YEAR));
        }
        weeks = weeks.stream().distinct().collect(Collectors.toList());

        List<ScoreModel> newScoreList = new ArrayList<>();
        for (Integer integer : weeks) {
            List<ScoreModel> scoreWeek = scoreList.stream().filter(s -> s.getWeek() == integer).limit(5).collect(Collectors.toList());
            newScoreList.addAll(scoreWeek);
        }
        ReportView.betterPlayersByWeek(newScoreList);
    }

    public void longestPlay() {
        List<ScoreModel> scoreList = new ScoreModel().load();
        scoreList.sort(Comparator.comparing(ScoreModel::getDate).reversed());
        scoreList.sort(Comparator.comparing(ScoreModel::getRounds).reversed());
        ScoreModel betterScore = scoreList.get(0);

        ReportView.longestPlay(betterScore);
    }

}
