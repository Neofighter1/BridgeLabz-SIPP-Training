public class ValidateCreditCard_11 {
    public static boolean isValidCard(String card) {
        return card.matches("^(4\\d{15}|5\\d{15})$");
    }

    public static void main(String[] args) {
        System.out.println(isValidCard("4123456789012345")); 
        System.out.println(isValidCard("5123456789012345"));
        System.out.println(isValidCard("6123456789012345")); 
    }
}
