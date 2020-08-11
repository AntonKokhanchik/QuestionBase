package questionbase.backend.service;

import questionbase.frontend.dto.Question;

import java.util.List;

public interface QuestionService {
    void create (Question question);
    void update (Question question);
    void delete (Long id);
    Question find (Long id);
    List<Question> findAll();
}
