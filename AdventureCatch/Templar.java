// Instructions

// Now, we will throw and catch some exceptions.

// For the methods attack, takeDamage and heal, if the character is already dead, you must throw a DeadCharacterException. Do this for all the Character subclasses.

// The fight method should not throw an exception, so you will need to catch the exception in this method.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Weapon excalibur = new Weapon("Excalibur", 7);
//         Weapon baton = new Weapon("Baton", 3);
//         Templar arthur = new Templar("Arthur", 30, 5, 3, excalibur);
//         Sorcerer merlin = new Sorcerer("Merlin", 28, 2, baton);

//         try {
//             arthur.takeDamage(50);
//         } catch (DeadCharacterException e) {
//             System.out.println(e.getMessage());
//         }

//         try {
//             arthur.takeDamage(2);
//         } catch (DeadCharacterException e) {
//             System.out.println(e.getMessage());
//         }
//         try {
//             arthur.attack(merlin);
//         } catch (DeadCharacterException e) {
//             System.out.println(e.getMessage());
//         }
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// The templar Arthur is dead.
// The templar Arthur is dead.
// $ 

public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        int effectiveDamage = Math.max(0, damage - shield);
        setCurrentHealth(Math.max(0, getCurrentHealth() - effectiveDamage));
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        heal(this);
        target.takeDamage(getWeapon().getDamage());
    }

    public void heal(Character character) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        character.setCurrentHealth(
            Math.min(character.getCurrentHealth() + healCapacity, character.getMaxHealth())
        );
    }


    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", getName(), getShield(), getHealCapacity());
        }
        return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d. He has the weapon %s", getName(), getCurrentHealth(), getHealCapacity(), getShield(), getWeapon().getName());
    }
}