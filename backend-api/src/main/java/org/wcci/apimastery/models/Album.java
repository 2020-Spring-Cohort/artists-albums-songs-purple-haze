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

    public Collection<Song> getSongs() {
        return songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != null ? !id.equals(album.id) : album.id != null) return false;
        if (artist != null ? !artist.equals(album.artist) : album.artist != null) return false;
        return albumTitle != null ? albumTitle.equals(album.albumTitle) : album.albumTitle == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (albumTitle != null ? albumTitle.hashCode() : 0);
        return result;
    }


}

