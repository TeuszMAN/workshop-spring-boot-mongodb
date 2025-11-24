package com.teuszman.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teuszman.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
