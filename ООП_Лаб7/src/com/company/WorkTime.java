package com.company;

import java.io.Serializable;

public class WorkTime implements Serializable {

    public String MONDAY;
    public String TUESDAY;
    public String WEDNESDAY;
    public String THURSDAY;
    public String FRIDAY;
    public String SATURDAY;
    public String SUNDAY;

    public String getMONDAY() {
        return MONDAY;
    }
    public void setMONDAY(String MONDAY) {
        this.MONDAY = MONDAY + "MONDAY"+"\n";
    }

    public String getTUESDAY() { return TUESDAY; }
    public void setTUESDAY(String THUESDAY) { this.TUESDAY = THUESDAY + "THUESDAY"+"\n"; }

    public String getWEDNESDAY() {
        return WEDNESDAY;
    }
    public void setWEDNESDAY(String WEDNESDAY) {
        this.WEDNESDAY = WEDNESDAY + "WEDNESDAY"+"\n";
    }

    public String getTHURSDAY() {
        return THURSDAY;
    }
    public void setTHURSDAY(String THURSDAY) {
        this.THURSDAY = THURSDAY + "THURSDAY"+"\n";
    }

    public String getFRIDAY() {
        return FRIDAY;
    }
    public void setFRIDAY(String FRIDAY) {
        this.FRIDAY = FRIDAY+"FRIDAY"+"\n";
    }

    public String getSATURDAY() {
        return SATURDAY;
    }
    public void setSATURDAY(String SATURDAY) {
        this.SATURDAY = SATURDAY+"SATURDAY"+"\n";
    }

    public String getSUNDAY() {
        return SUNDAY;
    }
    public void setSUNDAY(String SUNDAY) {
        this.SUNDAY = SUNDAY+ "SUNDAY"+"\n";
    }
}
