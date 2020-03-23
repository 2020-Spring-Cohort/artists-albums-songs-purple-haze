package org.wcci.apimastery.controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.repos.ArtistRepository;
import org.wcci.apimastery.repos.SongRepository;

import java.util.Collection;
import java.util.Properties;

@RestController
public class AlbumController {
    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private SongRepository songRepository;

    public AlbumController(AlbumRepository albumRepository, ArtistRepository artistRepository, SongRepository songRepository){
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

    @PatchMapping("albums/{id}")
    public Album updateAlbumsWithSongs(@PathVariable Long id, @RequestBody Song requestBodySong) {
        Album albumToPatch = albumRepository.findById(id).get();
        Song songToAdd = new Song(requestBodySong.getSongTitle(), albumToPatch);
        songRepository.save(songToAdd);
        return albumRepository.save(albumToPatch);

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
