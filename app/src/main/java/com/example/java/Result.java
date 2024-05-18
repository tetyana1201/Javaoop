package com.example.java;

public class Result {
    private String fullname;
    private int correctAnswersCount;
    private double scorePercentage;

    public Result() {

    }

    public Result(int correctAnswersCount, double scorePercentage) {
        this.correctAnswersCount = correctAnswersCount;
        this.scorePercentage = scorePercentage;
    }

    public int getCorrectAnswersCount() {

        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(int correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }

    public double getScorePercentage() {

        return scorePercentage;
    }

    public void setScorePercentage(double scorePercentage) {
        this.scorePercentage = scorePercentage;
    }
}
