package org.wcci.apimastery.controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.repos.ArtistRepository;
import org.wcci.apimastery.repos.SongRepository;

import java.security.PublicKey;
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
    public Collection<Album> displayAllAlbums() {
        return (Collection<Album>) albumRepository.findAll();
    }

    @GetMapping("albums/{albumId}")
    public Album displaySingleAlbum(@PathVariable Long albumId) {
        return albumRepository.findById(albumId).get();
    }

    //Won't work because you need an artist
    @PostMapping("/albums")
    public Album createAlbum(@RequestBody Album albumToAdd) {
        return albumRepository.save(albumToAdd);
    }

    @PatchMapping("artists/{artistId}/{albumId}")
    public Album updateAlbumsWithSongs(@PathVariable Long albumId, @RequestBody Song requestBodySong) {
        Album albumToPatch = albumRepository.findById(albumId).get();
        Song songToAdd = new Song(requestBodySong.getSongTitle(), albumToPatch);
        songRepository.save(songToAdd);
        return albumRepository.save(albumToPatch);
    }


    @DeleteMapping("artists/{artistId}/{albumId}")
    public Artist deleteAlbumFromArtist(@PathVariable Long artistId, Long albumId){
        Artist artistToDeleteAlbumFrom = artistRepository.findById(artistId).get();
        Album albumToDelete = albumRepository.findById(albumId).get();
        albumRepository.delete(albumToDelete);
        artistRepository.save(artistToDeleteAlbumFrom);
        return artistToDeleteAlbumFrom;
    }
//
//    @PatchMapping("songs/{id}/add-comment")
//    public Song addCommentToSong(){
//
//    }
//    //Add Comment //
//
//    @PatchMapping
//    //Add A Song To Album
}
