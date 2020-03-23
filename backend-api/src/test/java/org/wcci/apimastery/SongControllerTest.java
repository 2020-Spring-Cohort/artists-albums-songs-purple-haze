package org.wcci.apimastery;


import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.controllers.SongController;
import org.wcci.apimastery.repos.CommentRepository;
import org.wcci.apimastery.repos.SongRepository;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SongControllerTest {
    private SongRepository songRepository;
    private CommentRepository commentRepository;
    private Song testSong;
    private SongController underTest;
    private MockMvc mockMvc;

    @Test
    public void retrievedSongShouldReturnSongFromMockRepo(){
        songRepository = mock(SongRepository.class);
        Artist testArtist = new Artist("Jimmy hendrix");
        Album testAlbum = new Album("Electic ladyland", testArtist);
        SongController underTest = new SongController(songRepository, commentRepository);
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
        SongController underTest = new SongController(songRepository, commentRepository);
        Song testSong = new Song("voodoo chile",testAlbum);
        when(songRepository.findAll()).thenReturn(Collections.singletonList(testSong));
        Collection<Song> result = underTest.retrievedSongs();
        assertThat(result).contains(testSong);

    }

    @Test
    public void underTestCorrectlyWithAnnotation()throws Exception{
        songRepository = mock (SongRepository.class);
        SongController underTest = new SongController(songRepository, commentRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/songs")).andExpect(status().isOk());
    }



}
