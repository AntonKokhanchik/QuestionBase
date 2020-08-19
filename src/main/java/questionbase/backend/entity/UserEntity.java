package questionbase.backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USERS")
public class UserEntity {
    @Id
    private String login;
    private String password;
    private String fullName;
    private Boolean isAdmin;
    @OneToMany(mappedBy = "author")
    private List<CommentEntity> comments;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public void addComment(CommentEntity comment) {
        comments.add(comment);
        comment.setAuthor(this);
    }

    public void removeComment(CommentEntity comment) {
        comment.setAuthor(null);
        comments.remove(comment);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "login='" + login + '\'' +
                ", fullName='" + fullName + '\'' +
                ", isAdmin=" + isAdmin +
                ", comments=" + comments +
                '}';
    }
}
