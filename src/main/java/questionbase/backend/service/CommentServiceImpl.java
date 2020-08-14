package questionbase.backend.service;

import com.github.dozermapper.core.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionbase.backend.entity.CommentEntity;
import questionbase.backend.repository.CommentRepository;
import questionbase.backend.repository.QuestionRepository;
import questionbase.frontend.dto.Comment;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private static final Logger LOG = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    Mapper mapper;

    @PostConstruct
    public void initialize() {
        LOG.info("Comment service online");
    }

    @Override
    @Transactional
    public void create(Comment comment, Long questionId) {
        comment.setCreationTime(LocalDateTime.now());
        CommentEntity commentEntity = mapper.map(comment, CommentEntity.class);
        questionRepository.findById(questionId).ifPresent(q -> {
            commentEntity.setQuestion(q);
            CommentEntity savedEntitiy = commentRepository.save(commentEntity);
            LOG.info("Comment created {}", savedEntitiy);
        });
    }

    @Override
    @Transactional
    public void update(Comment comment) {
        CommentEntity e = commentRepository.save(mapper.map(comment, CommentEntity.class));
        LOG.info("Comment updated {}", e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        commentRepository.deleteById(id);
        LOG.info("Comment deleted by id {}", id);
    }

    @Override
    public Comment find(Long id) {
        return commentRepository.findById(id).map(e -> mapper.map(e, Comment.class)).orElse(null);
    }

    @Override
    public List<Comment> findAll() {
        Iterable<CommentEntity> entities = commentRepository.findAll();
        List<Comment> comments = new LinkedList<>();

        for (CommentEntity e : entities)
            comments.add(mapper.map(e, Comment.class));

        return comments;
    }
}
