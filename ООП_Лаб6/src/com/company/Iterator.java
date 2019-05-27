package com.company;

public class Iterator extends Conteiner implements java.util.Iterator {

    @Override
    public boolean hasNext() {
        boolean has = false;
        if ( pointer + 1 != lines.length+1 )
            has = true;
        return has;
    }
    @Override
    public String next() {
        String nextIter = lines[pointer++];
        return nextIter;
    }
    @Override
    public void remove(){
         lines[pointer] = null;
    }
}