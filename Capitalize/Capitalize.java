import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Please provide both input and output file names");
        }
        
        String inputFile = args[0];
        String outputFile = args[1];
        
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        
        String line;
        while ((line = reader.readLine()) != null) {
            String capitalizedLine = capitalizeLine(line);
            writer.write(capitalizedLine);
            writer.newLine();
        }
        
        reader.close();
        writer.close();
    }
    
    private static String capitalizeLine(String line) {
        if (line == null || line.isEmpty()) {
            return line;
        }
        
        String[] words = line.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                String capitalizedWord = words[i].substring(0, 1).toUpperCase() + 
                                       words[i].substring(1).toLowerCase();
                result.append(capitalizedWord);
                
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
        }
        
        return result.toString();
    }
}