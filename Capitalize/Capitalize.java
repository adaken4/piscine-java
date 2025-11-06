import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) return;

        try (
            FileReader fr = new FileReader(args[0]);
            FileWriter fw = new FileWriter(args[1])
        ) {
            boolean newWord = true;
            int ch;

            while ((ch = fr.read()) != -1) {
                char c = (char) ch;

                if (Character.isLetter(c)) {
                    if (newWord) {
                        fw.write(Character.toUpperCase(c));
                        newWord = false;
                    } else {
                        fw.write(Character.toLowerCase(c));
                    }
                } else {
                    fw.write(c);
                    // Treat any non-letter (including spaces, punctuation, etc.) as a word boundary
                    newWord = true;
                }
            }

            fw.flush();
        }
    }
}
