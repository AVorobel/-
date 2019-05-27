package com.company;

import java.util.Arrays;
/*слова які мають таку ж кількість символів як і слово в контейнері від індексом 5*/
public class ThreadThree extends Thread {
    Conteiner container = new Conteiner();

    @Override
    public void run(){
        Thread.currentThread().setName("ThreadThree");

        String [] mas = new String[0];
        String slovo = container.get(5);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < container.size(); i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 5)
                continue;
            else if(container.get(i).length() == slovo.length()){
                mas = Arrays.copyOf(mas, mas.length+1);
                mas[mas.length-1] = container.get(i);
            }
        }

        if(mas.length == 0)
            System.out.println("Слово "+container.get(5)+" - єдине яке має "+container.get(5).length()+" символів");
        else {
            System.out.println("Слова з такою ж кількістю символів як і в " + container.get(5));
            for (String s : mas)
                System.out.println(s);
        }

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(Thread.currentThread().getName()+" виконувався "+timeSpent+" мілісекунд");
    }
}
