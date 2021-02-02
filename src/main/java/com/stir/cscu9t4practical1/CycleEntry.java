package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry{

    private String terrain;
    private String tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist,
                      String terrain, String tempo) {
        super(n, d, m, y, h, min, s, dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    /**
     * Accessor method for terrain
     * @return - terrain
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * Accessor method for tempo
     * @return - tempo
     */
    public String getTempo() {
        return tempo;
    }

    /**
     *
     * @return - Entry being looked for
     */
    public String getEntry () {
        String result = super.getName()+" cycled " + super.getDistance() + " km in " +super.getHour()+
                ":"+super.getMin()+":"+ super.getSec() + " on " + super.getDay()+ "/"+super.getMonth()+
                "/"+super.getYear()+" on "+getTerrain()+" at "+getTempo()+" tempo\n";
        return result;
    } //getEntry
}
