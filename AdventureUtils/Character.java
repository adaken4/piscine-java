// Instructions

// Let's add some useful methods to allow us to manipulate and monitor what happens with our characters.

// Firstly, let's add something to see all our characters in one call :

// Add a private static list of Character, allCharacters, which will contain all our characters. In the constructor, you need to add every new Character to this list.

// Add a static method, printStatus, which takes no parameters and returns a formatted String that lists allCharaters. The awaited format is as follows with new line at the end :

// ------------------------------------------
// Characters currently fighting :
//  - <character1.toString>
//  - <character2.toString>
// ------------------------------------------
// If there is no character created :

// ------------------------------------------
// Nobody's fighting right now !
// ------------------------------------------
// Finally, add a static method, fight, which takes two Character objects and returns the winner in the fight.
// During the fight, the first one attacks, then the second one, then the first, then the second and so on until one of them reaches 0 in its currentHealth. When currentHealth for one of them reaches 0, the other one is the winner.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         System.out.print(Character.printStatus());

//         Character aragorn = new Character("Aragorn", 20);
//         Character uruk = new Character("Uruk", 15);

//         System.out.print(Character.printStatus());

//         Character winner = Character.fight(aragorn, uruk);

//         System.out.println(winner.toString());
//         System.out.print(Character.printStatus());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// ------------------------------------------
// Nobody's fighting right now !
// ------------------------------------------
// ------------------------------------------
// Characters currently fighting :
//  - Aragorn : 20/20
//  - Uruk : 15/15
// ------------------------------------------
// Aragorn : 11/20
// ------------------------------------------
// Characters currently fighting :
//  - Aragorn : 11/20
//  - Uruk : KO
// ------------------------------------------
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