package bl;

public class ExporterFactory {
    private static final String CSV = "CSV";
    private static final String JSON = "JSON";

    public Exporter createExporter(String tipExport) {
        Exporter exporter = null;
        if (CSV.equals(tipExport)) {
            exporter = (Exporter) new CsvExporter();
        } else if (JSON.equals(tipExport)) {
            exporter = new JsonExporter();
        }
        return exporter;
    }

}
