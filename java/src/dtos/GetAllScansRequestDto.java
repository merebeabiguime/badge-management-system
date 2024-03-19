package dtos;

public class GetAllScansRequestDto {

    private Integer userRole;

    public GetAllScansRequestDto() {
        this.userRole = null;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

}
