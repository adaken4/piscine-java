import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        // Try to open and read the file
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        // Use a buffer to read in chunks (handles both text and binary safely)
        byte[] buffer = new byte[1024];
        int bytesRead;

        // Read until end of file
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            System.out.write(buffer, 0, bytesRead);
        }

        // Flush any remaining bytes to stdout
        System.out.flush();
        fileInputStream.close();
    }
}