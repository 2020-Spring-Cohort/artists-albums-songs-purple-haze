package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;


@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;



    private String commenterName;
    private String commentContent;

    protected Comment(){}

    public Comment(String commenterName, String commentContent ){
        this.commenterName = commenterName;
        this.commentContent = commentContent;
    }

    public Long getId() {
        return id;
    }


    public String getCommenterName() {
        return commenterName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (getId() != null ? !getId().equals(comment.getId()) : comment.getId() != null) return false;
        if (getCommenterName() != null ? !getCommenterName().equals(comment.getCommenterName()) : comment.getCommenterName() != null)
            return false;
        return getCommentContent() != null ? getCommentContent().equals(comment.getCommentContent()) : comment.getCommentContent() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCommenterName() != null ? getCommenterName().hashCode() : 0);
        result = 31 * result + (getCommentContent() != null ? getCommentContent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commenterName='" + commenterName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
