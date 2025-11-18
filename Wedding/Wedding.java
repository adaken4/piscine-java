// Instructions

// Create a file Wedding.java.

// Write a function createCouple that returns a map of names which associates randomly a name from the first list to a name of the second list.
// If the lists have different sizes, some names from the bigger list will be ignored.

// Expected Functions
// import java.util.Set;
// import java.util.Map;

// public class Wedding {
//     public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.util.Set;

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         System.out.println(Wedding.createCouple(Set.of("Pikachu", "Dracaufeu", "Tortank"), Set.of("Legolas", "Aragorn", "Gimli")));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// {Pikachu=Legolas, Tortank=Gimli, Dracaufeu=Aragorn}
// $

import java.util.Map;
import java.util.Set;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        java.util.List<String> firstList = new java.util.ArrayList<>(first);
        java.util.List<String> secondList = new java.util.ArrayList<>(second);
        java.util.Collections.shuffle(firstList);
        java.util.Collections.shuffle(secondList);

        int size = Math.min(firstList.size(), secondList.size());
        Map<String, String> couples = new java.util.HashMap<>();

        for (int i = 0; i < size; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }

        return couples;
    }
}