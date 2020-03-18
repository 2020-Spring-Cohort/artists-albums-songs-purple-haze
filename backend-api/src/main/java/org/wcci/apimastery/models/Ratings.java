package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ratings {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Artist artist;
    private int rating;


    public Ratings() {
    }
    public Ratings(Artist artist, int rating) {
        this.artist = artist;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getRating() {
        return rating;
    }
}
