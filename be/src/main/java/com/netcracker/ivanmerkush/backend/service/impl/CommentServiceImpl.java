package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.CommentEntity;
import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import com.netcracker.ivanmerkush.backend.model.CommentViewModel;
import com.netcracker.ivanmerkush.backend.repository.CommentRepository;
import com.netcracker.ivanmerkush.backend.repository.UserRepository;
import com.netcracker.ivanmerkush.backend.service.CommentService;
import com.netcracker.ivanmerkush.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<CommentViewModel> getCommentsForPost(Integer id) {
        List<CommentViewModel> response = new ArrayList<>();
        List<CommentEntity> comments = commentRepository.getCommentEntitiesByIdPost(id, Sort.by("dateTime").descending());
        comments.forEach(comment -> {
            UserEntity user = userRepository.getUserEntityByIdUser(comment.getIdAuthor());
            response.add(new CommentViewModel(user.getNickname(), user.getProfilePhoto(), comment.getIdComment(), comment.getText(), new Date(comment.getDateTime().getTime()), comment.getIdAuthor(), comment.getIdPost()));
        });
        return response;
    }

    @Override
    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
