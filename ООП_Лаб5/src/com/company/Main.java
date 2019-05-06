package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        TradePoint shop = new TradePoint();
        LinkedList<TradePoint> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Patterns zbig = new Patterns();

        if (args.length == 1 && args[0].equals("-auto")){
            System.out.println("AUTOMODE : ON");

            System.out.println("your command:   add");
            System.out.println("Name: Foxtrot");
            shop.setName("Foxtrot" + "\n");

            System.out.println("Adress: V.Velykoho");
            shop.setAdress("V.Velykoho 59" + "\n");

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

            System.out.print("Number: +380682551574\n\n");
            String[] numbers = new String[1];
            numbers[0] = "+380682551574";
            shop.setNumbers(numbers);
            System.out.println("adding");
            list.add(shop);
            System.out.println("your command:   writexml");
            list.WriteXML("newfile.xml", list, 0);
            System.out.println("your command:   clear");
            list.clear();
            System.out.println("your command:   readxml");
            list.ReadXML("newfile.xml");
            System.out.println("\nyour command:   tostring");
            System.out.println(list.toString());

            System.out.println("AUTOMODE : OFF");
            return;
        }

        String choice = "";
        while (!choice.equals("exit")){
            System.out.print("your command:   ");

            choice = sc.nextLine();
            switch (choice) {
                case "add": ////////////////////////////////////////////////////////////////////////////////////////////////
                    sc = new Scanner(System.in);
                    String m = "";
                    while (!m.equals("done")) {
                        m = sc.nextLine();
                        switch (m) {
                            case "+":
                                String s = "";
                                System.out.print("Name:");
                                shop.setName(sc.nextLine() + "\n");
                                s = "";
                                while(0!=1){
                                    System.out.print("Adress:");
                                    s = sc.nextLine()+"\n";
                                    shop.setAdress(s);
                                    if(zbig.confirmed(s,shop.getAdress())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                while(0!=1){
                                    System.out.print("Specialization:");
                                    s = sc.nextLine()+"\n";
                                    shop.setSpecialization(s );
                                    if(zbig.confirmed(s,shop.getSpecialization())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                System.out.print("Work time:");
                                System.out.println("Enter work time");

                                while(0!=1 ){
                                    System.out.println("monday");
                                    sc = new Scanner(System.in);
                                    s = sc.nextLine() +" "+ "MONDAY"+"\n";
                                    shop.time.setMONDAY(s);
                                    if(zbig.confirmed(s,shop.time.getMONDAY())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                while(0!=1){
                                    System.out.println("tuesday");
                                    sc = new Scanner(System.in);
                                    s = sc.nextLine() + " " + "TUESDAY"+"\n";
                                    shop.time.setTUESDAY(s);
                                    if(zbig.confirmed(s,shop.time.getTUESDAY())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                while(0!=1){
                                    System.out.println("wednesday");
                                    sc = new Scanner(System.in);
                                    s = sc.nextLine()+ " " + "WEDNESDAY"+"\n";
                                    shop.time.setWEDNESDAY(s );
                                    if(zbig.confirmed(s,shop.time.getWEDNESDAY())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                while(0!=1){
                                    System.out.println("thursday");
                                    sc = new Scanner(System.in);
                                    s = sc.nextLine()+ " " + "THURSDAY"+"\n";
                                    shop.time.setTHURSDAY(s );
                                    if(zbig.confirmed(s,shop.time.getTHURSDAY())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                while(0!=1){
                                    System.out.println("friday");
                                    sc = new Scanner(System.in);
                                    s = sc.nextLine() + " "+"FRIDAY"+"\n";
                                    shop.time.setFRIDAY(s);
                                    if(zbig.confirmed(s,shop.time.getFRIDAY())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                while(0!=1){
                                    System.out.println("saturday");
                                    sc = new Scanner(System.in);
                                    s = sc.nextLine() + " " +"SATURDAY"+"\n";
                                    shop.time.setSATURDAY(s );
                                    if(zbig.confirmed(s,shop.time.getSATURDAY())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                s = "";
                                while(0!=1){
                                    System.out.println("sunday");
                                    sc = new Scanner(System.in);
                                    s = sc.nextLine() + " " + "SUNDAY"+"\n";
                                    shop.time.setSUNDAY(s);
                                    if(zbig.confirmed(s,shop.time.getSUNDAY())) {
                                        break;
                                    }
                                    else
                                        System.out.println("неправильний фромат даних. попробуйте ще раз");
                                }
                                shop.setWorkTime(shop.time);
                                s = "";
                                Pattern pattern = Pattern.compile("\\+(380)+[0-9]{9}");
                                System.out.print("Number:");

                                String n = "";
                                String[] numbers = new String[0];
                                while (!n.equals("-")) {
                                    n = sc.nextLine();
                                    switch (n) {
                                        case "+":
                                            numbers = Arrays.copyOf(numbers, numbers.length + 1);
                                            while(!zbig.matchData(s, pattern)){
                                                s=sc.nextLine();
                                                if(zbig.matchData(s,pattern)){
                                                    numbers[numbers.length - 1] = s + "\n";
                                                    break;
                                                }else
                                                    System.out.println("неправильний фромат даних. попробуйте ще раз");
                                            }

                                            System.out.println("to add number print '+', if you inputed all numbers - print '-'");
                                            break;
                                    }
                                }
                                shop.setNumbers(numbers);
                                list.add(shop);
                        }
                    }
                    break;
                case "remove"://////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.print("index of element:");
                    sc = new Scanner(System.in);
                    int i = sc.nextInt();
                    list.remove(i);
                    break;
                case "clear":///////////////////////////////////////////////////////////////////////////////////////////////
                    list.clear();
                    break;
                case "toarray"://///////////////////////////////////////////////////////////////////////////////////////////
                    list.toArray();
                    break;
                case "tostring":////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.println(list.toString());
                    break;
                case "contains":////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.print("index of element:");
                    sc = new Scanner(System.in);
                    int ii = sc.nextInt();
                    try{
                        System.out.println("founded: "+list.get(ii));
                    }catch (NullPointerException e){
                        System.out.println("no such element");
                    }
                    break;
                case "writexml":////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.print("filename: ");
                    sc = new Scanner(System.in);
                    String nameTOwrite = sc.nextLine();
                    Pattern pattern = Pattern.compile("[a-z]{1,}\\.(xml)");
                    if(zbig.matchData(nameTOwrite, pattern)) {
                        System.out.print("index of object: ");
                        int number = sc.nextInt();
                        list.WriteXML(nameTOwrite, list, number);
                    }else
                        System.out.println("неправильно введено, попробуйте ще раз");
                    break;
                case "readxml"://///////////////////////////////////////////////////////////////////////////////////////////
                    System.out.print("filename: ");
                    sc = new Scanner(System.in);
                    pattern = Pattern.compile("[a-z]{1,}\\.(xml)");
                    String nameTOread = sc.nextLine();
                    if(zbig.matchData(nameTOread, pattern))
                        list.ReadXML(nameTOread);
                    else
                        System.out.println("неправильно введено, попробуйте ще раз");
                    break;
                case "write":///////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.print("filename: ");
                    sc = new Scanner(System.in);
                    pattern = Pattern.compile("[a-z]{1,}\\.((txt)|(out))");
                    String name2write = sc.nextLine();
                    if(zbig.matchData(name2write, pattern)) {
                        System.out.print("index of object: ");
                        int num = sc.nextInt();
                        list.Writefile(name2write, list, num);
                    }else
                        System.out.println("неправильно введено, попробуйте ще раз");
                    break;
                case "read":////////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.print("filename: ");
                    pattern = Pattern.compile("[a-z]{1,}\\.((txt)|(out))");
                    sc = new Scanner(System.in);
                    String name2read = sc.nextLine();
                    if(zbig.matchData(name2read, pattern))
                        list.Readfile(name2read);
                    else
                        System.out.println("неправильно введено, попробуйте ще раз");
                    break;
            }
        }
    }
}