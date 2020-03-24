package org.wcci.apimastery.repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Album;

import java.util.Collection;

public interface AlbumRepository extends CrudRepository <Album, Long>{
    Collection<Album> findAllByArtist_Id(Long id);

}
