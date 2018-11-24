package vn.hcmute.onlineshop.model.dto;

import java.io.Serializable;
import java.util.Date;

public class EventDto implements Serializable {
    private long id;
    private String name;
    private String content;
    private Date startDate;
    private Date endDate;

    public EventDto() {
    }

    public EventDto(long id, String name, String content, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public <R> EventDto(long id, String username, String password, String name, String phone, String email, R collect) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
