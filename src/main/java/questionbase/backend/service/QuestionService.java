package questionbase.backend.service;

import questionbase.frontend.dto.Question;

public interface QuestionService {
    void create (Question question);
    void update (Question question);
    void delete (Long id);
    Question find (Long id);
    Question findAll();
}
