package interfaces;

import java.util.ArrayList;

import dtos.ScanDto;
import dtos.ScanListDto;
import entities.Scan;

public interface IScanController {
    public ScanListDto onGetAllScans();

    public ScanDto onGetScan(int id);

}
