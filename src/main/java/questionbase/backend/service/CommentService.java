package questionbase.backend.service;

import questionbase.frontend.dto.Comment;

import java.util.List;

public interface CommentService {
    void create (Comment comment, Long questionId, String authorLogin);
    void update (Comment comment);
    void delete (Long id);
    Comment find (Long id);
    List<Comment> findAll();
}
