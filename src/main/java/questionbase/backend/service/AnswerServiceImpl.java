package questionbase.backend.service;

import com.github.dozermapper.core.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionbase.backend.entity.AnswerEntity;
import questionbase.backend.repository.AnswerRepository;
import questionbase.backend.repository.QuestionRepository;
import questionbase.frontend.dto.Answer;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private static final Logger LOG = LoggerFactory.getLogger(AnswerServiceImpl.class);

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    Mapper mapper;

    @PostConstruct
    public void initialize() {
        LOG.info("Answer service online");
    }

    @Override
    @Transactional
    public void create(Answer answer, Long questionId) {
        AnswerEntity answerEntity = mapper.map(answer, AnswerEntity.class);
        questionRepository.findById(questionId).ifPresent(q -> {
            answerEntity.setQuestion(q);
            AnswerEntity savedEntitiy = answerRepository.save(answerEntity);
            LOG.info("Answer created {}", savedEntitiy);
        });
    }

    @Override
    @Transactional
    public void update(Answer answer) {
        answerRepository.findById(answer.getId()).ifPresent(a -> {
            a.setText(answer.getText());
            a.setRight(answer.getRight());
            AnswerEntity savedEntity = answerRepository.save(a);
            LOG.info("Answer updated {}", savedEntity);
        });
    }

    @Override
    @Transactional
    public void delete(Long id) {
        answerRepository.deleteById(id);
        LOG.info("Comment deleted by id {}", id);
    }

    @Override
    public Answer find(Long id) {
        return answerRepository.findById(id).map(e -> mapper.map(e, Answer.class)).orElse(null);
    }

    @Override
    public List<Answer> findAll() {
        Iterable<AnswerEntity> entities = answerRepository.findAll();
        List<Answer> answers = new LinkedList<>();

        for (AnswerEntity e : entities)
            answers.add(mapper.map(e, Answer.class));

        return answers;
    }
}
