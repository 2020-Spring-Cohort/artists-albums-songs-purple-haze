package org.wcci.apimastery.controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.repos.SongRepository;
import org.wcci.apimastery.models.Song;

import java.util.Collection;

@RestController
public class SongController {
    private SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;

    }

//    @RequestMapping("songs")
//    public Collection<Song> retrievedSongs() {
//        return (Collection<Song>) songRepository.findAll();
//
//    }

    @GetMapping("/songs")
    public Collection<Song> retrievedSongs() {
        return (Collection<Song>) songRepository.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song retrievedSongs(@PathVariable Long id) {
        return songRepository.findById(id).get();
    }

    @PostMapping("/songs")
    public Song createSong(@RequestBody Song songToAdd) {
        return songRepository.save(songToAdd);
    }





}
