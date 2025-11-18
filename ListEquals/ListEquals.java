// Instructions

// Create a file ListEquals.java.

// Write a function areListsEqual that returns true if the lists in parameters are equal. Returns false otherwise.

// Expected Functions
// import java.util.List;

// public class ListEquals {
//     public static boolean areListsEqual(List<String> list1, List<String> list2) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.util.List;

// public class ExerciseRunner {
//     public static void main(String[] args) {
//         System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Charly", "Emily")));
//         System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Emily", "Charly")));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// true
// false
// $

import java.util.List;

public class ListEquals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}