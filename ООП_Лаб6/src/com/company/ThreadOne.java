package com.company;

import java.util.Arrays;
/*найдовше і найменше слово */
public class ThreadOne extends Thread {

    protected Conteiner container = new Conteiner();
    int [] sizes = new int[container.size()];

    @Override
    public void run(){

        Thread.currentThread().setName("ThreadOne");
        long startTime = System.currentTimeMillis();
        int max=0, min=0, sum = 0;

        int [] sizes = new int[container.size()];

        for(int i=0; i< container.size(); i++ ){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sizes[i] = container.get(i).length();
            sum += container.get(i).length();
        }

        Arrays.sort(sizes);
        min = sizes[0];
        max = sizes[sizes.length-1];
        for(int i=0; i< container.size(); i++ ){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           if(container.get(i).length() == min)
               System.out.println("Найкоротше слово - "+container.get(i));
           else if(container.get(i).length() == max)
               System.out.println("Найдовше слово - "+container.get(i));
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(Thread.currentThread().getName()+" виконувався "+timeSpent+" мілісекунд");
    }
}
