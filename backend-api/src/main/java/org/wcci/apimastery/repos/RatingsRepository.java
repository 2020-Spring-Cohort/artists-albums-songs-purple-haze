package org.wcci.apimastery.repos;


import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Ratings;

public interface RatingsRepository extends CrudRepository <Ratings, Long> {
}
