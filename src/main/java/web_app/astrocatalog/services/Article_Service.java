package web_app.astrocatalog.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web_app.astrocatalog.DAO.Article;
import web_app.astrocatalog.repository.ArticleRepository;

import java.util.List;

@Service
public class Article_Service {

    private final ArticleRepository articleRepository;
    public Article_Service(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article CreateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    public Article UpdateArticle(String id, Article article) {

        boolean exists = articleRepository.existsById(id);
        if (!exists) {
            return null;
        }
        if (articleRepository.existsById(id)) {
            return articleRepository.save(article);
        }
        return articleRepository.save(article);
    }

    public Article GetArticleByTitle(String title) {

        return articleRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Article> getAllArticles() {

        return articleRepository.findAll();
    }

    public void DeleteAllArticles() {
        articleRepository.deleteAll();
    }

    public void DeleteArticleById(String id) {
        articleRepository.deleteById(id);
    }

    public Article GetArticleById(String id) {
        return articleRepository.findById(id).get();
    }
}
