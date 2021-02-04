package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry{

    private int repetitions;
    private int recovery; // represents recovery time between each repetition

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist,
                       int repetitions, int recovery) {
        super(n, d, m, y, h, min, s, dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }

    /**
     * Accessor method for repetitions
     * @return - repetitions
     */
    public int getRepetitions() {
        return repetitions;
    }

    /**
     * Accessor method for recovery
     * @return - recovery
     */
    public int getRecovery() {
        return recovery;
    }

    /**
     *
     * @return - Entry being looked for
     */
    public String getEntry () {
        String result = super.getName()+" sprinted " + getRepetitions() + "x" +
                super.getDistance() + "m in "+super.getHour()+ ":"+super.getMin()+
                ":"+ super.getSec()+ " with " +getRecovery() + " minutes recovery on "+
                super.getDay()+"/"+super.getMonth()+"/"+super.getYear()+"\n";
        return result;
    } //getEntry

}
