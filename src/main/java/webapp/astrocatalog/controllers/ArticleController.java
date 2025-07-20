package webapp.astrocatalog.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webapp.astrocatalog.DAO.Article;
import webapp.astrocatalog.services.Article_Service;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ArticleController {

    @Autowired
    private Article_Service article_service;

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "create")
    public Article SaveArticle(@RequestBody @Valid Article article) {
                return article_service.CreateArticle(article);
    }

    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Article UpdateArticle(@PathVariable String id, @RequestBody @Valid Article article) {
        return article_service.UpdateArticle(id, article);
    }


    @GetMapping("articles")
    @ResponseStatus(HttpStatus.OK)
    public List<Article> getAllArticles() {
            System.out.println("Получен запрос на получение всех статей");
            List<Article> articles = article_service.getAllArticles();
            System.out.println("Найдено статей: " + articles.size());
            return articles;
    }

    @GetMapping("article/{title}")
    public Article getArticleByTitle(@PathVariable String title) {
        return article_service.GetArticleByTitle(title);
    }

    @GetMapping("getArticle/{id}")
    public Article GetArticleById(@PathVariable  String id) {
        return article_service.GetArticleById(id);
    }


    @DeleteMapping("deleteAll")
    @ResponseStatus(HttpStatus.OK)
    public void  Delete() {
        try{
            article_service.DeleteAllArticles();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "delete all articles failed");
        }

    }

    @DeleteMapping("delete/{id}")
    public void DeleteArticleById(@PathVariable  String id) {
            article_service.DeleteArticleById(id);

    }
}


