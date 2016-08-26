package com.example.angad.golfscorecard.model;

public class Hole {
    private int mHoleNumber;
    private int mCount;

    public Hole(int holeNumber, int count){
        mCount=count;
        mHoleNumber=holeNumber;
    }

    public int getHoleNumber() {
        return mHoleNumber;
    }

    public void setHoleNumber(int holeNumber) {
        mHoleNumber = holeNumber;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }
}
