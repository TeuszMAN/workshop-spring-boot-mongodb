package com.teuszman.workshopmongo.config;

import java.util.Date;

import javax.xml.stream.events.Comment;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.teuszman.workshopmongo.dto.AuthorDTO;
import com.teuszman.workshopmongo.dto.CommentDTO;
import com.teuszman.workshopmongo.entities.Post;
import com.teuszman.workshopmongo.entities.User;
import com.teuszman.workshopmongo.repositories.PostRepository;
import com.teuszman.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run (String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO(sdf.parse("21/03/2018"), "Boa viagem mano!", new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO(sdf.parse("22/03/2018"), "Aproveite", new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO(sdf.parse("23/03/2018"), "Tenha um ótimo dia!", new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
        System.out.println("DB initialized");
    }

}
