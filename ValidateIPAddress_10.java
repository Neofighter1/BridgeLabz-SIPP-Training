public class ValidateIPAddress_10 {
    public static boolean isValidIP(String ip) {
        return ip.matches("^(25[0-5]|2[0-4]\\d|1?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|1?\\d{1,2})){3}$");
    }
    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1")); // true
        System.out.println(isValidIP("999.999.999.999")); // false
    }
}