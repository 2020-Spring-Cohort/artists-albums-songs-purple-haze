package org.wcci.apimastery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.models.Comment;
import org.wcci.apimastery.repos.CommentRepository;

import java.util.Collection;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepo;

    @GetMapping("/comments")
    public Collection<Comment> displayAllComments(){
        return (Collection <Comment>) commentRepo.findAll();
    }


}
