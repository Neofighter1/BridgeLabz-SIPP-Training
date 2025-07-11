
public class StringBuffer_Concatenate {
    public static void main(String[] args) {
        String[] strings = {"Java", "is", "fun"};
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
