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
     * @return - Either an empty result or the entries found
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

    /**
     * Returns all entries corresponding to a given name
     * @param name - Name whose corresponding entries are to be found
     * @return - Entries found
     */
    public String findAllByName(String name) {
        String result = "";
        ListIterator<Entry> entryIterator = tr.listIterator();
        while (entryIterator.hasNext()) {
            Entry current = entryIterator.next();
            if (current.getName().equals(name))
                result += current.getEntry() + "";
        }

        ListIterator<SprintEntry> sprintIterator = sprintEntryList.listIterator();
        while (sprintIterator.hasNext()) {
            SprintEntry current = sprintIterator.next();
            if (current.getName().equals(name))
                result += current.getEntry() + "";
        }

        ListIterator<CycleEntry> cycleIterator = cycleEntryList.listIterator();
        while (cycleIterator.hasNext()) {
            Entry current = cycleIterator.next();
            if (current.getName().equals(name))
                result += current.getEntry() + "";
        }
        ListIterator<SwimEntry> swimIterator = swimEntryList.listIterator();
        while (swimIterator.hasNext()) {
            SwimEntry current = swimIterator.next();
            if (current.getName().equals(name))
                result += current.getEntry() + "";
        }
        return result;
    }

    /**
     * Removes an Entry corresponding to a specific name, day, month, and year
     * @param name - Name of athlete
     * @param d - Day of entry
     * @param m - Month of entry
     * @param y - Year of entry
     * @return - A String stating where the Entry was removed or not
     */
    public String remove(String name, int d, int m, int y) {
        ListIterator<Entry> entryIterator = tr.listIterator();
        while (entryIterator.hasNext()) {
            Entry current = entryIterator.next();
            if (current.getName().equals(name) && current.getDay()==d &&
                    current.getMonth()==m && current.getYear()==y) {
                tr.remove(current);
                return "Entry removed!";
            }
        }
        return "Entry was not found, so it couldn't be removed!";
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