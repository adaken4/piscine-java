// Instructions

// We will now implement our first interface through a new class : Sorcerer in a file named Sorcerer.java.

// This class implements the Healer interface and inherits from Character. It has a new attribute : an integer healCapacity.

// It has a constructor with three parameters :

// name,

// maxHealth

// healCapacity

// From the Healer interface :

// getHealCapacity returns the property healCapacity

// heal adds healCapacity to the currentHealth of the Character in parameter. Beware that currentHealth can't be greater the maxHealth. You may need to change the accessibility of the currentHealth attribute in Character class to be able to update the value.

// You will override toString method with the following format : <name> is a sorcerer with <currentHealth> HP. It can heal <healCapacity> HP. If its currentHeal is equal to 0, the format is <name> is a dead sorcerer. So bad, it could heal <healCapacity> HP.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Sorcerer gandalf = new Sorcerer("Gandalf", 20, 5);
//         Character frodon = new Character("Frodon", 20);
//         Sorcerer saroumane = new Sorcerer("saroumane", 10, 3);

//         Character.fight(frodon, saroumane);
        
//         gandalf.heal(frodon);

//         System.out.println(Character.printStatus());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// ------------------------------------------
// Characters currently fighting : 
//  - Gandalf is a sorcerer with 20 HP. It can heal 5 HP.
//  - Frodon : 16/20
//  - Saroumane is a dead sorcerer. So bad, it could heal 3 HP.
// ------------------------------------------
// $ 

import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int maxHealth;
    public int currentHealth;
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
        } else {
            return name + " : " + currentHealth + "/" + maxHealth;
        }
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