/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescape;

/**
 *
 * @author Mikaela Rubica
 */import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " has been added to your inventory.");
    }

    public void removeItem(Item item) {
        items.remove(item);
        System.out.println(item.getName() + " has been removed from your inventory.");
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }
        }
    }

    public void useItem(int index, Player player) {
        if (index < 0 || index >= items.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        Item item = items.get(index);
        item.interact(player);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
