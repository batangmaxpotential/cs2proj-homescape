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
public class HealingItem extends Item {

    private int healAmount;

    public HealingItem(String name, String description, int healAmount) {
        super(name, description);
        this.healAmount = healAmount;
    }

    @Override
    public void interact(Player player) {
        System.out.println("You use " + getName() + " and heal for " + healAmount + " health.");
        player.setHealth(player.getHealth() + healAmount);
        if (player.getHealth() > 100) {
            player.setHealth(100);
        }
        System.out.println("Your current health: " + player.getHealth());
    }
}