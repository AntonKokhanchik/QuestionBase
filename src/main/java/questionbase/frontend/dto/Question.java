package questionbase.frontend.dto;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.HashCodeBuilder;

public class Question {
    private Long id;
    private String text;
    private Boolean isMulti;

    public Question() { }

    public Question(String author, String text) {
        /////////
        this.text = text;
    }

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

    public Boolean getMulti() {
        return isMulti;
    }

    public void setMulti(Boolean multi) {
        isMulti = multi;
    }
//////////
    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return new EqualsBuilder()
                .append(id, question.id)
                .append(text, question.text)
                .isEquals();
    }
////////
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(text)
                .toHashCode();
    }
}
