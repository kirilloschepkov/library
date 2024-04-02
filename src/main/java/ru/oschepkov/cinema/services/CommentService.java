package ru.oschepkov.cinema.services;

import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.entities.CommentEntity;
import ru.oschepkov.cinema.repositories.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository repository;

    public CommentService(CommentRepository repository){
        this.repository = repository;
    }

    public List<CommentEntity> getAllComments(){
        return repository.findAll();
    }

    public List<CommentEntity> getCommentsByFilmId(){
        return null;
    }

    public CommentEntity create(CommentEntity comment){
        return repository.save(comment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
