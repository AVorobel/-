package sample;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class TipaContainer {

    protected ArrayList<TradePoint> ShopBase = new ArrayList();
    protected TradePoint shop = new TradePoint();

    public void add(TradePoint object){ ShopBase.add(object); }

    public void remove(int index) { ShopBase.remove(index); }

    public void get(int index){
        if(index < ShopBase.size()) {
            shop = ShopBase.get(index);
            shop.time = shop.getWorkTime();
            System.out.println(shop.getName() + shop.getAdress() + shop.getSpecialization());
            System.out.println(shop.time.getMONDAY() + shop.time.getTUESDAY() + shop.time.getWEDNESDAY() + shop.time.getTHURSDAY() +
                    shop.time.getFRIDAY() + shop.time.getSATURDAY() + shop.time.getSUNDAY());
            for (String i : shop.getNumbers()) {
                System.out.print(i);
            }
        } else if(index<0 || index>= ShopBase.size())
            System.out.println("invalid index");
    }

    public void getALL(){
        for (int i = 0; i < ShopBase.size(); i++) {
            shop = ShopBase.get(i);
            shop.time = shop.getWorkTime();
            System.out.println(shop.getName() + shop.getAdress() + shop.getSpecialization());
            System.out.println(shop.time.getMONDAY() + shop.time.getTUESDAY() + shop.time.getWEDNESDAY() + shop.time.getTHURSDAY() +
                    shop.time.getFRIDAY() + shop.time.getSATURDAY() + shop.time.getSUNDAY());
            for (String y : shop.getNumbers()) {
                System.out.print(y);
            }
        }
    }

    public int search (String name){
        int find = -1;
        for (int i = 0; i < ShopBase.size(); i++) {
            shop = ShopBase.get(i);
            if(shop.getName().equals(name)) {
                find = i;
                break;
            }
            else
                continue;
        }
        return find;
    }

    public void sort(){
        ShopBase.sort(Comparator.comparing(TradePoint::getName));
    }

    public void WriteXML(String filename, int i) {
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(ShopBase.get(i));
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

    public void Writefile(String fileName, int i){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(ShopBase.get(i));
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

}
