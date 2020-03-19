package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.models.*;


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

        testComment = new Comment("commenter name","Comment body");
        commentRepo.save(testComment);
        testComment2 = new Comment("commenter name", "CommentBody");
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
        testArtist.addCommentToArtist(testComment);
        testArtist.addCommentToArtist(testComment2);
        artistRepo.save(testArtist);
        commentRepo.save(testComment);
        commentRepo.save(testComment2);
        entityManager.flush();
        entityManager.clear();

        assertThat(testArtist.getComments()).contains(testComment, testComment2);
    }
    @Test
    public void albumShouldHaveComments(){
        testAlbum1.addCommentToArtist(testComment);
        testAlbum1.addCommentToArtist(testComment2);

        albumRepo.save(testAlbum1);
        commentRepo.save(testComment);
        commentRepo.save(testComment2);

        entityManager.flush();
        entityManager.clear();

//        Album retrievedAlbum = albumRepo.findById(testAlbum1.getId()).get();
//        Comment retrievedComment = commentRepo.findById(testComment.getId()).get();
//        Comment retrievedComment2 = commentRepo.findById(testComment2.getId()).get();
        assertThat(testAlbum1.getComments()).contains(testComment, testComment2);
    }
    @Test
    public void songsShouldHaveComments(){
        testSong1.addCommentToSong(testComment);
        testSong1.addCommentToSong(testComment2);

        songRepo.save(testSong1);
        commentRepo.save(testComment);
        commentRepo.save(testComment2);

        entityManager.flush();
        entityManager.clear();

        assertThat(testSong1.getComments()).contains(testComment, testComment2);
    }

    @Test
    public void artistCanAddGoodRatingAndBadRating(){
        testArtist.addGoodRating();
        Ratings ratingsToTest = testArtist.getRatings();
        assertThat(ratingsToTest.getGoodRating()).isEqualTo(1);
    }

    @Test
    public void songCanHaveGoodRatings(){
        testSong1.addGoodRating();
        Ratings ratingsToTest = testSong1.getRatings();
        assertThat(ratingsToTest.getGoodRating()).isEqualTo(1);
    }

    @Test
    public void albumCanHaveRatings(){
        testAlbum1.addGoodRating();
        Ratings ratingsToTest = testAlbum1.getRatings();
        assertThat(ratingsToTest.getGoodRating()).isEqualTo(1);
    }


}
