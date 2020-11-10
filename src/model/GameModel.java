package model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    protected Integer raffled;
    protected Integer actualIndex;
    protected List<Integer> raffleds = new ArrayList<>();
    protected List<Integer> responses = new ArrayList<>();

    public GameModel() {

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

}
