package easyjob.repositories;

import easyjob.categories.Category;
import easyjob.entities.Ad;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface AdRepository extends ElasticsearchCrudRepository<Ad, Integer> {

    List<Ad> findAdByAdTitleLike(String adTitle);

    List<Ad> findAdByCategory(Category category);

}
