package webapp.astrocatalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    public Article SaveArticle(@RequestBody Article article) {
                return article_service.CreateArticle(article);
    }

    @GetMapping("articles")
    public List<Article> getAllArticles() {
        System.out.println("Получен запрос на получение всех статей");
        List<Article> articles = article_service.getAllArticles();
        System.out.println("Найдено статей: " + articles.size());
        return articles;
    }

    @GetMapping("article")
    public Article getArticleByTitle(@RequestParam String title) {
        return article_service.GetArticleByTitle(title);
    }

    @GetMapping("getArtickle/{id}")
    public Article GetArticleById(@PathVariable  String id) {
        return article_service.GetArticleById(id);
    }

    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Article UpdateArticle(@PathVariable String id, @RequestBody Article article) {
        return article_service.UpdateArticle(id, article);
    }

    @DeleteMapping("deleteAll")
    @ResponseStatus(HttpStatus.OK)
    public void  Delete() {
        article_service.DeleteAllArticles();
    }

    @DeleteMapping("delete/{id}")
    public void DeleteArticleById(@PathVariable  String id) {
        article_service.DeleteArticleById(id);
    }
}


