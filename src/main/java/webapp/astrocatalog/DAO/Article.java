package webapp.astrocatalog.DAO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.util.List;
import java.util.Objects;

@Document(collection = "article")
public class Article extends BaseEntity<String> {

    @Id
    @NotNull
    private String id;
    @NotNull (message = "not empty parametr")
    @NotBlank (message = "title is mandatory")
    private String title;
    @NotNull
    @Field("authors")
    private List<Author> authors;
    private List<String> tags;

    @NotNull
    private String content;
    @NotNull
    private String createdAT;
    @NotNull
    private String updatedAT;
    @NotNull
    private String commentid;

    public String getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(String createdAT) {
        this.createdAT = createdAT;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getUpdatedAT() {
        return updatedAT;
    }

    public void setUpdatedAT(String updatedAT) {
        this.updatedAT = updatedAT;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(authors, article.authors) && Objects.equals(content, article.content) && Objects.equals(createdAT, article.createdAT) && Objects.equals(updatedAT, article.updatedAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, content, createdAT, updatedAT);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}

