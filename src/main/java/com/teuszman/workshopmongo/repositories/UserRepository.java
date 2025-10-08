package com.teuszman.workshopmongo.repositories;

import com.teuszman.workshopmongo.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
