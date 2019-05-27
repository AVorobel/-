package com.company;

import java.io.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Conteiner implements Iterable<String>, Serializable {

    protected static String [] lines = new String [0];
    protected static int pointer = 0;
    public int timeout = 0;
    public int linelength = lines.length;
    public int wordnumber;

    public String get(int i){ return lines[i]; }

    public String toString (){
        String line = new String();
        for (int i = 0; i < lines.length; i++){
            line += lines[i];
        }
        return line;
    }//ok

    void add(String addOne){
        lines = Arrays.copyOf(lines, lines.length +1);
        lines[lines.length-1] = addOne;
    }//ok

    void expressAdd(int i){
        for (int j = 0; j < i; j++) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            lines = Arrays.copyOf(lines, lines.length+1);
            lines[lines.length-1] = s;
        }
    }

    void generate(int i) {
        for (int j = 0; j < i; j++) {
            int n = new Random().nextInt(100);
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

            StringBuilder sb = new StringBuilder(n);
            for (int k = 0; k < n; k++) {
                int index = (int)(AlphaNumericString.length() * Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }
            lines = Arrays.copyOf(lines, lines.length +1);
            lines[lines.length-1] = sb.toString();
        }
    }




    int size(){
        return lines.length;
    }//ok

    boolean contains(String check){
        boolean checked = false;
        for (int i = 0; i < lines.length; i++){
            if (lines[i].equals(check))
                checked = true;
            else
                continue;
        }
        return checked;
    }//ok





    @Override
    public Iterator<String> iterator() {
        return new com.company.Iterator();
    }

    public boolean compare(int a, int b){
        boolean same = false;
        if (lines[a] == lines[b])
            same = true;
        return same;
    }

    public void sort(){
       boolean sorted = false;

       while (!sorted){
        for(int i = 0; i< lines.length-1; i++){

            if (lines[i].charAt(0) == lines[i+1].charAt(0))
                continue;
            else{
                    char left = lines[i].charAt(0);
                    char right = lines[i+1].charAt(0);
                    if (left < right)
                        continue;
                    else {
                        String buffer = lines[i];
                        lines[i] = lines[i+1];
                        lines[i+1] = buffer;
                        continue;
                    }
                }
        }
           boolean srtd = false;
           for(int i = 0; i< lines.length-1; i++){
               if (lines[i].charAt(0) < lines[i+1].charAt(0))
                   srtd = true;
               else {
                   srtd = false;
                   break;
               }
           }
        sorted = srtd;
        }
    } //ok


}