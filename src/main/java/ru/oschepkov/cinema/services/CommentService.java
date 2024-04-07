package ru.oschepkov.cinema.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.dto.comment.CommentDTO;
import ru.oschepkov.cinema.dto.comment.InputCommentDTO;
import ru.oschepkov.cinema.entities.CommentEntity;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.mappers.comment.CommentMapper;
import ru.oschepkov.cinema.repositories.CommentRepository;
import ru.oschepkov.cinema.repositories.FilmRepository;
import ru.oschepkov.cinema.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final FilmRepository filmRepository;
    private final UserRepository userRepository;

    private final CommentMapper commentMapper;

    public List<CommentDTO> getAllComments() {
        return commentRepository
                .findAll()
                .stream()
                .map(commentMapper::convertToCommentDTOFromEntity)
                .toList();
    }

    public CommentDTO getCommentsById(Long id) {
        return commentMapper.convertToCommentDTOFromEntity(commentRepository.findById(id).orElse(null));
    }

    public List<CommentDTO> getCommentsByFilmId(Long id) {
        return commentRepository
                .findCommentEntitiesByFilmId(id)
                .stream()
                .map(commentMapper::convertToCommentDTOFromEntity)
                .toList();
    }

    // todo: header
    public CommentDTO createComment(Long id, String token, InputCommentDTO comment) {
        CommentEntity commentEntity = commentMapper.convertToCommentEntityFromDTO(comment);

        FilmEntity filmEntity = filmRepository.findById(id).orElse(null);
        commentEntity.setFilm(filmEntity);

        UserEntity userEntity = userRepository.findUserEntitiesByToken(token);
        commentEntity.setUser(userEntity);

        commentEntity.setDate(LocalDate.now());

        CommentEntity savedCommentEntity = commentRepository.save(commentEntity);
        return commentMapper.convertToCommentDTOFromEntity(savedCommentEntity);
    }
}
