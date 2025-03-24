import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class ReadGroceries {
    public static void main(String[] args) {
        String path = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriteAFile {
    public static void main(String[] args) {
   
        String writtenFile = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writtenFile))) {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is another line.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriteDiary {
    public static void main(String[] args) {
        
        String diaryFile = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(diaryFile));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter content (enter END or end to finish):");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("END")) {
                writer.write(input);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FormatGroceries {
    public static void main(String[] args) {
        String inputFile = "";
        String outputFile = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("| ID | Item | Quantity (KG) | Price |\n");
            writer.write("| --- | --- | --- | --- |\n");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String item = parts[1];
                String quantity = parts[2].replace("KG", "");
                String price = parts[3];
                writer.write(String.format("| %s | %s | %s | %s |\n", id, item, quantity, price));
            }
            double total = 0;
            reader.close();
            reader = new BufferedReader(new FileReader(inputFile));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                total += Double.parseDouble(parts[3]);
            }
            writer.write("The grocery shopping total is: €" + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    