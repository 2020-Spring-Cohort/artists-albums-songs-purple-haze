package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.ArtistRepository;
import org.wcci.apimastery.AlbumRepository;
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

    @Test
    public void artistShouldHaveMultipleAlbums(){
        Artist testArtist = new Artist("MJ");
        artistRepo.save(testArtist);
        Album testAlbum = new Album("Thriller", testArtist);
        Album testAlbum2 = new Album("bad" , testArtist);
        albumRepo.save(testAlbum);
        albumRepo.save(testAlbum2);

        entityManager.flush();
        entityManager.clear();
        Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
        Album retrievedAlbum = albumRepo.findById(testAlbum.getId()).get();
        Album retrievedAlbum2 = albumRepo.findById(testAlbum2.getId()).get();
        assertThat(retrievedArtist.getAlbums()).contains(retrievedAlbum, retrievedAlbum2);
    }
    

}
