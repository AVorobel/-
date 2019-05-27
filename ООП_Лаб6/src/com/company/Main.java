package com.company;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws Exception {

        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        ThreadThree threadThree = new ThreadThree();

        Conteiner conteiner = new Conteiner();
        //Timer timer = new Timer();

        String choice = "";
        while(!choice.equals("exit")) {
            System.out.print("your command:   ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    scanner = new Scanner(System.in);
                    System.out.println("Input string");
                    String add = scanner.nextLine();
                    conteiner.add(add);
                    break;
                case"generate":
                    scanner = new Scanner(System.in);
                    System.out.print("enter number of words you want to add:  ");
                    int number = scanner.nextInt();
                    conteiner.wordnumber=number;
                    conteiner.generate(number);
                    break;
                case"paralel":
                    long startTime = System.currentTimeMillis();
                    threadOne.start();
                    threadTwo.start();
                    threadThree.start();
                    if(conteiner.timeout!=0) {
                        while (true) {
                            long timeSpent = System.currentTimeMillis() - startTime;
                            if (timeSpent >= conteiner.timeout * 1000) {
                                System.out.println("THREADS STOPPED AFTER TIMEOUT");
                                System.exit(0);
                            }
                        }
                    }
                    break;
                case"poslidovno":
                    long startTime2 = System.currentTimeMillis();
                    threadOne.start();
                    threadOne.join();
                    threadTwo.start();
                    threadTwo.join();
                    threadThree.start();
                    threadThree.join();
                    if(conteiner.timeout!=0) {
                        while (true) {
                            long timeSpent = System.currentTimeMillis() - startTime2;
                            if (timeSpent >= conteiner.timeout * 1000) {
                                System.out.println("THREADS STOPPED AFTER TIMEOUT");
                                System.exit(0);
                            }
                        }
                    }
                    break;
                case"timeout":
                    System.out.print("set timeout(seconds):  ");
                    scanner = new Scanner(System.in);
                    conteiner.timeout = scanner.nextInt();
                    break;
            }
        }

    }
}
