package org.wcci.apimastery.controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongRepository;
import org.wcci.apimastery.models.Song;

import java.util.Collection;
import java.util.Properties;

@RestController
public class SongController {
    private SongRepository songRepository;
    private AlbumRepository albumRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;

    }

//    @RequestMapping("songs")
//    public Collection<Song> retrievedSongs() {
//        return (Collection<Song>) songRepository.findAll();
//
//    }

    @GetMapping("/songs/")
    public Collection<Song> retrievedSongs() {
        return (Collection<Song>) songRepository.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song retrievedSongs(@PathVariable Long id) {
        return songRepository.findById(id).get();
    }


//    @PatchMapping("/songs/")
//    public Song updateAlbumsWithSongs(@RequestBody Song requestBodySong) {
//        Album albumToPatch = albumRepository.findById(id).get();
//        Song songToAdd = new Song(requestBodySong.getSongTitle(), albumToPatch);
//        songRepository.save(songToAdd);
//        albumRepository.save(albumToPatch);
//        return songToAdd;
//    }
//    @PatchMapping("/artists/{id}")
//    public Artist updateArtistAlbums(@PathVariable Long id, @RequestBody Album requestBodyAlbum) {
//        Artist artistToPatch = artistRepository.findById(id).get();
//        Album albumToAdd = new Album(requestBodyAlbum.getAlbumTitle(), artistToPatch);
//        albumRepository.save(albumToAdd);
//        return artistRepository.save(artistToPatch);
//    }



}
