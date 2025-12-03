package com.teuszman.workshopmongo.services;
import com.teuszman.workshopmongo.dto.UserDTO;
import com.teuszman.workshopmongo.entities.Post;
import com.teuszman.workshopmongo.entities.User;
import com.teuszman.workshopmongo.repositories.PostRepository;
import com.teuszman.workshopmongo.repositories.UserRepository;
import com.teuszman.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
