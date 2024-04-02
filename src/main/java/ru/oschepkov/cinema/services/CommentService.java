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

    public List<CommentEntity> getCommentsByFilmId(Long id){
        return null; // todo: комментарии по идентификатору фильма
    }

    public CommentEntity getCommentsById(Long id){
        return repository.findById(id).orElse(null);
    }

    public CommentEntity createComment(CommentEntity comment){
        return repository.save(comment);
    }
}
