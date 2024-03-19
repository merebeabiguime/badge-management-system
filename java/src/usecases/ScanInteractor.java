package usecases;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import dtos.GetScanRequestDto;
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
            throw new Error("Unauthorized role");
        }
        return scanRepository.getAllScans();
    }

    public Scan getScan(GetScanRequestDto getScanRequestDto) {
        if (getScanRequestDto.getUserRole() != 1) {
            throw new Error("Unauthorized role");
        }
        Scan response = scanRepository.getScan(getScanRequestDto.getId());
        if (response == null) {
            throw new Error("Scan not found");
        }
        return response;
    }

}