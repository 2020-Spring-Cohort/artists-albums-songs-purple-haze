package org.wcci.apimastery;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Song;

public interface SongRepository extends CrudRepository <Song, Long> {
}
