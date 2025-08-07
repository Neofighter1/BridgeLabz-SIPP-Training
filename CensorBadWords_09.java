public class CensorBadWords_09 {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = { "damn", "stupid" };
        for (String word : badWords) {
            text = text.replaceAll("(?i)" + word, "****");
        }
        System.out.println(text);
    }
}
