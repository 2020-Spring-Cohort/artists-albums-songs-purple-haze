package org.wcci.apimastery;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.models.Album;

import java.util.Collection;

@RestController
public class AlbumController {
    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;

    }

    @RequestMapping("/albums")
    public Collection<Album> retrievedAlbums() {
        return (Collection<Album>) albumRepository.findAll();
    }
}
