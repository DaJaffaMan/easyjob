package easyjob.repositories.ads;

import easyjob.categories.Category;
import easyjob.entities.Ad;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface AdRepository extends ElasticsearchCrudRepository<Ad, Integer> {

    List<Ad> findAdByTitleLike(String title);

    List<Ad> findAdByCategory(Category category);

}
