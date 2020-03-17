package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;


@Entity
public class Song {

    public Long getId() {
        return id;
    }

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

    @ManyToOne
    private Album album;

    public Song(String songTitle, Album album){
        this.songTitle = songTitle;
        this.album = album;
    }

    public Song(){}

    public String getSongTitle() {
        return songTitle;
    }

    public Long getDuration() {
        return duration;
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
}




