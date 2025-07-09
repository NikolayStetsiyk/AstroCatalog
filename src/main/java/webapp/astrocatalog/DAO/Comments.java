package webapp.astrocatalog.DAO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection = "comments")
public class Comments extends  BaseEntity<String> {
    @Id
    private String id;
    private commentAuthor author;
    private String text;
    private String createdAT;
    private String updatedAT;
    private int likes;
    private int dislikes;



    public commentAuthor getAuthor() {
        return author;
    }

    public void setAuthor(commentAuthor author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(String createdAT) {
        this.createdAT = createdAT;
    }

    public String getUpdatedAT() {
        return updatedAT;
    }

    public void setUpdatedAT(String updatedAT) {
        this.updatedAT = updatedAT;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return likes == comments.likes && dislikes == comments.dislikes && Objects.equals(id, comments.id) && Objects.equals(author, comments.author) && Objects.equals(text, comments.text) && Objects.equals(createdAT, comments.createdAT) && Objects.equals(updatedAT, comments.updatedAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, createdAT, updatedAT, likes, dislikes);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

}
