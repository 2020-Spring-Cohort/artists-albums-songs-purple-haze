package org.wcci.apimastery;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @RequestMapping("/artists")
    public Collection<Artist> retrieveArtists() {
        return(Collection<Artist>) artistRepository.findAll();
    }

}
