import java.io.File;

public class FileCounterSystem {

    public static void main(String[] args) {
        // Specify the directory path (you can change this)
        String directoryPath = "."; // Current directory
        File folder = new File(directoryPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid directory!");
            return;
        }

        // Initialize counters
        int javaFileCount = 0;
        int issueCount = 0;

        // Get all files in the directory
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName().toLowerCase();

                    if (name.endsWith(".java")) {
                        javaFileCount++;
                    }

                    // Count issues: assuming issues are solved problems stored in text files
                    if (name.contains("solution") || name.contains("solved")) {
                        issueCount++;
                    }
                }
            }
        }

        // Display results
        System.out.println("Number of Java Files = " + javaFileCount);
        System.out.println("Number of Issues = " + issueCount);
    }
}
