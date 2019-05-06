package com.company;
import java.util.regex.*;

public class Patterns {

    boolean matchData(String data, Pattern pattern){
        Matcher matcher = pattern.matcher(data);
        if(matcher.matches())
            return true;
        else
            return false;
    }

    boolean confirmed(String string, String input){
        if(string.equals(input))
            return true;
        else
            return false;
    }
}
