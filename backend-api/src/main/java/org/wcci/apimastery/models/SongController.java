package org.wcci.apimastery.models;

import javafx.print.Collation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.SongRepository;

import java.util.Collection;

@RestController
public class SongController {
    private SongRepository songRepository;

    public SongController (SongRepository songRepository){
        this.songRepository =songRepository;

    }
   @RequestMapping("songs")
    public Collection<Song> retrievedSongs(){ return (Collection<Song>) songRepository.findAll();}



   }

