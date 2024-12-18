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
public class Trap extends Item {

    private int damage;

    public Trap(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    @Override
    public void interact(Player player) {
        System.out.println("You triggered a trap! You lose " + damage + " health.");
        player.setHealth(player.getHealth() - damage);
        if (player.getHealth() <= 0) {
            System.out.println("You have no health left. Game Over!");
            System.exit(0);  // End the game
        }
        System.out.println("Your current health: " + player.getHealth());
    }
}