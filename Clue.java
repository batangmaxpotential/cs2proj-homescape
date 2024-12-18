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
public class Clue extends Item {
    private String clueText;

    public Clue(String name, String description, String clueText) {
        super(name, description);
        this.clueText = clueText;
    }

    @Override
    public void interact(Player player) {
        System.out.println("You inspect the clue: " + clueText);
    }
}