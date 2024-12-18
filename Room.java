/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescape;

/**
 *
 * @author Mikaela Rubica
 */
import java.util.Scanner;

public class Room {

    // Vaariable for the main door lock code
    private int mainDoorCode;

    // Generates a random lock code for the main door
    public Room() {
        this.mainDoorCode = (int) (Math.random() * 9000) + 1000; // Random 4-digit code 
    }

   
    public int getMainDoorCode() {
        return mainDoorCode;
    }

    public void exploreKitchen(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in the kitchen. There are several items on the counter.");
        System.out.println("1. Check Fridge");
        System.out.println("2. Inspect Sink");
        System.out.println("3. Take Apple from the table");
        System.out.println("4. Go Back");
        System.out.println("5. Check Inventory");

        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "1":
                System.out.println("You open the fridge. There’s some food and a code scribbled on a note.");
                System.out.println("Do you want to take the note? (yes/no)");
                String noteChoice = scanner.nextLine().toLowerCase();
                if (noteChoice.equals("yes")) {
                    player.addToInventory("Code from Fridge");
                    System.out.println("You took the code note. It's in your inventory.");
                }
                break;
            case "2":
                System.out.println("The sink is full of dishes. Nothing of interest.");
                break;
            case "3":
                System.out.println("Do you want to take the apple? (yes/no)");
                String appleChoice = scanner.nextLine().toLowerCase();
                if (appleChoice.equals("yes")) {
                    player.addToInventory("Apple");
                    System.out.println("You took the apple. It’s in your inventory.");
                }
                break;
            case "4":
                return; // Go back to the main menu
            case "5":
                player.checkInventory(); // Check inventory
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                exploreKitchen(player); 
                break;
        }
    }

    public void exploreLivingRoom(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in the living room. There's a couch and a bookshelf.");
        System.out.println("1. Check Bookshelf");
        System.out.println("2. Inspect Couch");
        System.out.println("3. Go Back");
        System.out.println("4. Check Inventory");

        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "1":
                System.out.println("You check the bookshelf.");
                break;
            case "2":
                System.out.println("The couch looks comfortable. You can rest on it.");
                System.out.println("Do you want to rest? (yes/no)");
                String restChoice = scanner.nextLine().toLowerCase();
                if (restChoice.equals("yes")) {
                    player.setHealth(player.getHealth() + 15);
                    if (player.getHealth() > 100) player.setHealth(100);
                    System.out.println("Your current health: " + player.getHealth());
                }
                break;
            case "3":
                return; 
            case "4":
                player.checkInventory(); 
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                exploreLivingRoom(player); 
                break;
        }
    }

    public void exploreBedroom(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in the bedroom. There’s a bed and a locked wardrobe.");
        System.out.println("1. Inspect Bed");
        System.out.println("2. Check Wardrobe");
        System.out.println("3. Go Back");
        System.out.println("4. Check Inventory");

        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "1":
                System.out.println("The bed looks comfy. You can rest here.");
                break;
            case "2":
                System.out.println("The wardrobe is locked. You need a code to open it.");
                break;
            case "3":
                return; 
            case "4":
                player.checkInventory(); 
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                exploreBedroom(player);
                break;
        }
    }

   
    public void interactWithMainDoor(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nYou approach the main door.");
        System.out.println("It is locked. You need to input a 4-digit code to open it.");

        System.out.println("Enter the 4-digit code to unlock the door:");
        int code = scanner.nextInt();

        if (code == mainDoorCode) {
            System.out.println("The door unlocks. You've escaped! Congratulations!");
            System.exit(0); // Exit the game
        } else {
            System.out.println("Incorrect code. Try again.");
        }
    }
}