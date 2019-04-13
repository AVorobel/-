package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FilesWorker f = new FilesWorker();
        String time="";

        while(time!="exit"){
            System.out.print("your command:");
            time = scanner.nextLine();
            switch (time){
                case "open":
                    Scanner sacn = new Scanner(System.in);
                    System.out.print("File name:");
                    String s = sacn.nextLine();
                    f.MoveForvard(s);
                    break;
                case "exit":
                    return;
                case "back":
                    f.MoveBack();
                    break;
                case"write":
                    Scanner scan = new Scanner(System.in);
                    System.out.print("name of file:");
                    String fname = scan.nextLine();
                    f.Writefile(fname);
                    break;
                case"read":
                    Scanner scn = new Scanner(System.in);
                    System.out.print("name of file:");
                    String fname1 = scn.nextLine();
                    f.ReadFile(fname1);
                    break;
                case"show":
                    f.Show();
                    break;
                case"writexml":
                    Scanner sc = new Scanner(System.in);
                    System.out.print("name of file:");
                    String n = sc.nextLine();
                    f.WriteXML(n);
                    break;
                case"readxml":
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("name of file:");
                    String n1 = sc1.nextLine();
                    f.ReadXML(n1);
                    break;
            }
        }
    }
}
