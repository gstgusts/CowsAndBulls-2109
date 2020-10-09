package com.company;

import java.util.ArrayList;
import java.util.List;

public class CowsAndBulls {
    private static final int RetryMaxCount = 10;
    private Integer numberToGuess;
    private List<CowsAndBullsResult> results = new ArrayList<>();

    public CowsAndBulls() {
        restart();
    }

    public CowsAndBulls(Integer numberToGuess) {
        this.numberToGuess = numberToGuess;
        results.clear();
    }

    public void restart() {
        generateNumber();
        results.clear();
    }

    public boolean isGameOver() {
        return RetryMaxCount == results.size();
    }

    public CowsAndBullsResult guess(Integer number) {

        if(isGameOver()) return null;

        int bulls = 0;
        int cows = 0;

        var numberArray = number.toString().split("");
        var numberToGuessArray = numberToGuess.toString().split("");

        for (int i = 0; i < numberArray.length; i++) {
            if(numberToGuessArray[i].equals(numberArray[i])) {
                ++bulls;
                numberToGuessArray[i] = "";
                continue;
            } else {
                for (int j = 0; j < numberToGuessArray.length; j++) {
                    if(numberToGuessArray[j].equals(numberArray[i])) {
                        ++cows;
                        numberToGuessArray[j] = "";
                        continue;
                    }
                }
            }
        }

//        // add logic to count cows and bulls
//        var enteredNumber = String.valueOf(number);
//        var guessNumber = String.valueOf(numberToGuess);
//        for (int i = 0; i < guessNumber.length(); i++) {
//            char ch = enteredNumber.charAt(i);
//            if (ch == guessNumber.charAt(i)) {
//                bulls++;
//            } else if (guessNumber.contains(String.valueOf(ch))) {
//                cows++;
//            }
//        }

//        int[] arr1 = new int[10];
//        int[] arr2 = new int[10];
//
//        var secret = numberToGuess.toString();
//        var guess = number.toString();
//
//        for (int i = 0; i < secret.length(); i++) {
//            char c1 = secret.charAt(i);
//            char c2 = guess.charAt(i);
//            if (c1 == c2)
//                bulls++;
//            else {
//                arr1[c1 - '0']++;
//                arr2[c2 - '0']++;
//            }
//        }
//        for (int i = 0; i < 10; i++) {
//            cows += Math.min(arr1[i], arr2[i]);
//        }

        var result = new CowsAndBullsResult(number, bulls, cows);

        results.add(result);

        return result;
    }

    private void generateNumber() {
        numberToGuess = getRandomNumber(1000, 9999);
        System.out.println(numberToGuess);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public List<CowsAndBullsResult> getResults() {
        return results;
    }
}
