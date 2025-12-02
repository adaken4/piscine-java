// Instructions

// Create a file named DoOp.java.

// Write a function operate that returns the result of the given arithmetic operation specified in the parameters. The arguments should be passed in the following order:

// The first argument is the left operand

// The second argument is the operation sign

// The third argument is the right operand

// Expected Functions
// public class DoOp {
//     public static String operate(String[] args) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {
//     public static void main(String[] args) {
//         System.out.println(DoOp.operate(new String[]{"1","+","2"}));
//         System.out.println(DoOp.operate(new String[]{"1","-","1"}));
//         System.out.println(DoOp.operate(new String[]{"1","%","0"}));
//         System.out.println(DoOp.operate(args));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// 3
// 0
// Error
// it depend on the input.
// $

public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "Error";
        }

        String operator = args[1];
        int num1, num2;

        try {
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            return "Error";
        }

        switch (operator) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            case "/":
                if (num2 == 0) {
                    return "Error";
                }
                return String.valueOf(num1 / num2);
            case "%":
                if (num2 == 0) {
                    return "Error";
                }
                return String.valueOf(num1 % num2);
            default:
                return "Error";
        }
    }
}