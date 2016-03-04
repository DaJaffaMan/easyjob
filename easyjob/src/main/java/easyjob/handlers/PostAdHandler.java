package easyjob.handlers;

import com.google.gson.Gson;
import easyjob.entities.Ad;
import easyjob.repositories.AdRepository;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.inject.Inject;
import java.math.BigDecimal;

@Component
public class PostAdHandler implements Route {

    private final AdRepository adRepository;
    private final Gson gson;

    @Inject
    public PostAdHandler(AdRepository adRepository) {
        this.adRepository = adRepository;
        gson = new Gson();
    }

    public Object handle(Request request, Response response) throws Exception {

        String email = gson.fromJson(request.body(), Ad.class).getEmail();
        String title = gson.fromJson(request.body(), Ad.class).getTitle();
        String description = gson.fromJson(request.body(), Ad.class).getDescription();
        BigDecimal fee = new BigDecimal(Double.parseDouble(String.valueOf(gson.fromJson(request.body(), Ad.class).getFee())));
        double lat = gson.fromJson(request.body(), Ad.class).getLocation().getLat();
        double lon = gson.fromJson(request.body(), Ad.class).getLocation().getLon();
        GeoPoint location = new GeoPoint(lat, lon);

        adRepository.save(new Ad(email, title, description, fee, location));

        return "ad added";
    }

}
