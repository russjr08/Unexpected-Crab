package com.kronosad.projects.games.monopoly.objects;

import java.util.ArrayList;

/**
 * Created by Russell on 4/5/2014.
 */
public class Player {

    public enum TOKEN{
        Wheelbarrow, Battleship, Car, Thimble, Dog, Top_Hat, Cat
    }

    private String name;
    private TOKEN token;

    private ArrayList<Property> properties;
    private ArrayList<RandomCard> modifierCards;

    private double balance;

    public Player(String name, TOKEN token){
        this.name = name;
        this.token = token;

        properties = new ArrayList<>();
        modifierCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public TOKEN getToken() {
        return token;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public ArrayList<RandomCard> getModifierCards() {
        return modifierCards;
    }

    public double getBalance() {
        return balance;
    }
}
