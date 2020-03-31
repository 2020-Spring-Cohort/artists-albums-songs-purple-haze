package org.wcci.apimastery.models;

import javax.persistence.*;

@Entity
public class Ratings {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Artist artist;

    @OneToOne
    private Song song;

    @OneToOne
    private Album album;

    private int goodRating = 0;

    private int badRating = 0;

    public Ratings() {
    }

    public Ratings(int goodRating, int badRating) {
        this.goodRating = goodRating;
        this.badRating = badRating;
    }
    public void addBadRating(){
        badRating++;
    }

    public void addGoodRating(){
        this.goodRating++;
        System.out.println(goodRating);
    }

    public int getGoodRating() {
        return goodRating;
    }

    public int getBadRating() {
        return badRating;
    }

    public long getId() {
        return id;
    }


}
