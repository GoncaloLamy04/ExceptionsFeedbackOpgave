package models;

import exceptions.NotEnoughCreditsException;
import exceptions.NegativeAmountException;
import java.util.Scanner;

public class Player {
    protected String name;
    protected int credits;

    public Player(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {return this.name;}

    public int getCredits() {return this.credits;}

    public boolean canAfford(int price) {return credits >= price;}

    public void deductCredits(int price) {credits -= price;}

    public void showDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Credits: " + this.credits);
    }

    public void addCredits(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException(this.name + "." + " You can't add negative credits.");
        }
    }
}

