package org.wcci.apimastery.models;

public class Song {
    private String songTitle;
    private Long duration;

    public Song(String songTitle){
        this.songTitle = songTitle;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public Long getDuration() {
        return duration;
    }
}




