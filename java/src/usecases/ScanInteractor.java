package usecases;

import java.util.ArrayList;

import entities.Scan;
import interfaces.IScanInteractor;
import interfaces.IScanRepository;

public class ScanInteractor implements IScanInteractor {
    private IScanRepository scanRepository;

    public ScanInteractor(IScanRepository scanRepository) {
        this.scanRepository = scanRepository;
    }

    public ArrayList<Scan> getAllScans(int userRole) {
        if (userRole != 1) {
            throw new Error("Unauthorized role");
        }
        return scanRepository.getAllScans();
    }

    public Scan getScan(int userRole, int userId) {
        if (userRole != 1) {
            throw new Error("Unauthorized role");
        }
        Scan response = scanRepository.getScan(userId);
        if (response == null) {
            throw new Error("Scan not found");
        }
        return response;
    }

    public Scan scanBadge(int userId) {
        Scan response = scanRepository.registerScan(userId);
        if (response.getUserId() == null) {
            throw new Error("This badge has not been registered yet");
        }
        if (response.getAccessApproved() == false) {
            throw new Error("You are not authorized to scan this badge at this time");
        }
        return response;
    }

}