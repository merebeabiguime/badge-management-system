package mappers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.GetAllScansRequestDto;
import dtos.ScanDto;
import dtos.ScanListDto;
import entities.Scan;

public class ScanMapper {

    public static ScanListDto fromScanListToScanListDto(ArrayList<Scan> scans) {
        ScanListDto scanListDto = new ScanListDto();
        for (Scan scan : scans) {
            scanListDto.getScanList().add("heure:" + scan.getHeure() + " date:" + scan.getDate() + " id_utilisateur:"
                    + scan.getId_utilisateur() + " tentative_acces:" + scan.getTentative_acces());
        }
        return scanListDto;
    }

    public static ScanDto fromScanToScanDto(Scan scan) {
        ScanDto scanDto = new ScanDto();
        scanDto.setScan("heure:" + scan.getHeure() + " date:" + scan.getDate() + " id_utilisateur:"
                + scan.getId_utilisateur() + " tentative_acces:" + scan.getTentative_acces());
        return scanDto;

    }

    public static GetAllScansRequestDto fromJsonToGetAllScansRequestDto(String json) {
        GetAllScansRequestDto getAllScansRequestDto = new GetAllScansRequestDto();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JsonNode jsonNode = mapper.readTree(json);
            JsonNode userRoleNode = jsonNode.get("userRole");

            if (userRoleNode != null && userRoleNode.isNumber()) {
                int userRole = userRoleNode.asInt();
                getAllScansRequestDto.setUserRole(userRole);
            }
            return getAllScansRequestDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String fromScanListToJsonResponseDto(ArrayList<Scan> scans) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(scans);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
