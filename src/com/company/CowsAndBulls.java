package com.company;

import java.util.ArrayList;
import java.util.List;

public class CowsAndBulls {
    private Integer numberToGuess;
    private List<CowsAndBullsResult> results = new ArrayList<>();

    public CowsAndBulls() {
        restart();
    }

    public void restart() {
        generateNumber();
        results.clear();
    }

    public CowsAndBullsResult guess(Integer number) {
        int bulls = 0;
        int cows = 0;

        var numberArray = number.toString().split("");
        var numberToGuessArray = numberToGuess.toString().split("");

        for (int i = 0; i < numberArray.length; i++) {
            if(numberToGuessArray[i].equals(numberArray[i])) {
                ++bulls;
                continue;
            }


        }

        var result = new CowsAndBullsResult(number, bulls, cows);
        return result;
    }

    private void generateNumber() {
        numberToGuess = getRandomNumber(1000, 9999);
        System.out.println(numberToGuess);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
