package dtos;

public class OnScanBadgeRequestDto {
    private Integer badgeId;

    public OnScanBadgeRequestDto() {
        this.badgeId = null;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }
}
