package com.company.locations;

import com.company.characters.Doctor;
import com.company.enemies.Psychopath;
import com.company.items.Medkit;

public class Hospital extends Location {
    private Doctor doctor;
    private Medkit firstAidKit;
    private Psychopath psychopath;

//    public Hospital(boolean visited, Doctor doctor, FirstAidKit firstAidKit, Psychopath psychopath) {
//        super(visited);
//        this.doctor = doctor;
//        this.firstAidKit = firstAidKit;
//        this.psychopath = psychopath;
//    }
//
//    public Hospital(boolean visited) {
//        super(visited);
//    }
    public Hospital (String name, String description) {
        super(name, description);
    }

    public void takeFirstAidKit() {
        this.firstAidKit = null;
    }
}
