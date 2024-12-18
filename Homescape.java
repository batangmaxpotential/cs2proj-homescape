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

public class Homescape {

    public static void main(String[] args) {
        Player player = new Player();  
        player.generateLockCode();  // Generate a random code at the start of the game
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("You are in a mysterious house.");
            System.out.println("1. Go to Kitchen");
            System.out.println("2. Go to Living Room");
            System.out.println("3. Go to Bedroom");
            System.out.println("4. Check Inventory");
            System.out.println("5. Check Main Door");
            System.out.println("6. Exit Game");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    exploreKitchen(player); // Explore the kitchen
                    break;
                case "2":
                    exploreLivingRoom(player); // Explore the living room
                    break;
                case "3":
                    exploreBedroom(player); // Explore the bedroom
                    break;
                case "4":
                    player.checkInventory();
                    System.out.println("Would you like to use an item? (yes/no)");
                    String useChoice = scanner.nextLine().toLowerCase();
                    if (useChoice.equals("yes")) {
                        System.out.println("Which item would you like to use? (enter number)");
                        int itemChoice;
                        try {
                            itemChoice = Integer.parseInt(scanner.nextLine());  // Convert string to int
                            player.useItem(itemChoice);  // Use the item
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }
                    break;
                case "5":
                    System.out.println("Enter code to unlock the main door:");
                    int codeEntered;
                    try {
                        codeEntered = Integer.parseInt(scanner.nextLine());  
                        if (codeEntered == player.getLockCode()) {
                            System.out.println("The main door unlocks! You have escaped!");
                            System.exit(0);  // Exit the game once the door is unlocked
                        } else {
                            System.out.println("Incorrect code. Try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Kitchen
    public static void exploreKitchen(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in the kitchen. There are several items on the counter.");
        System.out.println("1. Check Fridge");
        System.out.println("2. Inspect Sink");
        System.out.println("3. Take Apple from the table");
        System.out.println("4. Go Back");

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
            default:
                System.out.println("Invalid choice. Please try again.");
                exploreKitchen(player); 
                break;
        }
    }

    // Living Room
    public static void exploreLivingRoom(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in the living room. There's a couch and a bookshelf.");
        System.out.println("1. Check Bookshelf");
        System.out.println("2. Inspect Couch");
        System.out.println("3. Go Back");

        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "1":
                System.out.println("You check the bookshelf and find a note.");
                System.out.println("Do you want to take the note? (yes/no)");
                String noteChoice = scanner.nextLine().toLowerCase();
                if (noteChoice.equals("yes")) {
                    player.addToInventory("Note from Bookshelf");
                    System.out.println("You took the note. It's in your inventory.");
                }
                break;
            case "2":
                System.out.println("The couch looks comfortable. You can rest on it.");
                System.out.println("Do you want to rest? (yes/no)");
                String restChoice = scanner.nextLine().toLowerCase();
                if (restChoice.equals("yes")) {
                    System.out.println("You rest on the couch and feel better.");
                    player.setHealth(player.getHealth() + 15);
                    if (player.getHealth() > 100) player.setHealth(100);
                    System.out.println("Your current health: " + player.getHealth());
                }
                break;
            case "3":
                return; 
            default:
                System.out.println("Invalid choice. Please try again.");
                exploreLivingRoom(player); 
                break;
        }
    }

    // Bedroom 
    public static void exploreBedroom(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in the bedroom. There’s a bed and a locked wardrobe.");
        System.out.println("1. Inspect Bed");
        System.out.println("2. Check Wardrobe");
        System.out.println("3. Go Back");

        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "1":
                System.out.println("The bed looks comfy. You can rest here.");
                System.out.println("Do you want to rest? (yes/no)");
                String bedRestChoice = scanner.nextLine().toLowerCase();
                if (bedRestChoice.equals("yes")) {
                    System.out.println("You rest on the bed and regain some health.");
                    player.setHealth(player.getHealth() + 20);
                    if (player.getHealth() > 100) player.setHealth(100);
                    System.out.println("Your current health: " + player.getHealth());
                }
                break;
            case "2":
                System.out.println("The wardrobe is locked. You need a code to open it.");
                System.out.println("Do you want to try entering a code? (yes/no)");
                String codeChoice = scanner.nextLine().toLowerCase();
                if (codeChoice.equals("yes")) {
                    System.out.println("Enter a 4-digit code:");
                    int code = new Scanner(System.in).nextInt();
                    if (code == player.getLockCode()) {
                        System.out.println("The wardrobe unlocks! You found an important item.");
                    } else {
                        System.out.println("Incorrect code. Try again.");
                    }
                }
                break;
            case "3":
                return; 
            default:
                System.out.println("Invalid choice. Please try again.");
                exploreBedroom(player); 
                break;
        }
    }
}