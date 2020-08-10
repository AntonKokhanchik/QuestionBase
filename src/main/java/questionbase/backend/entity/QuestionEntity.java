package questionbase.backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="QUESTIONS")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String author;
    private String text;
    private LocalDateTime creationTime;
    @OneToMany(mappedBy = "question", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AnswerEntity> answers = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }

    public void addAnswer(AnswerEntity answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void removeAnswer(AnswerEntity answer) {
        answer.setQuestion(null);
        answers.remove(answer);
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", creationTime=" + creationTime +
                ", answers=" + answers +
                '}';
    }
}
