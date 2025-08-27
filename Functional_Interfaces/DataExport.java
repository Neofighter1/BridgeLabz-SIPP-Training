

interface Exporter {
    void export(String data);
    default void exportToJSON(String data) {
        System.out.println("Exporting to JSON: " + data);
    }
}

class CSVExporter implements Exporter {
    public void export(String data) { System.out.println("Exporting to CSV: " + data); }
}

public class DataExport {
    public static void main(String[] args) {
        Exporter csv = new CSVExporter();
        csv.export("Report Data");
        csv.exportToJSON("Report Data");
    }
}
