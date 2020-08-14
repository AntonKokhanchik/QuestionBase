package questionbase.backend.service;

import questionbase.frontend.dto.Answer;

import java.util.List;

public interface AnswerService {
    void create (Answer answer, Long questionId);
    void update (Answer answer);
    void delete (Long id);
    Answer find (Long id);
    List<Answer> findAll();
}
