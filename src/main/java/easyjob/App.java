package easyjob;

import easyjob.config.DatabaseConfig;
import easyjob.handlers.GetAdByAdIdHandler;
import easyjob.handlers.PostAdHandler;
import easyjob.transformer.JsonTransformer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {

    public static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        final GetAdByAdIdHandler adByAdIdHandler = context.getBean(GetAdByAdIdHandler.class);
        final PostAdHandler postAdHandler = context.getBean(PostAdHandler.class);

        final JsonTransformer transformer = context.getBean(JsonTransformer.class);

        get("/get/ad/:adId", adByAdIdHandler, transformer);

        post("/post/ad/:adId/:email/:adTitle/:adDescription", postAdHandler);
    }
}
