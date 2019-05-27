package com.company;
/*кількість слів ,що містять букву 'g'*/
public class ThreadTwo extends Thread {
    Conteiner container = new Conteiner();

    @Override
    public void run(){
        Thread.currentThread().setName("ThreadTwo");

        long startTime = System.currentTimeMillis();
        char bykwa = 'g';



        int counter=0;
        for (int i = 0; i < container.size(); i++)
            for (int j = 0; j < container.get(i).length(); j++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(container.get(i).charAt(j) == bykwa) {
                    counter++;
                    break;
                }
            }

        if(counter == 0)
            System.out.println("Нема слів з буквою '"+bykwa+"'");
        else
            System.out.println("З буквою '"+bykwa+"' знайдено ["+counter+"] слів/слово");

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(Thread.currentThread().getName()+" виконувався "+timeSpent+" мілісекунд");
    }
}
