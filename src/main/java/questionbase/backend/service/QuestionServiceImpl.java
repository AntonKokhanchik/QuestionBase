package questionbase.backend.service;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionbase.backend.entity.QuestionEntity;
import questionbase.backend.repository.QuestionRepository;
import questionbase.frontend.dto.Question;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    Mapper mapper;


    @Override
    @Transactional
    public void create(Question question) {
        question.setCreationTime(LocalDateTime.now());
        questionRepository.save(mapper.map(question, QuestionEntity.class));
    }

    @Override
    public void update(Question question) {
        questionRepository.save(mapper.map(question, QuestionEntity.class));
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question find(Long id) {
        return mapper.map(questionRepository.findById(id), Question.class);
    }

    @Override
    public List<Question> findAll() {
        List<QuestionEntity> entities = questionRepository.findAll();
        List<Question> questions = new LinkedList<>();

        for (QuestionEntity e : entities)
            questions.add(mapper.map(e,Question.class));

        return questions;
    }
}
