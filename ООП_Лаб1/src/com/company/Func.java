package com.company;

public class Func {

    public static String SpaceBar(String str){
        String strCopy = new String();
        char [] arr = new char[str.length()];
//добавляє два пропуски після кожного символа
        for ( int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i);
            strCopy += arr[i] + "  ";
        }
        return strCopy;
    }

    public static String AlphaberNum (String strNew) {
        char alhpa[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String number = new String();
// провірка яка по номеру буква в слові
        for (int j = 0; j < strNew.length(); j++) {
            for (int i = 0; i < alhpa.length; i++) {
                if (strNew.charAt(j) == alhpa[i]) {
                    if (i + 1 >= 10)
                        number += ((i + 1) + " ");
                    else
                        number += ((i + 1) + "  ");
                }
            }
        }
        return number;
    }
}