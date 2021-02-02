// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    private List<SprintEntry> sprintEntryList;
    private List<CycleEntry> cycleEntryList;
    private List<SwimEntry> swimEntryList;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
        sprintEntryList = new ArrayList<>();
        cycleEntryList = new ArrayList<>();
        swimEntryList = new ArrayList<>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass

    /**
     * Adds a sprint entry to sprintEntryList
     * @param sprintEntry - Sprint entry to add
     */
   public void addSprintEntry(SprintEntry sprintEntry) {
        sprintEntryList.add(sprintEntry);
   }

    /**
     * Adds a cycle entry to cycleEntryList
     * @param cycleEntry - Cycle entry to add
     */
   public void addCycleEntry(CycleEntry cycleEntry) {
       cycleEntryList.add(cycleEntry);
   }

    /**
     * Adds a swim entry to swimEntryList
     * @param swimEntry - Swim entry to add
     */
   public void addSwimEntry(SwimEntry swimEntry) {
       swimEntryList.add(swimEntry);
   }
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry

    /**
     * Modified method to return all entries on a given date
     * @param d
     * @param m
     * @param y
     * @return - Either an empty result or the entry found
     */
    public String newLookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                // appends new entry to existing string
                result += current.getEntry() + "";
        }
        return result;
    } // newLookupEntry

    /**
     * Checks if a record already exists based on the name, day, month, and year entries
     * @param n
     * @param d
     * @param m
     * @param y
     * @return - Whether the same record has been found or not
     */
    public boolean checkUniqueness(String n, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        boolean recordFound = false;
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                recordFound = true;
            break;
        }
        return recordFound;
    }
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord