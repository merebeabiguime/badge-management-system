package dtos;

public class WaitForBadgeChangeRequestDto {
    private long timeout;

    public WaitForBadgeChangeRequestDto() {
        this.timeout = 0;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
