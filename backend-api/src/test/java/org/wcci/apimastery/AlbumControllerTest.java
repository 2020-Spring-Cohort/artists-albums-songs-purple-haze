//package org.wcci.apimastery;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import org.wcci.apimastery.controllers.AlbumController;
//import org.wcci.apimastery.models.Album;
//import org.wcci.apimastery.models.Artist;
//import org.wcci.apimastery.repos.AlbumRepository;
//import org.wcci.apimastery.repos.ArtistRepository;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class AlbumControllerTest {
//
//    private AlbumRepository albumRepository;
//    private ArtistRepository artistRepository;
//    private AlbumController underTest;
//
//    @Test
//    public void retrievedAlbumShouldReturnAlbumFromMockRepo() {
//        albumRepository = mock(AlbumRepository.class);
//        artistRepository = mock(ArtistRepository.class);
//        Artist testArtist = new Artist("MJ");
//        AlbumController underTest = new AlbumController(albumRepository, artistRepository);
//        Album testAlbum = new Album("Thriller", testArtist);
//        when(albumRepository.findAll()).thenReturn(Collections.singletonList(testAlbum));
//        Collection<Album> result = underTest.retrievedAlbums();
//        verify(albumRepository).findAll();
//    }
//
//    @Test
//    public void retrievedAlbumShouldReturnAnArtistContainingMockArtist(){
//        albumRepository = mock(AlbumRepository.class);
//        Artist testArtist = new Artist("MJ");
//        AlbumController underTest = new AlbumController(albumRepository, artistRepository);
//        Album testAlbum = new Album("Thriller", testArtist);
//        when(albumRepository.findAll()).thenReturn(Collections.singletonList(testAlbum));
//        Collection<Album> result = underTest.retrievedAlbums();
//        assertThat(result).contains(testAlbum);
//    }
//
//    @Test
//    public void underTestIsWiredCorrectlyWithAnnotation() throws Exception{
//        albumRepository = mock(AlbumRepository.class);
//        AlbumController underTest = new AlbumController(albumRepository, artistRepository);
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
//        mockMvc.perform(get("/albums")).andExpect(status().isOk());
//    }
//
//
//}
