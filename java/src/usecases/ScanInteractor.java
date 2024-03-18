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

    @Override
    public ArrayList<Scan> getAllScans() {
        return scanRepository.getAllScans();
    }

    @Override
    public Scan getScan(int id) {
        return scanRepository.getScan(id);
    }

}