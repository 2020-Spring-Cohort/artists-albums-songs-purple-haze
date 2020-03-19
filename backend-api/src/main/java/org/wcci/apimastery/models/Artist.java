package org.wcci.apimastery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "artist")
    private Collection<Album> albums;


    @OneToMany (mappedBy = "artist")

    @JsonIgnore
    @OneToMany(mappedBy = "artist")

    private Collection<Comment> comments;

    @OneToOne
    private Ratings ratings;

    public void addGoodRating(){
        ratings.addGoodRating();
    }

    public void addBadRating(){
        ratings.addBadRating();
    }

    private String name;
    private int birthDate;
    private String recordLabel;
    private String hometown;

    protected Artist(){}

    public Artist(String name){
        this.name= name;
        this.comments = new HashSet<>();
        this.ratings = new Ratings();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getBirthDate() {
        return birthDate;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public String getHometown() {
        return hometown;
    }

    public void setBirthDate(int birthDate) {
    this.birthDate = birthDate;
}

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) &&
                Objects.equals(name, artist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void addCommentToArtist(Comment comment) {
        comments.add(comment);
    }


    public Ratings getRatings() {
        return ratings;
    }
}
