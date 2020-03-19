package org.wcci.apimastery;



import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/artists")
    public Artist createArtist(@RequestBody Artist artistToAdd) {
        return artistRepository.save(artistToAdd);
    }

}
