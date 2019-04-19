package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FilesWorker {
    public String path = "C:\\";

    protected TradePoint shop = new TradePoint();
    protected ArrayList base = new ArrayList();

    public void MoveForvard(String fpath){
        path += fpath + "\\";
        File dir = new File(path);
        File[] inside = dir.listFiles();
        if (dir.exists()) {
            for (File i : inside)
                System.out.println(i);
        }
        else
            System.out.println("no such directory");
    }

    public void MoveBack(){
        File dir = new File(path);
        String parent = dir.getParent();
        path = parent;
        File pardir = new File(path);
        if(pardir.exists()) {
            File[] inside = pardir.listFiles();
            for (File i : inside)
                System.out.println(i);
        }else{
            System.out.println("you're in the root");
        }
    }

  /*  public void Writefile(String fileName){
        Scanner sc = new Scanner(System.in);
        try(FileWriter writer = new FileWriter(fileName)){
            String m="";
            while(!m.equals("done")) {
                m = sc.nextLine();
                switch (m) {
                    case "+":
                        System.out.print("Name:");
                        shop.setName(sc.nextLine()+"\n");
                        base.add(shop.getName());
                        System.out.print("Adress:");
                        shop.setAdress(sc.nextLine()+"\n");
                        base.add(shop.getAdress());
                        System.out.print("Specialization:");
                        shop.setSpecialization(sc.nextLine()+"\n");
                        base.add(shop.getSpecialization());
                        System.out.print("Work time:");
                        shop.setWorkTime(sc.nextLine()+"\n");
                        base.add(shop.getWorkTime());
                        System.out.print("Number:");

                        String n = "";
                        while (!n.equals("!number")) {
                            n = sc.nextLine();
                            switch (n) {
                                case "+number":
                                    shop.setNumbers(sc.nextLine()+"\n");
                                    base.add(shop.getNumbers());
                                    break;
                            }
                        }

                        for (int i = 0; i < base.size(); i++) {
                            String str = (String) base.get(i);
                            writer.write(str);
                        }
                        writer.flush();
                        writer.close();
                        break;
                }
            }
            System.out.println("writed");
        }catch (IOException e){
            System.out.println("can not write a file");
        }
    }*/

    public void ReadFile(String fileName){
        try(FileReader reader = new FileReader(fileName)){
            Scanner read = new Scanner(reader);
            while(read.hasNextLine()){
                System.out.println(read.nextLine());
            }
        }catch (IOException e){
            System.out.println("can not read a file");
        }
    }

    public void Show() {
        File dir = new File(path);
        if (dir.exists()) {
            File[] inside = dir.listFiles();
            for (File i : inside)
                System.out.println(i);
        }
    }


    public void WriteXML(String filename){
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            Scanner sc = new Scanner(System.in);
            String m = "";
            while (!m.equals("done")) {
                m = sc.nextLine();
                switch (m) {
                    case "+":
                        System.out.print("Name:");
                        shop.setName(sc.nextLine()+"\n");

                        System.out.print("Adress:");
                        shop.setAdress(sc.nextLine()+"\n");

                        System.out.print("Specialization:");
                        shop.setSpecialization(sc.nextLine()+"\n");

                        System.out.print("Work time:");
                        shop.setWorkTime(sc.nextLine()+"\n");

                        System.out.print("Number:");

                        String n = "";
                        String[] numbers = new String[0];
                        while (!n.equals("-")) {
                            n = sc.nextLine();
                            switch (n) {
                                case "+":
                                    numbers = Arrays.copyOf(numbers, numbers.length+1);
                                    numbers[numbers.length-1] = sc.nextLine()+"\n";
                                    System.out.println("to add number print '+', if you inputed all numbers - print '-'");
                                    break;
                            }
                        }
                        shop.setNumbers(numbers);
                        encoder.writeObject(shop);
                        encoder.close();
                }
                System.out.println("if you want to add more shops - print '+', else print 'done'");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    public void ReadXML(String filename){
        try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))){
            TradePoint object = (TradePoint) decoder.readObject();
            shop = object;
            System.out.print(shop.getName() + shop.getAdress() + shop.getSpecialization() + shop.getWorkTime());
            for (String i: shop.getNumbers()){
                System.out.print(i);
            }

        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }
}
