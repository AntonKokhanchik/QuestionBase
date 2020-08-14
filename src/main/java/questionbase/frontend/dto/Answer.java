package questionbase.frontend.dto;

public class Answer {
    private Long id;
    private String text;
    private Question question;
    private Boolean isRight;

    public Answer() { }

    public Answer(String text, Boolean isRight) {
        this.text = text;
        this.isRight = isRight;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", question=" + question.getId() +
                ", isRight=" + isRight +
                '}';
    }
}
