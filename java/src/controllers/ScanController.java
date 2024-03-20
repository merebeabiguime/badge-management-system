package controllers;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import dtos.GetScanRequestDto;
import dtos.OnScanBadgeRequestDto;
import entities.Scan;
import interfaces.IScanController;
import interfaces.IScanInteractor;
import mappers.ScanMapper;
import responses.ControllerResponse;

public class ScanController implements IScanController {
    private IScanInteractor scanInteractor;

    public ScanController(IScanInteractor scanInteractor) {
        this.scanInteractor = scanInteractor;

    }

    public String onGetAllScans(String jsonInput) {
        ControllerResponse response;
        try {
            GetAllScansRequestDto request = ScanMapper.fromJsonToGetAllScansRequestDto(jsonInput);

            ArrayList<Scan> scans = scanInteractor.getAllScans(request.getUserRole());

            response = new ControllerResponse("Success", "", "",
                    ScanMapper.fromScanListToJsonResponseDto(scans));
            return response.toJson();

        } catch (Throwable t) {
            response = new ControllerResponse("Error", "", t.getMessage(), "");
            return response.toJson();
        }

    }

    public String onGetScan(String jsonInput) {
        ControllerResponse response;
        try {
            GetScanRequestDto request = ScanMapper.fromJsonToGetScanRequestDto(jsonInput);

            Scan scan = scanInteractor.getScan(request.getUserRole(), request.getId());

            response = new ControllerResponse("Success", "", "",
                    ScanMapper.fromScanToJsonResponseDto(scan));
            return response.toJson();

        } catch (Throwable t) {
            response = new ControllerResponse("Error", "", t.getMessage(), "");
            return response.toJson();
        }
    }

    public String onScanBadge(String jsonInput) {
        ControllerResponse response;
        try {
            OnScanBadgeRequestDto request = ScanMapper.fromJsonToOnScanBadgeDto(jsonInput);

            Scan scan = scanInteractor.scanBadge(request.getBadgeId());

            response = new ControllerResponse("Success", "", "",
                    ScanMapper.fromScanToJsonResponseDto(scan));
            return response.toJson();

        } catch (Throwable t) {
            response = new ControllerResponse("Error", "", t.getMessage(), "");
            return response.toJson();
        }
    }

}
