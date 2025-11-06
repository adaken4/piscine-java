import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        // If no output file provided, do nothing
        if (args.length == 0) {
            return;
        }

        // Read from standard input and write to file
        try (
            InputStream in = System.in;
            FileOutputStream out = new FileOutputStream(args[0])
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read chunks of bytes and write them to file
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            out.flush();
        }
    }
}
