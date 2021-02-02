// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel entryTypeLabel = new JLabel("Entry type (Sprint/Cycle/Swim):");
    private JTextField entryTypeField = new JTextField(6);
    private JLabel sprintRepetitionsLabel = new JLabel("Sprint repetitions:");
    private JTextField sprintRepetitionsField = new JTextField(10);
    private JLabel sprintRecoveryLabel = new JLabel("Sprint recovery:");
    private JTextField sprintRecoveryField = new JTextField(10);
    private JLabel cycleTerrainLabel = new JLabel("Cycle terrain:");
    private JTextField cycleTerrainField = new JTextField(10);
    private JLabel cycleTempoLabel = new JLabel("Cycle tempo:");
    private JTextField cycleTempoField = new JTextField(10);
    private JLabel swimWhereLabel = new JLabel("Swim location (pool/outdoors):");
    private JTextField swimWhereField = new JTextField(10);
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("FindAllByDate");
    private JButton findAllByName = new JButton("FindAllByName");
    private JButton removeButton = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(entryTypeLabel);
        add(entryTypeField);
        entryTypeField.setEditable(true);
        add(sprintRepetitionsLabel);
        add(sprintRepetitionsField);
        sprintRepetitionsField.setEditable(true);
        add(sprintRecoveryLabel);
        add(sprintRecoveryField);
        sprintRecoveryField.setEditable(true);
        add(cycleTerrainLabel);
        add(cycleTerrainField);
        cycleTerrainField.setEditable(true);
        add(cycleTempoLabel);
        add(cycleTempoField);
        cycleTempoField.setEditable(true);
        add(swimWhereLabel);
        add(swimWhereField);
        swimWhereField.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(findAllByName);
        findAllByName.addActionListener(this);
        add(removeButton);
        removeButton.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = newLookupEntry();
        }
        if (event.getSource() == findAllByName) {
            message = findAllByName();
        }
        if (event.getSource() == removeButton) {
            message = remove();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "";
        try {
            String n = name.getText();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            String entryType = entryTypeField.getText();

            // check what type of entry has been added
            if (n.isEmpty()) {
                message = "Name can't be empty!";
            } else if(entryType.equals("Sprint")) {
                int sprintRepetitions = Integer.parseInt(sprintRepetitionsField.getText());
                int recovery = Integer.parseInt(sprintRecoveryField.getText());

                SprintEntry sprintEntry = new SprintEntry(n, d, m, y, h, mm, s, km,
                        sprintRepetitions, recovery);
                myAthletes.addSprintEntry(sprintEntry);
                System.out.println("Adding sprint entry to the records");
                message = "Record added\n";

            } else if(entryType.equals("Cycle")) {
                String terrain = cycleTerrainField.getText();
                String tempo = cycleTempoField.getText();

                CycleEntry cycleEntry = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
                myAthletes.addCycleEntry(cycleEntry);
                System.out.println("Adding cycle entry to the records");
                message = "Record added\n";

            } else if(entryType.equals("Swim")) {
                String swimWhere = swimWhereField.getText();

                SwimEntry swimEntry = new SwimEntry(n, d, m, y, h, mm, s, km, swimWhere);
                myAthletes.addSwimEntry(swimEntry);
                System.out.println("Adding swim entry to the records");
                message = "Record added\n";

            } else {
                if(myAthletes.checkUniqueness(n, d, m, y)) {
                    message = "Entry already exists!";
                } else {
                    Entry e = new Entry(n, d, m, y, h, mm, s, km);
                    myAthletes.addEntry(e);
                    System.out.println("Adding " + what + " entry to the records");
                    message = "Record added\n";
                }
            }
        } catch (Exception e) {
            message = "Please enter some reasonable inputs.";
        }
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    /**
     * Calls on helper method in TrainingRecord class to look for entries with given
     * day, month, and year
     * @return - Either an empty result or the entries found
     */
    public String newLookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String message = myAthletes.newLookupEntry(d, m, y);
        return message;
    }

    /**
     * Calls on helper method in TrainingRecord class to look for entries with given
     * name
     * @return - Either an empty result or the entries found
     */
    public String findAllByName() {
        String n = name.getText();
        String message = myAthletes.findAllByName(n);
        return message;
    }

    /**
     * Calls on helper method in TrainingRecord class to remove an Entry corresponding to
     * a specific name, day, month, and year
     * @return
     */
    public String remove() {
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());

        String message = myAthletes.remove(n, m, d, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        entryTypeField.setText("");
        sprintRepetitionsField.setText("");
        sprintRecoveryField.setText("");
        cycleTerrainField.setText("");
        cycleTempoField.setText("");
        swimWhereField.setText("");


    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

