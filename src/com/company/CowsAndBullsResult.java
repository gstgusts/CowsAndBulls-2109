package com.company;

public class CowsAndBullsResult {
    private int number;
    private int bulls;
    private int cows;

    public CowsAndBullsResult(int number, int bulls, int cows) {
        this.number = number;
        this.bulls = bulls;
        this.cows = cows;
    }


    public int getNumber() {
        return number;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }
}
