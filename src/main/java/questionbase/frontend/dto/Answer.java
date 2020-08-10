package questionbase.frontend.dto;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

public class Answer {
    private Long id;
    private String author;
    private String text;
    private LocalDateTime creationTime;
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return new EqualsBuilder()
                .append(id, answer.id)
                .append(author, answer.author)
                .append(text, answer.text)
                .append(creationTime, answer.creationTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(author)
                .append(text)
                .append(creationTime)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", creationTime=" + creationTime +
                ", question=" + question.getText() +
                '}';
    }
}
