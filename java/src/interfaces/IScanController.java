package interfaces;

public interface IScanController {
    public String onGetAllScans(String jsonInput);

    public String onGetScan(String jsonInput);

    public String onScanBadge(String jsonInput);

}
