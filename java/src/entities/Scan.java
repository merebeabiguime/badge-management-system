package entities;

import java.util.Date;

public class Scan {

    private int id;
    private Date date;
    private String hour;
    private Integer userId;
    private boolean accessApproved;

    public Scan(int id, Date date, String hour, Integer userId, boolean accessApproved) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
