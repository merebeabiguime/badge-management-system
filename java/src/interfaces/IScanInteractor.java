package interfaces;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import entities.Scan;

public interface IScanInteractor {
    public ArrayList<Scan> getAllScans(GetAllScansRequestDto getAllScansRequestDto);

    public Scan getScan(int id);
}
