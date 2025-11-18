// Instructions

// Create a file ListSearchIndex.java.

// Write a function findLastIndex that returns the last index of an element in a list. Returns null otherwise.
// Write a function findFirstIndex that returns the first index of an element in a list. Returns null otherwise.
// Write a function findAllIndexes that returns a list of all indexes of an element in a list. Returns an empty list otherwise.

// Expected Functions
// import java.util.List;

// public class ListSearchIndex {
//     public static Integer findLastIndex(List<Integer> list, Integer value) {
//         // your code here
//     }
//     public static Integer findFirstIndex(List<Integer> list, Integer value) {
//         // your code here
//     }
//     public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.util.List;

// public class ExerciseRunner {
//     public static void main(String[] args) {
//         System.out.println(ListSearchIndex.findLastIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
//         System.out.println(ListSearchIndex.findFirstIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
//         System.out.println(ListSearchIndex.findAllIndexes(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89).toString());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// 7
// 2
// [2, 7]
// $ 

import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals(value)) {
                return i;
            }
        }
        return null;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                return i;
            }
        }
        return null;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> indexes = new ArrayList<>();
        if (list == null) {
            return indexes;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}