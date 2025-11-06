import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        // Start searching from the "documents" folder in the current directory
        File documentsFolder = new File("documents");
        
        if (!documentsFolder.exists() || !documentsFolder.isDirectory()) {
            return null; // documents folder doesn't exist
        }
        
        // Start recursive search
        return searchRecursive(documentsFolder, fileName);
    }
    
    private static String searchRecursive(File currentDir, String fileName) {
        // List all files and directories in the current directory
        File[] files = currentDir.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    // Found the file! Return the relative path
                    return getRelativePath(file);
                } else if (file.isDirectory()) {
                    // Recursively search in subdirectory
                    String result = searchRecursive(file, fileName);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        
        return null; // File not found in this branch
    }
    
    private static String getRelativePath(File file) {
        // Convert the absolute path to a relative path starting from "documents"
        String absolutePath = file.getAbsolutePath();
        String documentsPath = new File("documents").getAbsolutePath();
        
        // Extract the path relative to documents folder
        if (absolutePath.startsWith(documentsPath)) {
            return "documents" + absolutePath.substring(documentsPath.length()).replace(File.separator, "/");
        }
        
        return absolutePath.replace(File.separator, "/");
    }
}