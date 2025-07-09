package webapp.astrocatalog.services;

import webapp.astrocatalog.repository.CommentsRepository;

public class Comments_Service  {


    private CommentsRepository commentsRepository;

    public Comments_Service(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
}
