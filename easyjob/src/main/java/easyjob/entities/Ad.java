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
    private String title;
    private String description;
    private BigDecimal fee;
    private GeoPoint location;
    private Category category;

    public Ad() {

    }

    public Ad(String email, String title, String description, BigDecimal fee, GeoPoint location) {
        this.email = email;
        this.title = title;
        this.description = description;
        this.fee = fee;
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
