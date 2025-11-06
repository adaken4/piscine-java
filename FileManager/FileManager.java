import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, content.getBytes());
    }
    
    public static String getContentFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        byte[] fileBytes = Files.readAllBytes(filePath);
        return new String(fileBytes);
    }
    
    public static void deleteFile(String fileName) {
        // delete the file if it exists
        Path filePath = Paths.get(fileName);
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            // ff deletion fails, we'll just ignore
        }
    }
}