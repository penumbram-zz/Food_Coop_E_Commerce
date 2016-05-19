package rest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import lombok.Data;

/**
 * Created by tolgacaner on 10/05/16.
 */
@Data
@Entity
public class News extends AbstractTimestampEntity {

    public News() {
        onCreate();
    }

    public News(String name, String description, String photoUrl) {
        onCreate();
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    @Id
    @GeneratedValue
    private int id;
    private Date timestamp;
    private String name;
    private String description;
    private String photoUrl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
