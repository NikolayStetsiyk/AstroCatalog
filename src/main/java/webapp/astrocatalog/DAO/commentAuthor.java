package webapp.astrocatalog.DAO;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.Name;

public class commentAuthor {

    @NotNull
    private String id;
    @NotNull
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
