import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        Arrays.sort(args);
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}