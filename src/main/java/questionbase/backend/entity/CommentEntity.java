package questionbase.backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="COMMENTS")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    private String text;
    private LocalDateTime creationTime;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;
    @ManyToOne
    @JoinColumn(name = "author_login", referencedColumnName = "login")
    private UserEntity author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", text='" + text + '\'' +
                ", creationTime=" + creationTime +
                ", question=" + question.getId() +
                '}';
    }
}
