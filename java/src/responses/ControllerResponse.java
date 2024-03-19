package responses;

import interfaces.IControllerResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControllerResponse implements IControllerResponse {

    @JsonProperty("status")
    private String status;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private String data;

    public ControllerResponse(String status, String code, String message, String data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;

    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            // Handle serialization exception
            e.printStackTrace();
            return "{\"error\": \"Failed to serialize response object to JSON\"}";
        }
    }

}
