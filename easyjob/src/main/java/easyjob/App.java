package easyjob;

import easyjob.config.DatabaseConfig;
import easyjob.filter.CorsFilter;
import easyjob.handlers.GetAdByAdIdHandler;
import easyjob.handlers.GetAdByAdTitleHandler;
import easyjob.handlers.PostAdHandler;
import easyjob.transformer.JsonTransformer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static spark.Spark.*;

public class App {

    public static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        final GetAdByAdIdHandler adByAdIdHandler = context.getBean(GetAdByAdIdHandler.class);
        final PostAdHandler postAdHandler = context.getBean(PostAdHandler.class);
        final GetAdByAdTitleHandler adByAdTitleHandler = context.getBean(GetAdByAdTitleHandler.class);

        final JsonTransformer transformer = context.getBean(JsonTransformer.class);

        final String appPort = System.getProperty("app.port", "5000");
        port(Integer.valueOf(appPort));


        CorsFilter.apply();
        get("/get/ad/:adId", adByAdIdHandler, transformer);

        get("/get/ad/title/:adTitle", adByAdTitleHandler, transformer);

        post("/post/ad/:adId/:email/:adTitle/:adDescription", postAdHandler);
    }
}
