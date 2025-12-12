// Instructions

// Let's change things a bit: make the Character as abstract. You can now try to instantiate a Character object, it will fail :)

// Change attack and takeDamage methods : make them abstract too.

// Now, if you try to launch an example, it will fail. Indeed, you need to implement both methods in all subclasses. Do this as follows :

// Remember that in all cases, currentHealth should not be lower than 0.

// For Monster class :

// the method attack should make 7 damages to the character in parameter.

// the method takeDamage should take 80% of all the damages, rounded to the inferior integer.

// For the Sorcerer class :

// the method attack should heal itself (using the heal method) then make 10 damages to the character in parameter.

// the method takeDamage should take all the damages.

// For the Templar class :

// the method attack should heal itself (using the method heal) then make 6 damages to the character in parameter.

// the method takeDamage should take the damage given in parameter minus the shield value.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Templar alistair = new Templar("Alistair", 18, 2, 4);
//         Sorcerer morrigan = new Sorcerer("Morrigan", 21, 5);
//         Monster dragon = new Monster("Dragon", 12);

//         dragon.attack(alistair);
//         dragon.attack(morrigan);
        
//         alistair.attack(dragon);
//         morrigan.attack(dragon);

//         System.out.println(Character.printStatus());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// ------------------------------------------
// Characters currently fighting :  
//  - Alistair is a strong Templar with 17 HP. It can heal 2 HP and has a shield of 4.
//  - Morrigan is a sorcerer with 19 HP. It can heal 5 HP.
//  - Dragon is a monster and is dead
// ------------------------------------------
// $ 

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
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

    protected void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public String getName() {
        return name;
    }

    public abstract void takeDamage(int damage);

    public abstract void attack(Character target);

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