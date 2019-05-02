package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>, Serializable {

    TradePoint shop = new TradePoint();

    private class Node implements Serializable {
        private T data;
        private Node next;
        private T getData() {
            return data;
        }
        private Node getNext() {
            return next;
        }
        private void setData(T data) {
            this.data = data;
        }
        private void setNext(Node next) {
            this.next = next;
        }
    }

    private Node root;

    public LinkedList() {
        root = new Node();
    }

    public void add(T data) {
        Node last = root;
        while(last.getNext() != null)
            last = last.getNext();
        last.setNext(new Node());
        last.getNext().setData(data);
    }

    public T get(int index) {
        Node result = root;
        for (int i = -1; i < index; i++) {
            if (result.getNext() == null)
                return null;
            else
                result = result.getNext();
        }
        return result.getData();
    }

    public boolean remove(int index) {
        Node result = root;
        if (size() != 0 && index>=0) {
            for (int i = -1; i < index-1; i++)
                if (result.getNext() == null)
                    return false;
                else
                    result = result.getNext();
            if (result.getNext() == null)
                return false;
            else if (result.getNext().getNext() == null) {
                result.setNext(null);
                return true;
            }
            else {
                result.setNext(result.getNext().getNext());
                return true;
            }
        }
        else return false;
    }

    public int size() {
        Node last = root;
        int count = 0;
        while(last.getNext() != null) {
            count++;
            last = last.getNext();
        }
        return count;
    }

    public void clear() {
        root = new Node();
    }

    public void WriteXML(String filename, LinkedList list, int i) {
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
                encoder.writeObject(list.get(i));
        }catch (FileNotFoundException e){
            System.out.println("Error");
        }
    }

    public void ReadXML(String filename) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            TradePoint object =  (TradePoint) decoder.readObject();
            shop = object;
            shop.time = shop.getWorkTime();
            System.out.println(shop.getName() + shop.getAdress() + shop.getSpecialization());
            System.out.println(shop.time.getMONDAY() + shop.time.getTUESDAY() + shop.time.getWEDNESDAY() + shop.time.getTHURSDAY() +
                    shop.time.getFRIDAY() + shop.time.getSATURDAY() + shop.time.getSUNDAY());
            for (String i : shop.getNumbers()) {
                System.out.print(i);
            }


        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }

    public void Writefile(String fileName, LinkedList list, int i){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(list.get(i));
            oos.flush();
        }catch (IOException e){
            System.out.println("can not write a file");
        }
    }

    public void Readfile(String fileName){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            shop = (TradePoint) ois.readObject();
            shop.time = shop.getWorkTime();
            System.out.println(shop.getName() + shop.getAdress() + shop.getSpecialization());
            System.out.println(shop.time.getMONDAY() + shop.time.getTUESDAY() + shop.time.getWEDNESDAY() + shop.time.getTHURSDAY() +
                    shop.time.getFRIDAY() + shop.time.getSATURDAY() + shop.time.getSUNDAY());
            for (String i : shop.getNumbers()) {
                System.out.print(i);
            }
        } catch (IOException e){
            System.out.println("Error");
        } catch (ClassNotFoundException e){
            System.out.println("Error");
        }
    }

    public String toString() {
        if (size() == 0) return "[ - ]";
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < size() - 1; i++) {
            result.append(shop.getName() + " " + shop.getAdress() + " " + shop.getSpecialization() + " "
                    + shop.getWorkTime().getMONDAY() + " " + shop.getWorkTime().getTUESDAY() + " " + shop.getWorkTime().getWEDNESDAY() + " " +
                    shop.getWorkTime().getTHURSDAY() + " " + shop.getWorkTime().getFRIDAY() + " " + shop.getWorkTime().getSATURDAY()
                    + " " + shop.getWorkTime().getSUNDAY());
            for (String d : shop.getNumbers()) {
                result.append(" " + d);
            }
        }
        result.append(get(size() - 1)).append(" ]");
        return new String(result);
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = get(i);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter;
            {                
            	counter = 0;
            }
            @Override
            public boolean hasNext() {
                return counter < size();
            }
            @Override
            public T next() {
                return get(counter++);
            }
        };
    }
}
