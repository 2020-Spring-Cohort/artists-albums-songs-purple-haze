package org.wcci.apimastery;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/albums")
    public Album createAlbum(@RequestBody Album albumToAdd) {
        return albumRepository.save(albumToAdd);
    }
}
