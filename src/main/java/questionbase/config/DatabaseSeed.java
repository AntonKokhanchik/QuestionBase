package questionbase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import questionbase.backend.entity.AnswerEntity;
import questionbase.backend.entity.CommentEntity;
import questionbase.backend.entity.QuestionEntity;
import questionbase.backend.repository.AnswerRepository;
import questionbase.backend.repository.CommentRepository;
import questionbase.backend.repository.QuestionRepository;

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

    @Override
    public void run(String... args) throws Exception {
        questionRepository.deleteAll();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            QuestionEntity q = new QuestionEntity();
            q.setText("This is a difficult question with id " + (i+1));
            q.setMulti(random.nextBoolean());
            q = questionRepository.save(q);

            int rights = 0;
            for (int j = 0; j < random.nextInt(4)+2; j++) {
                AnswerEntity a = new AnswerEntity();
                a.setText("Answer number " + (j+1) + " for question " + (i+1));
                if (q.getMulti()) {
                    a.setRight(random.nextBoolean());
                    rights++;
                }
                else
                    a.setRight(j == 1);
                a.setQuestion(q);
                answerRepository.save(a);
            }

            if (!q.getMulti() && rights == 0)
                questionRepository.findById(q.getId()).ifPresent(q1 -> {
                   q1.getAnswers().get(random.nextInt(q1.getAnswers().size())).setRight(true);
                });

            for (int j = 0; j < random.nextInt(5) - 2; j++) {
                CommentEntity c = new CommentEntity();
                c.setAuthor("Some author with strange digit name " + random.nextInt(999999));
                c.setText("Some awesome comment with number " + (j+1) + " for question " + (i+1));
                c.setCreationTime(LocalDateTime.now());
                c.setQuestion(q);
                commentRepository.save(c);
            }
        }
    }
}
