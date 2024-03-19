package interfaces;

import dtos.ScanDto;

public interface IScanController {
    public String onGetAllScans(String jsonInput);

    public ScanDto onGetScan(int id);

}
