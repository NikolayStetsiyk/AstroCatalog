package web_app.astrocatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import web_app.astrocatalog.repository.CommentsRepository;

public class Comments_Service  {


    private CommentsRepository commentsRepository;

    public Comments_Service(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
}
