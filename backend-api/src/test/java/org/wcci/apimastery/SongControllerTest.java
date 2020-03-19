package org.wcci.apimastery;


import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.models.SongController;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SongControllerTest {
    private SongRepository songRepository;
    private SongController underTest;

    @Test
    public void retrievedSongShouldReturnSongFromMockRepo(){
        songRepository = mock(SongRepository.class);
        Artist testArtist = new Artist("Jimmy hendrix");
        Album testAlbum = new Album("Electic ladyland", testArtist);
        SongController underTest = new SongController(songRepository);
        Song testSong = new Song("voodoo chile",testAlbum);
        when(songRepository.findAll()).thenReturn(Collections.singletonList(testSong));
        Collection<Song> result = underTest.retrievedSongs();
        verify(songRepository).findAll();
    }

    @Test
        public void   retrievedSongShouldReturnAnArtistContainingMockArtist(){
        songRepository = mock(SongRepository.class);
        Artist testArtist = new Artist("Jimmy hendrix");
        Album testAlbum = new Album("Electic ladyland", testArtist);
        SongController underTest = new SongController(songRepository);
        Song testSong = new Song("voodoo chile",testAlbum);
        when(songRepository.findAll()).thenReturn(Collections.singletonList(testSong));
        Collection<Song> result = underTest.retrievedSongs();
        assertThat(result).contains(testSong);

    }

    @Test
    public void underTestCorrectlyWithAnnotation()throws Exception{
        songRepository = mock (SongRepository.class);
        SongController underTest = new SongController(songRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/songs")).andExpect(status().isOk());
    }

}
