package sample;

import java.io.Serializable;

public class TradePoint implements Serializable {

    WorkTime time = new WorkTime();

    public String specialization;
    public String name;
    public String adress;
    public String[] numbers = new String[0];
    public WorkTime WorkTime;

    public String[] getNumbers() { return numbers; }
    public void setNumbers(String[] numbers) { this.numbers = numbers; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = "NAME:"+name;
    }


    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress ="ADDRESS:"+ adress;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization ="SPEC.:"+ specialization; }


    public WorkTime getWorkTime() { return WorkTime; }
    public void setWorkTime(WorkTime workTime) { WorkTime = workTime; }
}
