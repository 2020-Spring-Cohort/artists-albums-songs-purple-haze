package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Song {

    @Id
    @GeneratedValue
    private Long id;


    private String songTitle;
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

    public Song(){};

    public String getSongTitle() {
        return songTitle;
    }

    public Long getDuration() {
        return duration;
    }
}




