
// Create a new class DeadCharacterException in a new file DeadCharacterException.java.
// This class is an exception so should inherit from Exception.

// This class has a constructor which takes a Character as parameter.

// It has one method getMessage which returns a String : The <sorcerer | monster | templar> <character.name> is dead..

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Weapon feu = new Weapon("Boule de feu", 7);
//         Sorcerer triss = new Sorcerer("Triss Merigold", 30, 5, feu); 
//         Templar geralt = new Templar("Geralt de Riv", 28, 2, 5, feu); 
//         DeadCharacterException exceptionTriss = new DeadCharacterException(triss);
//         DeadCharacterException exceptionGeralt = new DeadCharacterException(geralt);
        
//         System.out.println(exceptionTriss.getMessage());
//         System.out.println(exceptionGeralt.getMessage());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// The sorcerer Triss Merigold is dead.
// The templar Geralt de Riv is dead.
// $ 

public class DeadCharacterException extends Exception {
    private final Character character;
    public DeadCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        String characterType = switch (character.getClass().getName()) {
            case "Sorcerer" -> "sorcerer";
            case "Templar" -> "templar";
            case "Monster" -> "monster";
            default -> "character";
        };

        return String.format("The %s %s is dead.", characterType, character.getName());
    }
}