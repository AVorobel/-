package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
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

    public void Writefile(String fileName){
        Scanner sc = new Scanner(System.in);
        try(FileWriter writer = new FileWriter(fileName)){
            String m="";
            while(!m.equals("done")) {
                m = sc.nextLine();
                switch (m) {
                    case "+":
                        System.out.print("Name:");
                        String name = sc.nextLine()+"\n";
                        shop.setName(name);
                        base.add(shop.getName());
                        System.out.print("Adress:");
                        String adress = sc.nextLine()+"\n";
                        shop.setAdress(adress);
                        base.add(shop.getAdress());
                        System.out.print("Specialization:");
                        String spez = sc.nextLine()+"\n";
                        shop.setSpecialization(spez);
                        base.add(shop.getSpecialization());
                        System.out.print("Work time:");
                        String wt = sc.nextLine()+"\n";
                        shop.setWorkTime(wt);
                        base.add(shop.getWorkTime());
                        System.out.print("Number:");

                        String n = "";
                        while (!n.equals("!number")) {
                            n = sc.nextLine();
                            switch (n) {
                                case "+number":
                                    String num = sc.nextLine()+"\n";
                                    shop.setNumbers(num);
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
    }

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
        try(XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(filename)));

        ) {
            Scanner sc = new Scanner(System.in);
            String m = "";
            while (!m.equals("done")) {
                m = sc.nextLine();
                switch (m) {
                    case "+":
                        System.out.print("Name:");
                        String name = sc.nextLine() + "\n";
                        shop.setName(name);
                        base.add(shop.getName());
                        System.out.print("Adress:");
                        String adress = sc.nextLine() + "\n";
                        shop.setAdress(adress);
                        base.add(shop.getAdress());
                        System.out.print("Specialization:");
                        String spez = sc.nextLine() + "\n";
                        shop.setSpecialization(spez);
                        base.add(shop.getSpecialization());
                        System.out.print("Work time:");
                        String wt = sc.nextLine() + "\n";
                        shop.setWorkTime(wt);
                        base.add(shop.getWorkTime());
                        System.out.print("Number:");

                        String n = "";
                        while (!n.equals("!number")) {
                            n = sc.nextLine();
                            switch (n) {
                                case "+number":
                                    String num = sc.nextLine() + "\n";
                                    shop.setNumbers(num);
                                    base.add(shop.getNumbers());
                                    break;
                            }
                        }
                        encoder.writeObject(base);
                        encoder.close();
                        base.clear();
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    public void ReadXML(String filename){
        try(XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream(filename)));
        ){
            Object object = decoder.readObject();
            System.out.print(object);

        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }
}
