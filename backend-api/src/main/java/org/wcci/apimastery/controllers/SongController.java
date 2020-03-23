package org.wcci.apimastery.controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.models.Comment;
import org.wcci.apimastery.repos.CommentRepository;
import org.wcci.apimastery.repos.SongRepository;
import org.wcci.apimastery.models.Song;

import java.util.Collection;

@RestController
public class SongController {
    private SongRepository songRepository;
    private CommentRepository commentRepository;

    public SongController(SongRepository songRepository, CommentRepository commentRepository) {
        this.songRepository = songRepository;
        this.commentRepository = commentRepository;

    }

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

    @DeleteMapping("/songs/{id}")
    public void songToDelete(@PathVariable Long id) {
        Song songToDelete = songRepository.findById(id).get();
        songRepository.deleteById(id);
    }

    @PatchMapping("songs/{id}/add-comment")
    public Song addCommentToSong(@RequestBody Comment commentToPatch, @PathVariable Long id) {
        Song songToAddCommentTo = songRepository.findById(id).get();
        Comment addedComment = new Comment(commentToPatch.getCommenterName(), commentToPatch.getCommentContent());
        songToAddCommentTo.addCommentToSong(addedComment);
        commentRepository.save(addedComment);
        return songRepository.save(songToAddCommentTo);
    }





}
