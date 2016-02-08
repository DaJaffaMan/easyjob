package easyjob.transformer;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import spark.ResponseTransformer;

@Component
public class JsonTransformer implements ResponseTransformer {

    private final Gson gson = new Gson();

    public String render(Object model) throws Exception {
        return gson.toJson(model);
    }
}
