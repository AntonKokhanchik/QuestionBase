package questionbase.backend.service;

import com.github.dozermapper.core.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionbase.backend.entity.AnswerEntity;
import questionbase.backend.entity.CommentEntity;
import questionbase.backend.entity.QuestionEntity;
import questionbase.backend.repository.QuestionRepository;
import questionbase.frontend.dto.Answer;
import questionbase.frontend.dto.Comment;
import questionbase.frontend.dto.Question;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    Mapper mapper;

    @PostConstruct
    public void initialize() {
        LOG.info("Question service online");
    }

    @Override
    @Transactional
    public void create(Question question) {
        QuestionEntity e = questionRepository.save(mapper.map(question, QuestionEntity.class));
        LOG.info("Question created {}", e);
    }

    @Override
    @Transactional
    public void update(Question question) {
        QuestionEntity e = questionRepository.save(mapper.map(question, QuestionEntity.class));
        LOG.info("Question updated {}", e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        questionRepository.deleteById(id);
        LOG.info("Question deleted by id {}", id);
    }

    @Override
    public Question find(Long id) {
        return questionRepository.findById(id).map(e -> mapper.map(e, Question.class)).orElse(null);
    }

    @Override
    public List<Question> findAll() {
        Iterable<QuestionEntity> entities = questionRepository.findAll();
        List<Question> questions = new LinkedList<>();

        for (QuestionEntity e : entities)
            questions.add(mapper.map(e,Question.class));

        return questions;
    }

    @Override
    public List<Comment> findCommentsByQuestionId(Long id) {
        QuestionEntity question = questionRepository.findById(id).orElse(null);
        if (question == null)
            return new LinkedList<>();

        List<CommentEntity> entities = question.getComments();
        List<Comment> comments = new LinkedList<>();

        for (CommentEntity e : entities)
            comments.add(mapper.map(e, Comment.class));

        return comments;
    }

    @Override
    public List<Answer> findAnswersByQuestionId(Long id) {
        QuestionEntity question = questionRepository.findById(id).orElse(null);
        if (question == null)
            return new LinkedList<>();

        List<AnswerEntity> entities = question.getAnswers();
        List<Answer> answers = new LinkedList<>();

        for (AnswerEntity e : entities)
            answers.add(mapper.map(e, Answer.class));

        return answers;
    }
}
