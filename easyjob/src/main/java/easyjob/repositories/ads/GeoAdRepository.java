package easyjob.repositories.ads;

import easyjob.entities.Ad;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class GeoAdRepository {

    private final ElasticsearchTemplate elasticsearchTemplate;

    @Inject
    public GeoAdRepository(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public List<Ad> getGeoAd(GeoPoint geoPoint, int range) {

        final CriteriaQuery query = new CriteriaQuery(new Criteria("location").within(geoPoint, range+"km"));
        final List<Ad> ads = elasticsearchTemplate.queryForList(query, Ad.class);

        return ads;
    }
}
