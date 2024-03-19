package usecases;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import entities.Scan;
import interfaces.IScanInteractor;
import interfaces.IScanRepository;

public class ScanInteractor implements IScanInteractor {
    private IScanRepository scanRepository;

    public ScanInteractor(IScanRepository scanRepository) {
        this.scanRepository = scanRepository;
    }

    public ArrayList<Scan> getAllScans(GetAllScansRequestDto getAllScansRequestDto) {
        if (getAllScansRequestDto.getUserRole() != 1) {
            return new ArrayList<>();
        }
        return scanRepository.getAllScans();
    }

    public Scan getScan(int id) {
        return scanRepository.getScan(id);
    }

}