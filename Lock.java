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
import java.util.Random;

public class Lock {
    private int code;

    public Lock() {
        Random random = new Random();
        this.code = 1000 + random.nextInt(9000);  // Generates a random number 
    }

    public int getCode() {
        return this.code;
    }

    public void displayCode() {
        System.out.println("The code is: " + this.code);  
    }
}