package sample;

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
        this.MONDAY = "MON:" + MONDAY +"\n";
    }

    public String getTUESDAY() { return TUESDAY; }
    public void setTUESDAY(String TUESDAY) { this.TUESDAY = "TUE:" +TUESDAY +"\n"; }

    public String getWEDNESDAY() {
        return WEDNESDAY;
    }
    public void setWEDNESDAY(String WEDNESDAY) {
        this.WEDNESDAY ="WED:" + WEDNESDAY + "\n";
    }

    public String getTHURSDAY() {
        return THURSDAY;
    }
    public void setTHURSDAY(String THURSDAY) {
        this.THURSDAY ="THU:" + THURSDAY + "\n";
    }

    public String getFRIDAY() {
        return FRIDAY;
    }
    public void setFRIDAY(String FRIDAY) {
        this.FRIDAY ="FRI:" + FRIDAY+"\n";
    }

    public String getSATURDAY() {
        return SATURDAY;
    }
    public void setSATURDAY(String SATURDAY) {
        this.SATURDAY = "SAT:" +SATURDAY+"\n";
    }

    public String getSUNDAY() {
        return SUNDAY;
    }
    public void setSUNDAY(String SUNDAY) {
        this.SUNDAY = "SUN:" +SUNDAY+"\n";
    }
}
