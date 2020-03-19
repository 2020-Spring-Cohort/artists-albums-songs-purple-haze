package org.wcci.apimastery;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.models.Album;

import java.util.Collection;

@RestController
public class AlbumController {
    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;

    }

    @GetMapping("/albums")
    public Collection<Album> retrievedAlbums() {
        return (Collection<Album>) albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album retrievedAlbums(@PathVariable Long id) {
        return albumRepository.findById(id).get();
    }
}
