package org.wcci.apimastery.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Long id;

    public Artist getArtist() {
        return artist;
    }

    @ManyToOne
    private Artist artist;

    @OneToMany (mappedBy = "album")
    private Collection<Song> songs;

    private String albumTitle;
//    private String recordLabel;

    protected Album(){}

    public Album(String albumTitle, Artist artist) {
        this.artist = artist;
        this.albumTitle = albumTitle;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

//    public String getRecordLabel() {
//        return recordLabel;
//    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(artist, album.artist) &&
                Objects.equals(albumTitle, album.albumTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, albumTitle);
    }
}

