package models;
import exceptions.NotEnoughCreditsException;
import java.util.Scanner;

public class LootCrate {
    private String id;
    private int price;
    protected Scanner input = new Scanner(System.in);

    public LootCrate(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public void open(Player player) throws NotEnoughCreditsException {

        while (true) {
            System.out.println(player.getName() + " do you want to open a crate?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String choice;

            switch (choice = input.nextLine()) {
                case "1":
                    if (player.canAfford(price)) {
                        player.deductCredits(price);
                        System.out.println(player.getName() + " opened " + id + "!");
                        System.out.println(player.getName() + " has " + player.getCredits() + " credits remaining!");
                    } else {
                        throw new NotEnoughCreditsException(player.getName() + " does not have enough credits to buy " + id + "!");
                    }
                    return;

                case "2":
                    System.out.println(player.getName() + " does not want to open " + id + "!");
                    return;

                default:
                    System.out.println("Invalid choice. Type 1 or 2!");
                    break;
            }

        }


    }
}

