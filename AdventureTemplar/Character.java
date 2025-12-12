//  Instructions

// In the following quest, we will work with the same files and classes. You should keep them from one exercise to the following.

// Create a file Character.java.

// Create a public class named Character.
// The class must contain three properties :

// maxHealth (int) : with a getter and no setter. This property is not updatable (final keyword).

// currentHealth (int) : with a getter and no setter.

// name (String) : with a getter and no setter. This property is not updatable (final keyword).

// Create a constructor with two parameters (name and maxHealth) : the currentHealth is initialized with the value of maxHealth.

// Override toString method, Must have the format <name> : <currentHealth>/<maxHealth>. If the currentHealth is 0, the format is <name> : KO.

// Implement two methods :

// takeDamage, with an integer parameter, that will subtract the amount in parameter from currentHealth. currentHealth can't be lower than 0.

// attack, with a parameter of type Character, that will call takeDamage of the parameter with a default value : 9.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Character aragorn = new Character("Aragorn", 20);
//         Character uruk = new Character("Uruk", 5);
        
//         System.out.println(aragorn.toString());
//         System.out.println(uruk.toString());
        
//         aragorn.attack(uruk);

//         System.out.println(uruk.toString());
        
//         aragorn.takeDamage(12);

//         System.out.println(aragorn.toString());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// Aragorn : 20/20
// Uruk : 5/5
// Uruk : KO
// Aragorn : 8/20
// $

import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public void attack(Character target) {
        target.takeDamage(9);
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return "------------------------------------------\nNobody's fighting right now !\n------------------------------------------\n";
        } else {
            StringBuilder status = new StringBuilder();
            status.append("------------------------------------------\nCharacters currently fighting :\n");
            for (Character character : allCharacters) {
                status.append(" - ").append(character.toString()).append("\n");
            }
            status.append("------------------------------------------\n");
            return status.toString();
        }
    }

    public static Character fight(Character c1, Character c2) {
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            c1.attack(c2);
            if (c2.getCurrentHealth() == 0) {
                return c1;
            }

            c2.attack(c1);
            if (c1.getCurrentHealth() == 0) {
                return c2;
            }
        }
        return null;
    }
}