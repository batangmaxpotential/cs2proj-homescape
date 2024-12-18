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
import java.util.ArrayList;
import java.util.Random;

public class Player {
    private int health = 100;
    private ArrayList<String> inventory = new ArrayList<>();
    private int lockCode; // Hold random code

  
    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    // Method to add items to inventory
    public void addToInventory(String item) {
        inventory.add(item);
    }

    // Checks inventory
    public void checkInventory() {
        System.out.println("Your Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));  // List items with numbers
        }
    }

    public void useItem(int itemNumber) {
        if (itemNumber > 0 && itemNumber <= inventory.size()) {
            String item = inventory.get(itemNumber - 1); // Get item based on number input
            System.out.println("You chose: " + item);

            if (item.equals("Apple")) {
                setHealth(getHealth() + 20);  // Apple restores health
                System.out.println("You used the Apple! It restored your health.");
                if (getHealth() > 100) setHealth(100);  // Ensure health doesn't exceed 100
            } else if (item.equals("Code from Fridge")) {
                System.out.println("You have read the code from the fridge. It’s: " + lockCode);
            } else {
                System.out.println("You can't use this item.");
            }
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

 
    public void generateLockCode() {
        Random rand = new Random();
        lockCode = rand.nextInt(9000) + 1000;  // Generates a 4-digit code 
    }


    public int getLockCode() {
        return lockCode;
    }
}