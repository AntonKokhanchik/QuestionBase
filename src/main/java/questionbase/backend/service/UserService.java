package questionbase.backend.service;

import questionbase.frontend.dto.Comment;
import questionbase.frontend.dto.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(String login);
    User find(String login);
    List<User> findAll();
    List<Comment> findCommentsByUserLogin(String login);
    User verify(User user) throws Exception;
}
