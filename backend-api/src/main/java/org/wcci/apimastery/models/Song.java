package org.wcci.apimastery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    private String songTitle;

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    private Long duration;


    public Album getAlbum() {
        return album;
    }

    @JsonIgnore
    @ManyToOne
    private Album album;
    @JsonIgnore
    @OneToMany (mappedBy = "song")
    private Collection<Comment> comments;
    public Song(String songTitle, Album album){
        this.songTitle = songTitle;
        this.album = album;
    }

    public Song(){}

    public Long getId() {
        return id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public Long getDuration() {
        return duration;
    }



    public Collection<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(getId(), song.getId()) &&
                Objects.equals(getSongTitle(), song.getSongTitle()) &&
                Objects.equals(getDuration(), song.getDuration()) &&
                Objects.equals(getAlbum(), song.getAlbum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSongTitle(), getDuration(), getAlbum());
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songTitle='" + songTitle + '\'' +
                ", duration=" + duration +
                ", album=" + album +
                '}';
    }
}




