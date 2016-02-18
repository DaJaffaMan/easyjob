package easyjob.handlers;

import easyjob.entities.Ad;
import easyjob.repositories.AdRepository;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.inject.Inject;
import java.math.BigDecimal;

@Component
public class PostAdHandler implements Route {

    private final AdRepository adRepository;

    @Inject
    public PostAdHandler(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public Object handle(Request request, Response response) throws Exception {

        String email = request.params(":email");
        String adTitle = request.params(":adTitle");
        String adDescription = request.params(":adDescription");
        BigDecimal fee = new BigDecimal(Double.parseDouble(request.params(":fee")));
        double lat = Double.parseDouble(request.params(":lat"));
        double lon = Double.parseDouble(request.params(":lon"));

        adRepository.save(new Ad(email, adTitle, adDescription, fee, lat, lon));

        return "ad added";
    }

}
