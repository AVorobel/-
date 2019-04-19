package com.company;

public class TradePoint {

    public String specialization;
    public String name;
    public String adress;
    public String[] numbers;
    public String WorkTime;

    public String[] getNumbers() { return numbers; }
    public void setNumbers(String[] numbers) { this.numbers = numbers; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }


    public String getWorkTime() { return WorkTime; }
    public void setWorkTime(String workTime) { WorkTime = workTime; }
}
