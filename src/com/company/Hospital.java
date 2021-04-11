package com.company;

public class Hospital extends Location {
    private Doctor doctor;
    private FirstAidKit firstAidKit;
    private Psychopath psychopath;

    public Hospital(boolean visited, Doctor doctor, FirstAidKit firstAidKit, Psychopath psychopath) {
        super(visited);
        this.doctor = doctor;
        this.firstAidKit = firstAidKit;
        this.psychopath = psychopath;
    }

    public Hospital(boolean visited) {
        super(visited);
    }

    public void takeFirstAidKit() {
        this.firstAidKit = null;
    }
}
