package org.wcci.apimastery.controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.repos.ArtistRepository;

import java.util.Collection;

@RestController
public class AlbumController {
    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;

    public AlbumController(AlbumRepository albumRepository, ArtistRepository artistRepository){
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @GetMapping("/albums")
    public Collection<Album> retrievedAlbums() {
        return (Collection<Album>) albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album retrievedAlbums(@PathVariable Long id) {
        return albumRepository.findById(id).get();
    }

    //Won't work because you need an artist
    @PostMapping("/albums")
    public Album createAlbum(@RequestBody Album albumToAdd) {
        return albumRepository.save(albumToAdd);
    }

//    @DeleteMapping
//    //CODE HERE //
//
//    @PatchMapping
//    //Add Comment //
//
//    @PatchMapping
//    //Add A Song To Album
}
