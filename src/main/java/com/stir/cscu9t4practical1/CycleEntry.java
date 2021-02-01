package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry{

    private String terrain;
    private int tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist,
                      String terrain, int tempo) {
        super(n, d, m, y, h, min, s, dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    public String getTerrain() {
        return terrain;
    }

    public int getTempo() {
        return tempo;
    }

    public String getEntry () {
        String result = super.getName()+" cycled " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " on " + getTerrain() +
                " terrain at a tempo of " + getTempo() + " on "+super.getDay()+ "/"+super.getMonth()+
                "/"+super.getYear()+"\n";
        return result;
    } //getEntry
}
