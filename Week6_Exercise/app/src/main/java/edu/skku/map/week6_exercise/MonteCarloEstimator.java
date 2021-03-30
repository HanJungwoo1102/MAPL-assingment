package edu.skku.map.week6_exercise;

import android.util.Log;

public class MonteCarloEstimator {
    private int totalPointCount;
    private int inCirclePointCount;

    MonteCarloEstimator() {
        totalPointCount = 0;
        inCirclePointCount = 0;
    }

    public void estimate() {
        double x = Math.random();
        double y = Math.random();

        if (x*x + y*y <= 1) {
            inCirclePointCount += 1;
        }

        totalPointCount += 1;


    }

    public double getResult() {
        return ((double) inCirclePointCount / (double) totalPointCount) * 4;
    }
}
