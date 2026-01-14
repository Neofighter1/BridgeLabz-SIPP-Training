
public class ValidateHexColorCode_03 {
    public static boolean isValidHex(String color) {
        return color.matches("^#([A-Fa-f0-9]{6})$");
    }
    public static void main(String[] args) {
        System.out.println(isValidHex("#FFA500")); 
        System.out.println(isValidHex("#ff4500")); 
        System.out.println(isValidHex("#123")); 
    }
}