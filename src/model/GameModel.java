package model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    protected Integer raffled;
    protected Integer actualIndex;
    protected List<Integer> raffleds = new ArrayList<>();
    protected List<Integer> responses = new ArrayList<>();
    protected Integer attempt = 0;

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

    public Integer getRaffled() {
        return this.raffled;
    }
    public Integer getActualIndex() {
        return this.actualIndex;
    }

    public void setRaffled(Integer raffled) {
        this.raffled = raffled;
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
}
