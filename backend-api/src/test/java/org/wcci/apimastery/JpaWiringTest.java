package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.ArtistRepository;
import org.wcci.apimastery.AlbumRepository;
import org.wcci.apimastery.models.Song;


import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private SongRepository songRepo;

    private Artist testArtist;
    private Album testAlbum1;
    private Album testAlbum2;




    @BeforeEach
    void setUp() {
        testArtist = new Artist("MJ");
        artistRepo.save(testArtist);

        testAlbum1 = new Album("Thriller", testArtist);
        testAlbum2 = new Album("bad" , testArtist);

        albumRepo.save(testAlbum1);
        albumRepo.save(testAlbum2);

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
        Song testSong1 = new Song("TestSong1", testAlbum1);
        Song testSong2 = new Song("TestSong2", testAlbum1);
        songRepo.save(testSong1);
        songRepo.save(testSong2);
        albumRepo.save(testAlbum1);
        entityManager.flush();
        entityManager.clear();

        Song retrievedSong = songRepo.findById(testSong1.getId()).get();
        Song retrievedSong2 = songRepo.findById(testSong2.getId()).get();
        Album retrievedAlbum = retrievedSong.getAlbum();

        assertThat(retrievedSong.getAlbum()).isEqualTo(testAlbum1);
        assertThat(retrievedSong.getSongTitle()).isEqualTo("TestSong1");
        assertThat(retrievedAlbum.getArtist()).isEqualTo(testArtist);
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




}
