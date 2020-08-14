package questionbase.backend.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="QUESTIONS")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String text;
    @OneToMany(mappedBy = "question", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CommentEntity> comments = new LinkedList<>();
    @OneToMany(mappedBy = "question", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AnswerEntity> answers = new LinkedList<>();
    private Boolean isMulti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public void addComment(CommentEntity comment) {
        comments.add(comment);
        comment.setQuestion(this);
    }

    public void removeComment(CommentEntity comment) {
        comment.setQuestion(null);
        comments.remove(comment);
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

    public Boolean getMulti() {
        return isMulti;
    }

    public void setMulti(Boolean multi) {
        isMulti = multi;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                ", answers=" + answers +
                ", isMulti=" + isMulti +
                '}';
    }
}
