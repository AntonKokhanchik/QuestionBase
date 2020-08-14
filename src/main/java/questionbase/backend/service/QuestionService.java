package questionbase.backend.service;

import questionbase.frontend.dto.Answer;
import questionbase.frontend.dto.Comment;
import questionbase.frontend.dto.Question;

import java.util.List;

public interface QuestionService {
    void create(Question question);
    void update(Question question);
    void delete(Long id);
    Question find(Long id);
    List<Question> findAll();
    List<Comment> findCommentsByQuestionId(Long id);
    List<Answer> findAnswersByQuestionId(Long id);
}
