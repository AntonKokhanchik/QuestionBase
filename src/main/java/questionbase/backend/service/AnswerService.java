package questionbase.backend.service;

import questionbase.frontend.dto.Answer;

public interface AnswerService {
    void create (Answer question);
    void update (Answer question);
    void delete (Long id);
    Answer find (Long id);
    Answer findAll();
}
