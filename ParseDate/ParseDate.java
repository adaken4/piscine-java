// Instructions

// Create a file ParseDate.java.

// Write a function parseIsoFormat that returns a date object using the string as parameter. The date as a parameter is in ISO format (2022-04-25T20:51:28.709039322) Write a function parseFullTextFormat that returns a date object using the string as parameter. The date as a parameter use a text format (lundi 25 avril 2022) Write a function parseTimeFormat that returns a time object using the string as parameter. The date as a parameter use a text format (09 heures du soir, 07 minutes et 23 secondes)

// Expected Functions
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;

// public class ParseDate {

//     public static LocalDateTime parseIsoFormat(String stringDate) {
//         // your code here
//     }

//     public static LocalDate parseFullTextFormat(String stringDate) {
//         // your code here
//     }

//     public static LocalTime parseTimeFormat(String stringDate) {
//         // your code here
//     }

// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {
//     public static void main(String[] args) {
//         System.out.println(ParseDate.parseIsoFormat("2022-04-25T20:51:28.709039322"));
//         System.out.println(ParseDate.parseFullTextFormat("lundi 25 avril 2022"));
//         System.out.println(ParseDate.parseTimeFormat("09 heures du soir, 07 minutes et 23 secondes"));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// 2022-04-25T20:51:28.709039322
// 2022-04-25
// 21:07:23
// $ 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParseDate {
    public static LocalDateTime parseIsoFormat(String stringDate) {
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        String[] months = {
            "janvier", "février", "mars", "avril", "mai", "juin",
            "juillet", "août", "septembre", "octobre", "novembre", "décembre"
        };

        String[] parts = stringDate.split(" ");
        int day = Integer.parseInt(parts[1]);
        int month = 0;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(parts[2])) {
                month = i + 1;
                break;
            }
        }
        int year = Integer.parseInt(parts[3]);

        return LocalDate.of(year, month, day);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        String[] parts = stringDate.split(", ");
        int hours = Integer.parseInt(parts[0].split(" ")[0]);
        int minutes = Integer.parseInt(parts[1].split(" ")[0]);
        int seconds = Integer.parseInt(parts[2].split(" ")[0]);

        if (stringDate.contains("soir") && hours < 12) {
            hours += 12;
        }

        return LocalTime.of(hours, minutes, seconds);
    }
}
