// Instructions

// Create a file DifferenceBetweenDate.java.

// Write a function durationBetweenTime that returns the duration between the times as parameter. Must always be positive.
// Write a function periodBetweenDate that returns the period between the dates as parameter.Must always be positive.
// Write a function numberOfHoursBetweenDateTime that returns the number of hours between the date times as parameter. Must always be positive.

// Expected Functions
// import java.time.Duration;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.time.Period;

// public class DifferenceBetweenDate {

//     public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
//         // your code here
//     }

//     public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
//         // your code here
//     }

//     public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
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
//         Duration duration = DifferenceBetweenDate.durationBetweenTime(LocalTime.of(12, 54, 32), LocalTime.of(21, 23, 53));
//         System.out.println(duration.toHoursPart() + "H" + duration.toMinutesPart() + "M" + duration.toSecondsPart() + "S");
//         Period period = DifferenceBetweenDate.periodBetweenDate(LocalDate.of(2020, 10, 13), LocalDate.of(2022, 5, 8));
//         System.out.println(period.getYears() + "Y" + period.getMonths() + "M" + period.getDays() + "D");
//         System.out.println(DifferenceBetweenDate.numberOfHoursBetweenDateTime(LocalDateTime.of(2022, 4, 12, 16, 18, 56), LocalDateTime.of(2022, 5, 10, 21, 54, 56)));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// 8H29M21S
// 1Y6M25D
// 677
// $ 

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DifferenceBetweenDate {

    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        if (localTime1 == null || localTime2 == null) return null;
        // Ensure result is positive
        if (localTime2.isBefore(localTime1)) {
            return Duration.between(localTime2, localTime1);
        }
        return Duration.between(localTime1, localTime2);
    }

    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) return null;
        // Ensure result is positive
        if (date2.isBefore(date1)) {
            return Period.between(date2, date1);
        }
        return Period.between(date1, date2);
    }

    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if (dateTime1 == null || dateTime2 == null) return null;
        // Ensure result is positive
        long hours = Duration.between(dateTime1, dateTime2).toHours();
        return Math.abs(hours);
    }
    
     public static void main(String[] args) {
        Duration duration = DifferenceBetweenDate.durationBetweenTime(LocalTime.of(12, 54, 32), LocalTime.of(21, 23, 53));
        System.out.println(duration.toHoursPart() + "H" + duration.toMinutesPart() + "M" + duration.toSecondsPart() + "S");
        Period period = DifferenceBetweenDate.periodBetweenDate(LocalDate.of(2020, 10, 13), LocalDate.of(2022, 5, 8));
        System.out.println(period.getYears() + "Y" + period.getMonths() + "M" + period.getDays() + "D");
        System.out.println(DifferenceBetweenDate.numberOfHoursBetweenDateTime(LocalDateTime.of(2022, 4, 12, 16, 18, 56), LocalDateTime.of(2022, 5, 10, 21, 54, 56)));
    }

}