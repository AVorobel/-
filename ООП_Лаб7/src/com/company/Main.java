package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TipaContainer container = new TipaContainer();

        if (args.length == 1 && args[0].equals("-auto")){
            System.out.println("AUTOMODE : ON");
            TradePoint shop = new TradePoint();

            System.out.println("your command:   add");
            System.out.println("Name: Foxtrot");
            shop.setName("Foxtrot" + "\n");

            System.out.println("Adress: V.Velykoho");
            shop.setAdress("V.Velykoho" + "\n");

            System.out.println("Specialization: electronics");
            shop.setSpecialization("electronics" + "\n");

            System.out.print("Work time:");
            System.out.println("Enter work time");
            System.out.println("monday\n10:00-22:00");
            shop.time.setMONDAY("10:00-22:00" + " " );
            System.out.println("tuesday\n10:00-22:00");
            shop.time.setTUESDAY("10:00-22:00" + " ");
            System.out.println("wednesday\n10:00-22:00");
            shop.time.setWEDNESDAY("10:00-22:00" + " " );
            System.out.println("thursday\n10:00-22:00");
            shop.time.setTHURSDAY("10:00-22:00" + " ");
            System.out.println("friday\n10:00-22:00");
            shop.time.setFRIDAY("10:00-22:00" + " " );
            System.out.println("saturday\n10:00-20:00");
            shop.time.setSATURDAY("10:00-20:00" + " " );
            System.out.println("sunday\n10:00-20:00");
            shop.time.setSUNDAY("10:00-20:00" + " " );

            shop.setWorkTime(shop.time);

            System.out.print("Number: +380154822544\n\n");
            String[] numbers = new String[1];
            numbers[0] = "+380154822544";
            shop.setNumbers(numbers);
            System.out.println("adding");
            container.add(shop);
            System.out.println("your command:   writexml");
            container.WriteXML("newfile.xml", 0);
            System.out.println("your command:   clear");
            System.out.println("your command:   readxml");
            container.ReadXML("newfile.xml");
            System.out.println("\nyour command:   tostring");
            System.out.println(container.toString());

            System.out.println("AUTOMODE : OFF");
            return;
        }

        String choice = "";
        while (!choice.equals("exit")){
            System.out.print("███ your command:   ");
            choice = sc.nextLine();
            switch (choice) {
                case "add":
                    sc = new Scanner(System.in);
                    String m = "";
                    while (!m.equals("done")) {
                        m = sc.nextLine();
                        switch (m) {
                            case "+":
                                TradePoint shop = new TradePoint();
                                System.out.print("Name:");
                                shop.setName(sc.nextLine() + "\n");

                                System.out.print("Adress:");
                                shop.setAdress(sc.nextLine() + "\n");

                                System.out.print("Specialization:");
                                shop.setSpecialization(sc.nextLine() + "\n");

                                System.out.print("Work time:");
                                System.out.println("Enter work time");
                                System.out.println("monday");
                                shop.time.setMONDAY(sc.nextLine() + " " );
                                System.out.println("tuesday");
                                shop.time.setTUESDAY(sc.nextLine() + " ");
                                System.out.println("wednesday");
                                shop.time.setWEDNESDAY(sc.nextLine() + " " );
                                System.out.println("thursday");
                                shop.time.setTHURSDAY(sc.nextLine() + " ");
                                System.out.println("friday");
                                shop.time.setFRIDAY(sc.nextLine() + " " );
                                System.out.println("saturday");
                                shop.time.setSATURDAY(sc.nextLine() + " " );
                                System.out.println("sunday");
                                shop.time.setSUNDAY(sc.nextLine() + " " );

                                shop.setWorkTime(shop.time);

                                System.out.print("Number:");

                                String n = "";
                                String[] numbers = new String[0];
                                while (!n.equals("-")) {
                                    n = sc.nextLine();
                                    switch (n) {
                                        case "+":
                                            numbers = Arrays.copyOf(numbers, numbers.length + 1);
                                            numbers[numbers.length - 1] = sc.nextLine() + "\n";
                                            System.out.println("to add number print '+', if you inputed all numbers - print '-'");
                                            break;
                                    }
                                }
                                shop.setNumbers(numbers);
                                 container.add(shop);
                        }
                    }
                    break;
                case "remove":
                    System.out.print("index of element:");
                    sc = new Scanner(System.in);
                    int i = sc.nextInt();
                    container.remove(i);
                    break;
                case "get":
                    System.out.print("index of element:");
                    sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    container.get(n);
                    break;
                case "all":
                    container.getALL();
                    break;
                case "sort":
                    container.sort();
                    break;
                case "search":
                    System.out.print("name of shop:");
                    sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    if(container.search(name)>=0)
                        System.out.println("founded by index: "+container.search(name));
                    else
                        System.out.println("no such shop");
                    break;
                case "writexml":
                    System.out.print("filename: ");
                    sc = new Scanner(System.in);
                    String nameTOwrite = sc.nextLine();
                    System.out.print("index of object: ");
                    int number = sc.nextInt();
                    container.WriteXML(nameTOwrite, number);
                    break;
                case "readxml":
                    System.out.print("filename: ");
                    sc = new Scanner(System.in);
                    String nameTOread = sc.nextLine();
                    container.ReadXML(nameTOread);
                    break;
                case "write":
                    System.out.print("filename: ");
                    sc = new Scanner(System.in);
                    String name2write = sc.nextLine();
                    System.out.print("index of object: ");
                    int num = sc.nextInt();
                    container.Writefile(name2write, num);
                    break;
                case "read":
                    System.out.print("filename: ");
                    sc = new Scanner(System.in);
                    String name2read = sc.nextLine();
                    container.Readfile(name2read);
                    break;
            }
        }
    }
}
