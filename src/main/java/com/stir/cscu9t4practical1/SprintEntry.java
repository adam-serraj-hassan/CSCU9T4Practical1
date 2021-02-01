package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry{

    private int repetitions;
    private double recoveryTime; // represents recovery time between each repetition

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist,
                       int repetitions, double recoveryTime) {
        super(n, d, m, y, h, min, s, dist);
        this.repetitions = repetitions;
        this.recoveryTime = recoveryTime;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public double getRecoveryTime() {
        return recoveryTime;
    }

    public String getEntry () {
        String result = super.getName()+" did " + getRepetitions() + super.getDistance() +
                " sprints on "+super.getDay()+"/"+super.getMonth()+"/"+super.getYear()+"\n";
        return result;
    } //getEntry

}
