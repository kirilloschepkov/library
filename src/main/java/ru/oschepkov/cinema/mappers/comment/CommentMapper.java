package ru.oschepkov.cinema.mappers.comment;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.comment.CommentDTO;
import ru.oschepkov.cinema.dto.comment.InputCommentDTO;
import ru.oschepkov.cinema.entities.CommentEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CommentMapper {
    private final ModelMapper modelMapper;

    public CommentDTO convertToCommentDTOFromEntity(CommentEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CommentDTO.class);
    }

    public CommentEntity convertToCommentEntityFromDTO(InputCommentDTO dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, CommentEntity.class);
    }
}
