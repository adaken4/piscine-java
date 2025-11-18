// Instructions

// Create a file MapEquals.java.

// Write a function areMapsEqual that returns true if the maps as parameters are equal. Returns false otherwise.

// Expected Functions
// import java.util.Map;

// public class MapEquals {
//     public static boolean areMapsEqual(Map<String, Integer> map1, Map<String, Integer> map2) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function:

// import java.util.Map;

// public class ExerciseRunner {
//     public static void main(String[] args) {
//         Map<String, Integer> map1 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
//         Map<String, Integer> map2 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
//         System.out.println(MapEquals.areMapsEqual(map1, map2)); // Expected Output: true

//         Map<String, Integer> map3 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
//         Map<String, Integer> map4 = Map.of("Alice", 1, "Bob", 2, "Emily", 3);
//         System.out.println(MapEquals.areMapsEqual(map3, map4)); // Expected Output: false
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// true
// false
// $

import java.util.Map;

public class MapEquals {
    public static boolean areMapsEqual(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1 == null && map2 == null) {
            return true;
        }
        if (map1 == null || map2 == null) {
            return false;
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (!map2.containsKey(key) || !map2.get(key).equals(value)) {
                return false;
            }
        }
        return true;
    }
}