package org.wcci.apimastery;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void retrieveArtist() {
    }
}
