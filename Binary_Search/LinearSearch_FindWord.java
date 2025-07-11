
public class LinearSearch_FindWord {
    public static void main(String[] args) {
        String[] sentences = {"Java is fun", "I love coding", "Hello world"};
        String word = "coding";
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                System.out.println(sentence);
                return;
            }
        }
        System.out.println("Not Found");
    }
}
