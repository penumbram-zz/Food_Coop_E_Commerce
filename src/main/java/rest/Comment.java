package rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by tolgacaner on 20/05/16.
 */
@Data
@Entity
public class Comment extends AbstractTimestampEntity {

    public Comment() {
        onCreate();
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    private Member member;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Product product;
}
