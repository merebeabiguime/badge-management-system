package usecases;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import dtos.GetScanRequestDto;
import dtos.OnScanBadgeRequestDto;
import dtos.RegisterScanResponseDto;
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

    public String scanBadge(OnScanBadgeRequestDto onScanBadgeDto) {
        RegisterScanResponseDto response = scanRepository.registerScan(onScanBadgeDto.getBadgeId());
        if (response.getUserId() == null) {
            throw new Error("This badge has not been registered yet");
        }
    }

}