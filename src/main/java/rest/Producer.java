package rest;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by tolgacaner on 01/05/16.
 */
public class Producer extends Member {

    public Producer() {
        super();
    }

    private String companyName;
    private String farmsInformation;
    private List<ProductCategory> productCategories;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFarmsInformation() {
        return farmsInformation;
    }

    public void setFarmsInformation(String farmsInformation) {
        this.farmsInformation = farmsInformation;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

}
