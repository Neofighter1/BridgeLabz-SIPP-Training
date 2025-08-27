package Functional_Interfaces;

public class SecurityUtils {
    public static void main(String[] args) {
        System.out.println(isStrongPassword("Test123")); // false
        System.out.println(isStrongPassword("StrongPass1")); // true
    }

    public static boolean isStrongPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
    }
}
