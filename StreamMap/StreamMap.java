// Instructions

// Create a file StreamMap.java.

// Create a function sumOfStringLength which returns the sum of the length of the strings in the stream.
// Create a function upperCaseAllString which returns the list of all the strings in upper case.
// Create a function uniqIntValuesGreaterThan42 which keeps only doubles greater than 42, transforms the doubles to integers and returns them as a set.

// Expected Functions
// public class StreamMap {
//     public static Integer sumOfStringLength(Stream<String> s) {
//         // your code here
//     }

//     public static List<String> upperCaseAllString(Stream<String> s) {
//         // your code here
//     }
    
//     public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.io.IOException;
// import java.util.stream.Stream;

// public class ExerciseRunner {
//     public static void main(String[] args) throws IOException {
//         System.out.println(StreamMap.sumOfStringLength(Stream.of("Bonjour", "le", "monde !")));
//         System.out.println(StreamMap.upperCaseAllString(Stream.of("IL", "Fait", "beaU !!")));
//         System.out.println(StreamMap.uniqIntValuesGreaterThan42(Stream.of(23.439, 42.34, 39194.4)));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// 16
// [IL, FAIT, BEAU !!]
// [42, 39194]
// $ 

import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        return s.mapToInt(String::length).sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        return s.map(String::toUpperCase).toList();
    }
    
    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        return s.filter(d -> d > 42).map(Double::intValue).collect(Collectors.toSet());
    }
}
