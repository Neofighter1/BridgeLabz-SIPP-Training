
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_WordCount {
    public static void main(String[] args) {
        int count = 0;
        String target = "word";
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\s+");
                for (String w : words) {
                    if (w.equals(target)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Count: " + count);
    }
}
