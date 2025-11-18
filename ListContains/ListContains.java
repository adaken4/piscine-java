// Instructions

// Create a file ListContains.java.

// Write a function containsValue that returns true if the list as parameter contains the element as parameter, false otherwise.

// Expected Functions
// import java.util.List;

// public class ListContains {
//     public static boolean containsValue(List<Integer> list, Integer value) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.util.List;

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         System.out.println(ListContains.containsValue(List.of(9, 13, 8, 23, 1, 0, 89), 8));
//         System.out.println(ListContains.containsValue(List.of(9, 13, 8, 23, 1, 0, 89), 10));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// true
// false
// $

import java.util.List;

public class ListContains {
    public static boolean containsValue(List<Integer> list, Integer value) {
        for (Integer element : list) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    } 
}