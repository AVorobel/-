package com.company;

import java.io.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class Conteiner implements Iterable<String>, Serializable {

    protected static String [] lines = new String [0];
    protected static int pointer = 0;


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

    void clear(){
        lines = new String[0];
    }//ok

    boolean remove(String str){
        boolean removed = false;
        int j = 0;
        if (str != null){
            String [] buffer = new String[lines.length-1];
            for (int i=0; i< lines.length; i++) {
                if(lines[i].equals(str)) {
                    removed = true;
                    continue;
                }
                else {
                    buffer[j] = lines[i];
                    if (j!= lines.length-1)
                        j++;
                    continue;
                }
            }
            lines = new String[0];
            lines = buffer;
        }
        else
            System.out.println("no such string");
        return removed;
    }//ok

    Object[] toArray(){
        String [] array =  Arrays.copyOf(lines, lines.length);
        return array;
    }//ok

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

   boolean Serialize (String file){
       FileOutputStream fos;
       try {
           fos = new FileOutputStream(file);
       } catch (FileNotFoundException e) {
           System.out.println("file not found");
           return false;
       }
       try {
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(lines);
           oos.flush();
           oos.close();
           fos.close();
           return true;
       }catch (IOException e) {
           System.out.println("fail with serialize");
           return false;
       }
   }//ok

   boolean Deserialize (String file){
       try{
           FileInputStream fis = new FileInputStream(file);
           ObjectInputStream oin = new ObjectInputStream(fis);
           String[] buffer = (String[]) oin.readObject();
           for(String s: buffer){
               System.out.println(s);
           }
           return true;
       }catch(IOException e){
           System.out.println("fail with deserialize");
           return false;
       }catch (ClassNotFoundException e){
           System.out.println("fail with deserialize");
           return false;
       }
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

    public int search(String str){
        int index=lines.length +1;
        for (int i = 0; i< lines.length; i++){
            if (lines[i] == str)
                index = i;
            else
                continue;
        }
        return index;
    }//ok
}