package entities;

import java.time.LocalDateTime;

public class Scan {

    private int id;
    private LocalDateTime date;
    private String hour;
    private Integer userId;
    private boolean accessApproved;

    public Scan(int id, LocalDateTime date, String hour, Integer userId, boolean accessApproved) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.userId = userId;
        this.accessApproved = accessApproved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean getAccessApproved() {
        return accessApproved;
    }

    public void setAccessApproved(boolean accessApproved) {
        this.accessApproved = accessApproved;
    }

}
