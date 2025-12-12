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

public class Sorcerer extends Character implements Healer {
    private final int healCapacity;
    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void attack(Character target) {
        heal(this);
        target.takeDamage(getWeapon().getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(Math.max(0, getCurrentHealth() - damage));
    }

    @Override
    public void heal(Character character) {
        character.setCurrentHealth(
            Math.min(character.getCurrentHealth() + healCapacity, character.getMaxHealth())
        );
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), getHealCapacity());
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP. He has the weapon %s", getName(), getCurrentHealth(), getHealCapacity(), getWeapon().getName());
    }
}
