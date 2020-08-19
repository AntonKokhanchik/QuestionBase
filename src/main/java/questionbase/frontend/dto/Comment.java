package questionbase.frontend.dto;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private Long id;
    private String authorName;
    private String text;
    private LocalDateTime creationTime;
    private Question question;
    private User author;

    public Comment() { }

    public Comment(String authorName, String text) {
        this.authorName = authorName;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        if (author == null || author.getFullName() == null)
            return authorName + " <Guest>";
        return authorName + " <" + author.getFullName() + '>';
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

    public String getCreationTimeFormatted() {
        return creationTime.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy, HH:mm"));
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return new EqualsBuilder()
                .append(id, comment.id)
                .append(authorName, comment.authorName)
                .append(text, comment.text)
                .append(creationTime, comment.creationTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(authorName)
                .append(text)
                .append(creationTime)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", author='" + getAuthorName() + '\'' +
                ", text='" + text + '\'' +
                ", creationTime=" + getCreationTimeFormatted() +
                ", question=" + question.getId() +
                '}';
    }
}
