package org.wcci.apimastery.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.models.Comment;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.ArtistRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.repos.CommentRepository;
import org.wcci.apimastery.repos.SongRepository;


import java.util.Collection;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;
    private CommentRepository commentRepo;
    private SongRepository songRepository;

    public ArtistController(ArtistRepository artistRepository, AlbumRepository albumRepository,
                            CommentRepository commentRepo, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.commentRepo = commentRepo;
        this.songRepository = songRepository;
    }

    //All Artists
    @GetMapping("/artists")
    public Collection<Artist> retrieveArtists() {
        return(Collection<Artist>) artistRepository.findAll();
    }

    //Single Artists
    @GetMapping("/artists/{id}")
    public Artist retrieveSingleArtist(@PathVariable Long id) {
        return artistRepository.findById(id).get();
    }

//    @GetMapping("/artists/{artistId}")
//    public Collection<Album> retrieveAllAlbumsOfArtist(@PathVariable Long artistId){
//        return albumRepository.findAllByArtist_Id(artistId);
//    }

    //Add an Album (needs an artist)
    @PatchMapping("/artists/{id}")
    public Artist updateArtistAlbums(@PathVariable Long id, @RequestBody Album requestBodyAlbum) {
        Artist artistToPatch = artistRepository.findById(id).get();
        Album albumToAdd = new Album(requestBodyAlbum.getAlbumTitle(), artistToPatch);
        albumRepository.save(albumToAdd);
        return artistRepository.save(artistToPatch);
    }

    //CreateArtist
    @PostMapping("/artists")
    public Artist createArtist(@RequestBody Artist artistToAdd) {
        artistToAdd.setRecordLabel(artistToAdd.getRecordLabel());
    return artistRepository.save(artistToAdd);
    }

    @PatchMapping("artists/{id}/add-comment")
    public Artist addCommentToArtist(@RequestBody Comment commentToPatch, @PathVariable Long id){
        Artist artistToAddCommentTo = artistRepository.findById(id).get();
        Comment addedComment = new Comment(commentToPatch.getCommenterName(), commentToPatch.getCommentContent());
        artistToAddCommentTo.addCommentToArtist(addedComment);
        commentRepo.save(addedComment);
        return artistRepository.save(artistToAddCommentTo);
    }

    @PatchMapping("artists/{artistId}/{albumId}/add-comment")
    public Album addCommentToAlbum(@RequestBody Comment commentToPatch, @PathVariable Long albumId){
        Album albumToAddCommentTo = albumRepository.findById(albumId).get();
        albumToAddCommentTo.addCommentToAlbum(commentToPatch);
        commentRepo.save(commentToPatch);
        return albumToAddCommentTo;
    }

    @DeleteMapping("/artist/{id}")
    public Collection<Artist>  deleteArtist(@PathVariable Long id) {
        Artist artistToDelete = artistRepository.findById(id).get();
        for (Album albumToDelete : artistToDelete.getAlbums()) {
            for (Song songToDelete : albumToDelete.getSongs()) {
                songRepository.delete(songToDelete);
            }
            albumRepository.delete(albumToDelete);
        }
        artistRepository.delete(artistToDelete);
    return(Collection<Artist>) artistRepository.findAll();
    }
}
