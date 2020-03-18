package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Comment;
import org.wcci.apimastery.models.Song;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private SongRepository songRepo;
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private TestEntityManager entityManager;

    private Artist testArtist;
    private Album testAlbum1;
    private Album testAlbum2;
    private Song testSong1;
    private Song testSong2;
    private Comment testComment;
    private Comment testComment2;

    
    @BeforeEach
    void setUp() {
        testArtist = new Artist("MJ");
        artistRepo.save(testArtist);

        testAlbum1 = new Album("Thriller", testArtist);
        testAlbum2 = new Album("bad" , testArtist);
        albumRepo.save(testAlbum1);
        albumRepo.save(testAlbum2);

        testSong1 = new Song("TestSong1", testAlbum1);
        testSong2 = new Song("TestSong2", testAlbum1);
        songRepo.save(testSong1);
        songRepo.save(testSong2);
        albumRepo.save(testAlbum1);

        testComment = new Comment("commenter name","Comment body", testArtist, testAlbum1, testSong1);
        commentRepo.save(testComment);
        testComment2 = new Comment("commenter name", "CommentBody" , testArtist, testAlbum1, testSong1);
        commentRepo.save(testComment2);
   }

    @Test
    public void artistShouldHaveMultipleAlbums(){
        entityManager.flush();
        entityManager.clear();

        Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
        Album retrievedAlbum = albumRepo.findById(testAlbum1.getId()).get();
        Album retrievedAlbum2 = albumRepo.findById(testAlbum2.getId()).get();
        assertThat(retrievedArtist.getAlbums()).contains(retrievedAlbum, retrievedAlbum2);
    }

    @Test
    public void canDisplaySingleSongWithAlbum(){
        entityManager.flush();
        entityManager.clear();

        Song retrievedSong = songRepo.findById(testSong1.getId()).get();
        Song retrievedSong2 = songRepo.findById(testSong2.getId()).get();
        Album retrievedAlbum = albumRepo.findById(testAlbum1.getId()).get();
        assertThat(retrievedAlbum.getSongs()).contains(retrievedSong, retrievedSong2);
    }

    @Test
    public void canDisplaySingleArtistData(){
        testArtist.setBirthDate(101272);
        testArtist.setHometown("Columbus");
        testArtist.setRecordLabel("Atlantic");
        artistRepo.save(testArtist);

        assertThat(testArtist.getBirthDate()).isEqualTo(101272);
        assertThat(testArtist.getHometown()).isEqualTo("Columbus");
        assertThat(testArtist.getRecordLabel()).isEqualTo("Atlantic");

    }
    @Test
    public void artistShouldHaveComments(){
        entityManager.flush();
        entityManager.clear();

        Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
        Comment retrievedComment = commentRepo.findById(testComment.getId()).get();
        Comment retrievedComment2 = commentRepo.findById(testComment2.getId()).get();
        assertThat(retrievedArtist.getComments()).contains(retrievedComment, retrievedComment2);
    }
    @Test
    public void albumShouldHaveComments(){
        entityManager.flush();
        entityManager.clear();

        Album retrievedAlbum = albumRepo.findById(testAlbum1.getId()).get();
        Comment retrievedComment = commentRepo.findById(testComment.getId()).get();
        Comment retrievedComment2 = commentRepo.findById(testComment2.getId()).get();
        assertThat(retrievedAlbum.getComments()).contains(retrievedComment, retrievedComment2);
    }
    @Test
    public void songsShouldHaveComments(){
        entityManager.flush();
        entityManager.clear();

        Song retrievedSong = songRepo.findById(testSong1.getId()).get();
        Comment retrievedComment = commentRepo.findById(testComment.getId()).get();
        Comment retrievedComment2 = commentRepo.findById(testComment2.getId()).get();
        assertThat(retrievedSong.getComments()).contains(retrievedComment, retrievedComment2);
    }



}
