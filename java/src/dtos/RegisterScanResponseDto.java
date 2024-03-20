package dtos;

public class RegisterScanResponseDto {

    private Integer userId;
    private String startHour;
    private String endHour;

    public RegisterScanResponseDto() {
        this.userId = null;
        this.startHour = null;
        this.endHour = null;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

}
