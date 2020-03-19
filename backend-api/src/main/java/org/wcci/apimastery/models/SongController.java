package org.wcci.apimastery.models;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.SongRepository;

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

    @GetMapping("/songs/{id}/")
    public Song retrievedSongs(@PathVariable Long id) {
        return songRepository.findById(id).get();
    }



}
