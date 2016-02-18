package easyjob.entities;

import easyjob.categories.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.math.BigDecimal;

@Document(indexName = "easyjob", type = "ads")
public class Ad {

    @Id
    private String id;
    private String email;
    private String adTitle;
    private String adDescription;
    private BigDecimal fee;
    private GeoPoint location;
    private Category category;

    public Ad() {

    }

    public Ad(String email, String adTitle, String adDescription, BigDecimal fee, double lat, double lon) {
        this.email = email;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
        this.fee = fee;
        this.location = new GeoPoint(lat, lon);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdDescription() {
        return adDescription;
    }

    public void setAdDescription(String adDescription) {
        this.adDescription = adDescription;
    }
}
