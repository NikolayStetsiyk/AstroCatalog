package web_app.astrocatalog.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.yaml.snakeyaml.tokens.Token;

@NoRepositoryBean
public interface baseRepository<T,ID> extends MongoRepository<T, String> {
}
