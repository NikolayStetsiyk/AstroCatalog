package webapp.astrocatalog.DAO;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection = "comments")
public class Comments extends  BaseEntity<String> {

    @NotNull
    private String commentId;
    @NotNull
    private String userId;
    @NotNull
    private String userName;
    @NotNull
    private String commentDate;
    @NotNull
    private String commentTime;
    @NotNull
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(commentId, comments.commentId) && Objects.equals(userId, comments.userId) && Objects.equals(userName, comments.userName) && Objects.equals(commentDate, comments.commentDate) && Objects.equals(commentTime, comments.commentTime) && Objects.equals(comment, comments.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, userId, userName, commentDate, commentTime, comment);
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
