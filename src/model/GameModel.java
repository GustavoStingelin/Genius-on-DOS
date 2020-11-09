package model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    protected Integer sorted;
    protected Integer actualIndex;
    protected List<Integer> sorteds = new ArrayList<>();

    public GameModel() {

    }

    public Integer getSorted() {
        return this.sorted;
    }
    public Integer getActualIndex() {
        return this.actualIndex;
    }

    public void setSorted(Integer sorted) {
        this.sorted = sorted;
    }
    public void setActualIndex(Integer actualIndex) {
        this.actualIndex = actualIndex;
    }

    public List<Integer> getSorteds() {
        return this.sorteds;
    }

    public void setSorteds(List<Integer> sorteds) {
        this.sorteds = sorteds;
    }

    public void addSortedOnSorteds(Integer sorted) {
        sorteds.add(sorted);
    }

}
