package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.Arrays;

public class Controller {
    public TextField text_name;
    public TextField text_address;
    public TextField text_spec;
    public TextField text_number;
    public TextField text_mon;
    public TextField text_thu;
    public TextField text_wed;
    public TextField text_tue;
    public TextField text_fri;
    public TextField text_sat;
    public TextField text_sun;
    public TextArea number_collection;

    public TipaContainer function = new TipaContainer();
    public TradePoint shop = new TradePoint();
    public ListView list_table;
    public TextField text_remove;
    public Button butt_ok;

    public void add(ActionEvent event){

        shop.setName(text_name.getText());
        shop.setAdress(text_address.getText());
        shop.setSpecialization(text_spec.getText());
        shop.time.setMONDAY(text_mon.getText());
        shop.time.setTHURSDAY(text_thu.getText());
        shop.time.setWEDNESDAY(text_wed.getText());
        shop.time.setTUESDAY(text_tue.getText());
        shop.time.setFRIDAY(text_fri.getText());
        shop.time.setSATURDAY(text_sat.getText());
        shop.time.setSUNDAY(text_sun.getText());
        shop.setWorkTime(shop.time);
        function.add(shop);
        text_name.clear();text_address.clear();text_spec.clear();text_mon.clear();
        text_thu.clear();text_wed.clear();text_tue.clear();text_fri.clear();
        text_sat.clear();text_sun.clear();number_collection.clear();
        shop = new TradePoint();
    }

    public void addNumber(ActionEvent event){
        String[] numbers = Arrays.copyOf(shop.getNumbers(),shop.getNumbers().length+1);
        numbers[numbers.length-1] = text_number.getText();
        shop.setNumbers(numbers);
        text_number.clear();
        String u = new String();
        for(String i: shop.getNumbers()){
            u+=i+"\n";
        }
        number_collection.setText(u);
    }

    public void sort(ActionEvent event){
        function.sort();
    }

    public void show(ActionEvent event){
        list_table.getItems().clear();
        for(int i = 0; i<function.ShopBase.size(); i++) {
            shop = function.ShopBase.get(i);
            shop.time = shop.getWorkTime();
            String data = "";
            data+= shop.getName()+"\n"+shop.getAdress()+"\n"+shop.getSpecialization()+"\n"+"\n-work time-\n"+shop.time.getMONDAY()+shop.time.getTUESDAY()
            +shop.time.getWEDNESDAY()+shop.time.getTHURSDAY()+shop.time.getFRIDAY()+shop.time.getSATURDAY()+shop.time.getSUNDAY()+"\n-numbers-\n";
            for (String s:shop.getNumbers()) {
                data+=s+"\n";
            }
            list_table.getItems().add(data);
        }
        shop = new TradePoint();
    }

    public void remove(ActionEvent event){
        if(function.ShopBase.isEmpty()) {

        }else{
            text_remove.setVisible(true);
            butt_ok.setVisible(true);
        }
    }

    public void removecontinue(ActionEvent event){
        String s = text_remove.getText();
        int j = function.search("NAME:"+s);
        if(j==-1){
            text_remove.setVisible(false);
            butt_ok.setVisible(false);
            text_remove.clear();
        } else {
            function.remove(j);
            text_remove.setVisible(false);
            butt_ok.setVisible(false);
            text_remove.clear();
            list_table.getItems().clear();
            for (int i = 0; i < function.ShopBase.size(); i++) {
                shop = function.ShopBase.get(i);
                shop.time = shop.getWorkTime();
                String data = "";
                data += shop.getName() + "\n" + shop.getAdress() + "\n" + shop.getSpecialization() + "\n" + "\n-work time-\n" + shop.time.getMONDAY() + shop.time.getTUESDAY()
                        + shop.time.getWEDNESDAY() + shop.time.getTHURSDAY() + shop.time.getFRIDAY() + shop.time.getSATURDAY() + shop.time.getSUNDAY() + "\n-numbers-\n";
                for (String m : shop.getNumbers()) {
                    data += m + "\n";
                }
                list_table.getItems().add(data);
            }
            shop = new TradePoint();
        }
    }

    public void clear(ActionEvent event){
        function.ShopBase.clear();
        list_table.getItems().clear();
    }
}
