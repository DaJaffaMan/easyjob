package easyjob.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "easyjob", type = "ads")
public class Ad {

    @Id
    private int adId;
    private String username;
    private String adTitle;
    private String adDescription;

    private Ad(int adId, String username, String adTitle, String adDescription) {
        this.adId = adId;
        this.username = username;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
