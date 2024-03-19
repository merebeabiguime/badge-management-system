package mappers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.GetAllScansRequestDto;
import dtos.GetScanRequestDto;
import entities.Scan;

public class ScanMapper {

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

    public static GetScanRequestDto fromJsonToGetScanRequestDto(String json) {
        GetScanRequestDto getScanRequestDto = new GetScanRequestDto();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JsonNode jsonNode = mapper.readTree(json);
            JsonNode userRoleNode = jsonNode.get("userRole");
            JsonNode idNode = jsonNode.get("id");

            if (userRoleNode != null && userRoleNode.isNumber() && idNode != null && idNode.isNumber()) {
                int userRole = userRoleNode.asInt();
                int id = idNode.asInt();
                getScanRequestDto.setUserRole(userRole);
                getScanRequestDto.setId(id);
            }
            return getScanRequestDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String fromScanToJsonResponseDto(Scan scan) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(scan);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
