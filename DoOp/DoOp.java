public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "it depends on the input.";
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