package easyjob.handlers;

import easyjob.entities.Ad;
import easyjob.repositories.AdRepository;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.inject.Inject;
import java.util.List;

@Component
public class GetAdByAdIdHandler implements Route {

    private final AdRepository adRepository;

    @Inject
    public GetAdByAdIdHandler(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public Object handle(Request request, Response response) throws Exception {

        final int adId = Integer.parseInt(request.params(":adId"));
        final List<Ad> ads = adRepository.findAdByAdId(adId);

        return ads;
    }

}