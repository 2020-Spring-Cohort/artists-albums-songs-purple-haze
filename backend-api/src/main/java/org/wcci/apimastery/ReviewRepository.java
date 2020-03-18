package org.wcci.apimastery;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
