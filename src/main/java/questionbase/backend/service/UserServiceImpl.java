package questionbase.backend.service;

import com.github.dozermapper.core.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionbase.backend.entity.CommentEntity;
import questionbase.backend.entity.UserEntity;
import questionbase.backend.repository.UserRepository;
import questionbase.frontend.dto.Comment;
import questionbase.frontend.dto.User;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    Mapper mapper;

    @Override
    @Transactional
    public void create(User user) {
        UserEntity savedEntity = userRepository.save(mapper.map(user, UserEntity.class));
        LOG.info("User created {}", savedEntity);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.findById(user.getLogin()).ifPresent(u -> {
            u.setFullName(user.getFullName());
            u.setPassword(user.getPassword());
            UserEntity savedEntity = userRepository.save(u);
            LOG.info("User updated {}", savedEntity);
        });
    }

    @Override
    @Transactional
    public void delete(String login) {
        userRepository.deleteById(login);
        LOG.info("User deleted by login {}", login);
    }

    @Override
    public User find(String login) {
        return userRepository.findById(login).map(e -> mapper.map(e, User.class)).orElse(null);
    }

    @Override
    public List<User> findAll() {
        Iterable<UserEntity> entities = userRepository.findAll();
        List<User> users = new LinkedList<>();

        for (UserEntity e : entities)
            users.add(mapper.map(e, User.class));

        return users;
    }

    @Override
    public List<Comment> findCommentsByUserLogin(String login) {
        UserEntity user = userRepository.findById(login).orElse(null);
        if (user == null)
            return new LinkedList<>();

        List<CommentEntity> entities = user.getComments();
        List<Comment> comments = new LinkedList<>();

        for (CommentEntity e : entities)
            comments.add(mapper.map(e, Comment.class));

        return comments;
    }

    @Override
    public User verify(User user) throws Exception {
        UserEntity userEntity = userRepository.findById(user.getLogin()).orElse(null);
        if (userEntity == null) {
            throw new Exception("WRONG_LOGIN");
        }

        if (!user.getPassword().equals(userEntity.getPassword())) {
            throw new Exception("WRONG_PASSWORD");
        }

        LOG.info("User logged in: {}", userEntity);
        return mapper.map(userEntity, User.class);
    }
}
