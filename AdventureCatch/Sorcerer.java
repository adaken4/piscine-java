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
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        heal(this);
        target.takeDamage(getWeapon().getDamage());
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        setCurrentHealth(Math.max(0, getCurrentHealth() - damage));
    }

    @Override
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
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), getHealCapacity());
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP. He has the weapon %s", getName(), getCurrentHealth(), getHealCapacity(), getWeapon().getName());
    }
}
