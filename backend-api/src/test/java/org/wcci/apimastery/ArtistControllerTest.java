//package org.wcci.apimastery;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import org.wcci.apimastery.controllers.ArtistController;
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
//public class ArtistControllerTest {
//
//
//    private AlbumRepository albumRepository;
//    private ArtistRepository artistRepository;
//    private ArtistController underTest;
//    private Artist testArtist;
//
//
//    @Test
//    public void retreivedArtistsReturnsAListOfArtistsFromMockRepo(){
//        artistRepository = mock(ArtistRepository.class);
//        albumRepository = mock(AlbumRepository.class);
//        ArtistController underTest = new ArtistController(artistRepository, albumRepository);
//        Artist testArtist = new Artist("MJ");
//        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
//        Collection<Artist> result = underTest.retrieveArtists();
//        verify(artistRepository).findAll();
//
//    }
//
//    @Test
//    public void retrieveArtistReturnsListOfArtistsContainingMockArtists(){
//        artistRepository = mock(ArtistRepository.class);
//        ArtistController underTest = new ArtistController(artistRepository, albumRepository);
//        Artist testArtist = new Artist("MJ");
//        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
//        Collection<Artist> result = underTest.retrieveArtists();
//        assertThat(result).contains(testArtist);
//    }
//
//    @Test
//    public void underTestIsWiredCorrectlyWithAnnotation() throws Exception {
//        artistRepository = mock(ArtistRepository.class);
//        ArtistController underTest = new ArtistController(artistRepository, albumRepository);
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
//        mockMvc.perform(get("/artists")).andExpect(status().isOk());
//    }
//
//
//
//}
