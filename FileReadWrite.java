import java.io.*;
public class FileReadWrite {
    public static void main(String[] args) {
        String fileName = "dummy.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            boolean addMore = true;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (addMore) {
                System.out.println("Enter text to be written:");
                String input = reader.readLine();
                writer.write(input);
                writer.newLine();

                System.out.println("Want to add more? (y/n)");
                String choice = reader.readLine();
                addMore = choice.equalsIgnoreCase("y");
            }

            System.out.println("Content of the file:");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}