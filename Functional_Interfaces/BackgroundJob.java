
// Functional Interface - Background Job Execution
public class BackgroundJob {
    public static void main(String[] args) {
        Runnable job = () -> System.out.println("Background Job is running...");
        new Thread(job).start();
    }
}
