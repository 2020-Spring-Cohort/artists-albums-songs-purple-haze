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
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Song song;

    private String commenterName;
    private String commentContent;

    protected Comment(){}

    public Comment(String commenterName, String commentContent , Artist artist, Album album, Song song){
        this.commenterName = commenterName;
        this.commentContent = commentContent;
        this.artist = artist;
        this.album = album;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public Song getSong() {
        return song;
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
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(artist, comment.artist) &&
                Objects.equals(album, comment.album) &&
                Objects.equals(song, comment.song) &&
                Objects.equals(commenterName, comment.commenterName) &&
                Objects.equals(commentContent, comment.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, album, song, commenterName, commentContent);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", artist=" + artist +
                ", album=" + album +
                ", song=" + song +
                ", commenterName='" + commenterName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
