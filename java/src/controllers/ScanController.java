package controllers;

import java.util.ArrayList;

import dtos.GetAllScansRequestDto;
import dtos.GetScanRequestDto;
import dtos.OnScanBadgeRequestDto;
import dtos.WaitForBadgeChangeRequestDto;
import entities.Scan;
import interfaces.IScanController;
import interfaces.IScanInteractor;
import mappers.ScanMapper;
import responses.ControllerResponse;

public class ScanController implements IScanController {
    private IScanInteractor scanInteractor;
    private Integer badgeId;
    private ControllerResponse response;

    public ScanController(IScanInteractor scanInteractor) {
        this.scanInteractor = scanInteractor;

    }

    public String onGetAllScans(String jsonInput) {
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
        try {
            OnScanBadgeRequestDto request = ScanMapper.fromJsonToOnScanBadgeDto(jsonInput);

            this.badgeId = request.getBadgeId();
            notify();

            Scan scan = scanInteractor.scanBadge(request.getBadgeId());

            response = new ControllerResponse("Success", "", "",
                    ScanMapper.fromScanToJsonResponseDto(scan));
            return response.toJson();

        } catch (Throwable t) {
            response = new ControllerResponse("Error", "", t.getMessage(), "");
            return response.toJson();
        }
    }

    public synchronized String waitForBadgeChange(String jsonInput) {
        try {
            WaitForBadgeChangeRequestDto request = ScanMapper.fromJsonToWaitForBadgeChangeDto(jsonInput);
            wait(request.getTimeout());
        } catch (InterruptedException e) {
            response = new ControllerResponse("Error", "", e.getMessage(), "");
            return response.toJson();
        }
        if (this.badgeId == null) {
            response = new ControllerResponse("Error", "", "No badge scanned", "");
            return response.toJson();
        }
        response = new ControllerResponse("Success", "", "", "{\"badgeId\":" + this.badgeId + "}");
        return response.toJson();
    }
}
