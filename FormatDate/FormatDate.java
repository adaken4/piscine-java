// Instructions

// Create a file FormatDate.java.

// Write a function formatToFullText that returns a formatted string using the date as parameter. The awaited format is Le 22 août de l'an 2021 à 13h25m et 46s
// Write a function formatSimple that returns a formatted string using the date as parameter. The awaited format is febbraio 13 22
// Write a function formatIso that returns a formatted string using the time as parameter. The awaited format is 16:18:56.8495847

// Expected Functions
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;

// public class FormatDate {

//     public static String formatToFullText(LocalDateTime dateTime) {
//         // your code here
//     }

//     public static String formatSimple(LocalDate date) {
//         // your code here
//     }

//     public static String formatIso(LocalTime time) {
//         // your code here
//     }

// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         System.out.println(FormatDate.formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
//         System.out.println(FormatDate.formatSimple(LocalDate.of(2022, 2, 13)));
//         System.out.println(FormatDate.formatIso(LocalTime.of(16, 18, 56, 8495847)));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// Le 22 août de l'an 2021 à 13h25m et 46s
// febbraio 13 22
// 16:18:56.008495847
// $ 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "d MMMM 'de l''an' yyyy 'à' H'h'm'm 'et' s's'",
                Locale.FRANCE
        );
        return dateTime.format(formatter);
    }

    public static String formatSimple(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
            "MMMM d yy",
            Locale.ITALIAN
        );
        return date.format(formatter);
    }

    public static String formatIso(LocalTime time) {
        return time.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

}
