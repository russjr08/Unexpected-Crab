package com.kronosad.projects.games.monopoly;

import com.kronosad.projects.games.monopoly.objects.Property;

import java.util.ArrayList;

/**
 * Created by Russell on 4/5/2014.
 */
public class Monopoly {
    private ArrayList<Property> gameProperties = new ArrayList<>();

    public Monopoly(){
        initCards();
    }

    private void initCards(){

    }
    /**
     * Entry point for program...
     * @param args
     */
    public static void main(String... args){
        new Monopoly();
        System.out.println();
    }

}
