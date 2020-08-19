package questionbase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import questionbase.backend.entity.AnswerEntity;
import questionbase.backend.entity.CommentEntity;
import questionbase.backend.entity.QuestionEntity;
import questionbase.backend.entity.UserEntity;
import questionbase.backend.repository.AnswerRepository;
import questionbase.backend.repository.CommentRepository;
import questionbase.backend.repository.QuestionRepository;
import questionbase.backend.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DatabaseSeed implements CommandLineRunner {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        questionRepository.deleteAll();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            QuestionEntity q = new QuestionEntity();
            q.setText("This is a difficult question with id " + (i+1));
            q.setMulti(random.nextBoolean());
            q = questionRepository.save(q);

            for (int j = 0; j < random.nextInt(4)+2; j++) {
                AnswerEntity a = new AnswerEntity();
                a.setText("Answer number " + (j+1) + " for question " + (i+1));

                if(j == 1)
                    a.setRight(true);
                else if (q.getMulti())
                    a.setRight(random.nextBoolean());
                else
                    a.setRight(false);

                a.setQuestion(q);
                answerRepository.save(a);
            }

            for (int j = 0; j < random.nextInt(5) - 2; j++) {
                CommentEntity c = new CommentEntity();
                c.setAuthorName("Some author with strange digit name " + random.nextInt(999999));
                c.setText("Some awesome comment with number " + (j+1) + " for question " + (i+1));
                c.setCreationTime(LocalDateTime.now());
                c.setQuestion(q);
                commentRepository.save(c);
            }

            UserEntity admin = new UserEntity();
            admin.setLogin("admin");
            admin.setPassword("admin");
            admin.setFullName("System administrator");
            admin.setAdmin(true);
            userRepository.save(admin);
        }
    }
}
