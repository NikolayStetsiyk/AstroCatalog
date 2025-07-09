package webapp.astrocatalog.DAO;

import org.springframework.data.annotation.Id;

public class BaseEntity <T>{

    private T Id;

    public T getId() {
        return Id;
    }

    public void setId(T id) {
        Id = id;
    }
}
