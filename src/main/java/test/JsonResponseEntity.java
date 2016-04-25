package test;

import javax.persistence.Entity;

/**
 * Created by tolgacaner on 26/04/16.
 */
@Entity
public class JsonResponseEntity {
    String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
