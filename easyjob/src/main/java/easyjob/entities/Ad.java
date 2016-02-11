package easyjob.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "easyjob", type = "ads")
public class Ad {

    @Id
    private int adId;
    private String email;
    private String adTitle;
    private String adDescription;

    private Ad(int adId, String email, String adTitle, String adDescription) {
        this.adId = adId;
        this.email = email;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
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
