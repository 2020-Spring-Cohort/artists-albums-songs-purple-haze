package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;

import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class ArtistControllerTest {

    private ArtistRepository artistRepository;
    private ArtistController underTest;
    private Artist testArtist;


    @Test
    public void retreivedArtistsReturnsAListOfArtistsFromMockRepo(){
        artistRepository = mock(ArtistRepository.class);
        ArtistController underTest = new ArtistController(artistRepository);
        Artist testArtist = new Artist("MJ");
        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
//
    }

    @Test
    public void retrieveArtistReturnsListOfArtistsContainingMockArtists(){
        artistRepository = mock(ArtistRepository.class);
        ArtistController underTest = new ArtistController(artistRepository);
        Artist testArtist = new Artist("MJ");
        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
    }



}
