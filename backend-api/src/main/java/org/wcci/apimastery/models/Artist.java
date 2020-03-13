package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "artist")
    private Collection<Album> albums;

    private String name;
//    private Long birthDate;
//    private String recordLabel;
//    private String hometown;


    protected Artist(){}

    public Artist(String name){
        this.name= name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public Long getBirthDate() {
//        return birthDate;
//    }
//
//    public String getRecordLabel() {
//        return recordLabel;
//    }
//
//    public String getHometown() {
//        return hometown;
//    }

    public Collection<Album> getAlbums() {
        return albums;
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
}
