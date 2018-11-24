package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "events")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Sp_GetEvents",
                procedureName = "Sp_GetEvents",
                resultClasses = Event.class,
                parameters = {
                        @StoredProcedureParameter(name="keyword", mode = ParameterMode.IN, type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Sp_AddEvent",
                procedureName = "Sp_AddEvent",
                resultClasses = Event.class
        ),
        @NamedStoredProcedureQuery(
                name = "Sp_DeleteEvent",
                procedureName = "Sp_DeleteEvent",
                resultClasses = Event.class
        )

})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String content;
    private Date startDate;
    private Date endDate;

    public Event() {
    }

    public Event(String name, String content, Date startDate, Date endDate) {
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
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
