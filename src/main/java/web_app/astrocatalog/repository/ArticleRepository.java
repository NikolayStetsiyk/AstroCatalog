package web_app.astrocatalog.repository;

import org.springframework.data.mongodb.repository.Query;
import web_app.astrocatalog.DAO.Article;


public interface ArticleRepository extends baseRepository<Article, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    Article findByTitleContainingIgnoreCase(String title);

}

