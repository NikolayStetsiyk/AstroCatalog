package webapp.astrocatalog.DAO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


public class Author {

    @NotNull
    @NotBlank
    private String authorId;
    @NotNull
    private String authorName;
    @Email
    @NotNull
    private String authorEmail;
    @NotNull
    private String rating;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId) && Objects.equals(authorName, author.authorName) && Objects.equals(authorEmail, author.authorEmail) && Objects.equals(rating, author.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, authorEmail, rating);
    }
}
