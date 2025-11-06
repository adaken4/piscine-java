import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        // Check that both input and output file arguments are provided
        if (args.length < 2) {
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Capitalize the first character of each word
                StringBuilder capitalizedLine = new StringBuilder();
                boolean newWord = true;

                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        if (newWord) {
                            capitalizedLine.append(Character.toUpperCase(c));
                            newWord = false;
                        } else {
                            capitalizedLine.append(Character.toLowerCase(c));
                        }
                    } else {
                        capitalizedLine.append(c);
                        newWord = !Character.isLetter(c);
                    }
                }

                writer.write(capitalizedLine.toString());
                writer.newLine(); // preserve original line breaks
            }
        }
    }
}
