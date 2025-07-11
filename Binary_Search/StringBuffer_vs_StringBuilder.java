
public class StringBuffer_vs_StringBuilder {
    public static void main(String[] args) {
        long start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sbf.append("hello");
        }
        long end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start));

        start = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sbd.append("hello");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start));
    }
}
