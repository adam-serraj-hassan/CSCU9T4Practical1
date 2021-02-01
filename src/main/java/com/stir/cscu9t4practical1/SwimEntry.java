package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{

    private String poolOrOutdoors;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist,
                     String poolOrOutdoors) {
        super(n, d, m, y, h, min, s, dist);
        this.poolOrOutdoors = poolOrOutdoors;
    }

    public String getPoolOrOutdoors() {
        return poolOrOutdoors;
    }

    public String getEntry () {
        String result = super.getName()+" swam " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + getPoolOrOutdoors() +
                " on "+super.getDay()+ "/"+super.getMonth()+ "/"+super.getYear()+"\n";
        return result;
    } //getEntry
}
