package com.company;

import java.io.Serializable;
import java.util.regex.Pattern;

public class WorkTime implements Serializable {

    Patterns match = new Patterns();
    Pattern pattern = Pattern.compile("(([0-1][0-9]+\\:+[0-5][0-9]+\\-+[0-1][0-9]+\\:+[0-5][0-9])+\\ +((MONDAY)|(TUESDAY)|(WEDNESDAY)|(THURSDAY)|(FRIDAY)|(SATURDAY)|(SUNDAY))+(\\n))" +
            "|(([2][0-4]+\\:+[0-5][0-9]+\\-+[2][0-4]+\\:+[0-5][0-9])+\\ +((MONDAY)|(TUESDAY)|(WEDNESDAY)|(THURSDAY)|(FRIDAY)|(SATURDAY)|(SUNDAY))+(\\n))" +
            "|(([0-1][0-9]+\\:+[0-5][0-9]+\\-+[2][0-4]+\\:+[0-5][0-9])+\\ +((MONDAY)|(TUESDAY)|(WEDNESDAY)|(THURSDAY)|(FRIDAY)|(SATURDAY)|(SUNDAY))+(\\n))" +
            "|(([2][0-4]+\\:+[0-5][0-9]+\\-+[0-1][0-9]+\\:+[0-5][0-9])+\\ +((MONDAY)|(TUESDAY)|(WEDNESDAY)|(THURSDAY)|(FRIDAY)|(SATURDAY)|(SUNDAY))+(\\n))");

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
        if(match.matchData(MONDAY, pattern))
            this.MONDAY = MONDAY;
    }

    public String getTUESDAY() { return TUESDAY; }
    public void setTUESDAY(String THUESDAY) {
        if(match.matchData(THUESDAY, pattern))
            this.TUESDAY = THUESDAY;
    }

    public String getWEDNESDAY() {
        return WEDNESDAY;
    }
    public void setWEDNESDAY(String WEDNESDAY) {
        if(match.matchData(WEDNESDAY, pattern))
            this.WEDNESDAY = WEDNESDAY ;
    }

    public String getTHURSDAY() {
        return THURSDAY;
    }
    public void setTHURSDAY(String THURSDAY) {
        if(match.matchData(THURSDAY, pattern))
            this.THURSDAY = THURSDAY;
    }

    public String getFRIDAY() {
        return FRIDAY;
    }
    public void setFRIDAY(String FRIDAY) {
        if(match.matchData(FRIDAY, pattern))
            this.FRIDAY = FRIDAY;
    }

    public String getSATURDAY() {
        return SATURDAY;
    }
    public void setSATURDAY(String SATURDAY) {
        if(match.matchData(SATURDAY, pattern))
            this.SATURDAY = SATURDAY;
    }

    public String getSUNDAY() {
        return SUNDAY;
    }
    public void setSUNDAY(String SUNDAY) {
        if(match.matchData(SUNDAY, pattern))
            this.SUNDAY = SUNDAY;
    }
}
