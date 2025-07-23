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

}
