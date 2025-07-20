package webapp.astrocatalog.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import webapp.astrocatalog.DAO.Article;
import webapp.astrocatalog.repository.ArticleRepository;

import java.util.List;

@Service
public class Article_Service {

    private final ArticleRepository articleRepository;
    public Article_Service(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article CreateArticle(Article article) {
        if (!articleRepository.existsById(article.getId())) {
            return articleRepository.save(article);
        }else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Article already exists");
        }
    }

    @Transactional
    public Article UpdateArticle(String id, Article article) {

        boolean exists = articleRepository.existsById(id);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found");
        }
        return articleRepository.save(article);
    }

    public Article GetArticleByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title is empty");
        }

        Article result = articleRepository.findByTitleContainingIgnoreCase(title);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article with this title not found");
        }

            return articleRepository.findByTitleContainingIgnoreCase(title);

    }

    public Article GetArticleById(String id) {
        if (!articleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article with such ID not found");
        }
        return articleRepository.findById(id).get();
    }

    public List<Article> getAllArticles() {

        try {
            return articleRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "no articles found");
        }

    }

    public void DeleteAllArticles() {
        articleRepository.deleteAll();
    }

    public void DeleteArticleById(String id) {
        if (!articleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article with such ID not found");
        }
        articleRepository.deleteById(id);
    }


}
