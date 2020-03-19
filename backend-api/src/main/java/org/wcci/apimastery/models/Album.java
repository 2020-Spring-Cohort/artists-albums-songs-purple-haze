package org.wcci.apimastery.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private Artist artist;

    @OneToMany (mappedBy = "album")
    private Collection<Song> songs;

    @OneToMany (mappedBy = "album")
    private Collection<Comment> comments;

    private String albumTitle;

//    private String recordLabel;
    protected Album(){}

    public Album(String albumTitle, Artist artist) {
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.comments = new HashSet<>();

    }
    public Artist getArtist() {
        return artist;
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

    public Collection<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(artist, album.artist) &&
                Objects.equals(albumTitle, album.albumTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, albumTitle);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artist=" + artist +
                ", albumTitle='" + albumTitle + '\'' +
                '}';
    }

    public void addCommentToArtist(Comment commentToAdd) {
        comments.add(commentToAdd);
    }
}

