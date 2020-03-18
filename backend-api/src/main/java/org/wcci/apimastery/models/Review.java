package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Artist artist;
    private String comment;


    protected Review(){}

    public Review(String comment, Artist artist){
        this.comment = comment;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getComment() {
        return comment;
    }
}
