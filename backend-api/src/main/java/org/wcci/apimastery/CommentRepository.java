package org.wcci.apimastery;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
