package controllers;

import java.util.ArrayList;

import dtos.ScanDto;
import dtos.ScanListDto;
import entities.Scan;
import interfaces.IScanController;
import interfaces.IScanInteractor;
import mappers.*;

public class ScanController implements IScanController {
    private IScanInteractor scanInteractor;

    public ScanController(IScanInteractor scanInteractor, int userRole) {
        if (userRole != 1) {
            throw new Error("Vous n'avez pas le droit d'accéder à cette ressource");
        }
        this.scanInteractor = scanInteractor;

    }

    public ScanListDto onGetAllScans() {
        ArrayList<Scan> scans = scanInteractor.getAllScans();
        return ScanMapper.fromScanListToScanListDto(scans);
    }

    public ScanDto onGetScan(int id) {
        Scan scan = scanInteractor.getScan(id);
        if (scan == null) {
            throw new Error("Impossible de trouver le scan");
        }
        return ScanMapper.fromScanToScanDto(scan);
    }

}
