package org.wcci.apimastery;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.models.Artist;

import java.util.Collection;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping("/artists")
    public Collection<Artist> retrieveArtists() {
        return(Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/artists/{id}")
    public Artist retrieveArtists(@PathVariable Long id) {
        return artistRepository.findById(id).get();
    }

}
