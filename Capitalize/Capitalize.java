import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder out = new StringBuilder(line.length());
                boolean newWord = true;

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isWhitespace(c)) {
                        // preserve whitespace exactly and mark next char as start of a word
                        out.append(c);
                        newWord = true;
                    } else {
                        if (newWord) {
                            out.append(Character.toUpperCase(c));
                            newWord = false;
                        } else {
                            out.append(Character.toLowerCase(c));
                        }
                    }
                }

                writer.write(out.toString());
                writer.newLine();
            }
        }
    }
}
