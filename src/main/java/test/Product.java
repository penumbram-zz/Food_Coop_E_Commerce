package test;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tolgacaner on 26/04/16.
 */
public class Product extends AbstractTimestampEntity {

    public Product() {
        onCreate();
    }

    public Product(String productName, String productDescription, String photoUrl, String price, String sellUnit, String quantity) {
        onCreate();
        this.productName = productName;
        this.productDescription = productDescription;
        this.photoUrl = photoUrl;
        this.price = price;
        this.sellUnit = sellUnit;
        this.quantity = quantity;
    }

    @Id
    private int id;
    private Date timestamp;
    private String productName;
    private String productDescription;
    private String photoUrl;
    private String price;
    private String sellUnit;
    private String quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSellUnit() {
        return sellUnit;
    }

    public void setSellUnit(String sellUnit) {
        this.sellUnit = sellUnit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
