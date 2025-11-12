
import java.util.Scanner;
import exceptions.NegativeAmountException;
import exceptions.NotEnoughCreditsException;
import exceptions.PlayerNotFoundException;
import models.LootCrate;
import models.Player;
import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    List<Player> players = new ArrayList<>();
    List <LootCrate> lootcrates = new ArrayList<>();

    Player player1 = new Player("Bronny", 60);
    Player player2 = new Player("Silver", 30);
    LootCrate cheapcrate =(new LootCrate("cheapCrate", 45));
    LootCrate expensivecrate =(new LootCrate("expensiveCrate", 65));

    players.add(player1);
    players.add(player2);
    lootcrates.add(cheapcrate);
    lootcrates.add(expensivecrate);


    for (Player p : players) {
        p.showDetails();
        System.out.println("==============================");
    }

    System.out.println("--- Scenarie 1: Player opens crate ---");
    try {
        cheapcrate.open(player1);
    } catch (NotEnoughCreditsException e) {
        System.out.println("Error: " + e.getMessage());
    }

    System.out.println("\n--- Scenarie 2: Too little credits ---");
    try {
        expensivecrate.open(player2); //
    } catch (NotEnoughCreditsException e) {
        System.out.println("Error: " + e.getMessage());
    }

    System.out.println("\n--- Scenarie 3: Adding negative credits ---");
    try {
        player1.addCredits(-20); // Has to give error message
    } catch (NegativeAmountException e) {
        System.out.println("Error: " + e.getMessage());
    }


}





