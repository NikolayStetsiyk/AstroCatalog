package webapp.astrocatalog.repository;

import org.springframework.data.mongodb.repository.Query;
import webapp.astrocatalog.DAO.Article;


public interface ArticleRepository extends baseRepository<Article, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    Article findByTitleContainingIgnoreCase(String title);

}

