package easyjob.handlers;

import easyjob.entities.Ad;
import easyjob.repositories.AdRepository;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.inject.Inject;

@Component
public class PostAdHandler implements Route {

    private final AdRepository adRepository;

    @Inject
    public PostAdHandler(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public Object handle(Request request, Response response) throws Exception {

        int adId = Integer.parseInt(request.params(":adId"));
        String email = request.params(":email");
        String adTitle = request.params(":adTitle");
        String adDescription = request.params(":adDescription");

        adRepository.save(new Ad(adId, email, adTitle, adDescription));

        return "ad added";
    }

}
