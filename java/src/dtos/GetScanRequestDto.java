package dtos;

public class GetScanRequestDto {

    private Integer userRole;
    private Integer id;

    public GetScanRequestDto() {
        this.userRole = null;
        this.id = null;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
