package controllers;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import dtos.ScanDto;
import dtos.ScanListDto;
import entities.Scan;
import interfaces.IScanController;
import interfaces.IScanInteractor;
import mappers.*;
import responses.ControllerResponse;

public class ScanController implements IScanController {
    private IScanInteractor scanInteractor;

    public ScanController(IScanInteractor scanInteractor) {
        this.scanInteractor = scanInteractor;

    }

    public String onGetAllScans(String jsonInput) {
        try {
            GetAllScansRequestDto request = ScanMapper.fromJsonToGetAllScansRequestDto(jsonInput);

            ArrayList<Scan> scans = scanInteractor.getAllScans(request);

            ControllerResponse response = new ControllerResponse("Success", "", "",
                    ScanMapper.fromScanListToJsonResponseDto(scans));
            return response.toJson();

        } catch (Exception e) {
            ControllerResponse response = new ControllerResponse("Error", "", e.getMessage(), "");
            return response.toJson();
        }

    }

    public ScanDto onGetScan(int id) {
        Scan scan = scanInteractor.getScan(id);
        if (scan == null) {
            throw new Error("Impossible de trouver le scan");
        }
        return ScanMapper.fromScanToScanDto(scan);
    }

}
