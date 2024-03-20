package interfaces;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import dtos.GetScanRequestDto;
import dtos.OnScanBadgeDto;
import entities.Scan;

public interface IScanInteractor {
    public ArrayList<Scan> getAllScans(GetAllScansRequestDto getAllScansRequestDto);

    public Scan getScan(GetScanRequestDto getScanRequestDto);

    public String scanBadge(OnScanBadgeDto onScanBadgeDto);
}
