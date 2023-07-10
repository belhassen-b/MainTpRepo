package com.example.spring_tp_vendredi_07072023.service.impl;


import com.example.spring_tp_vendredi_07072023.Dto.LikeMentionDto;
import com.example.spring_tp_vendredi_07072023.entity.LikeMention;
import com.example.spring_tp_vendredi_07072023.exception.NotFoundException;
import com.example.spring_tp_vendredi_07072023.repository.ILikeRepository;
import com.example.spring_tp_vendredi_07072023.service.ILikeMentionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeMentionServiceImpl implements ILikeMentionService {

    private final ILikeRepository likeRepository;
    private final ModelMapper modelMapper;

    @Override
    public LikeMentionDto create(LikeMentionDto likeMentionDto) {
        LikeMention likeMention = modelMapper.map(likeMentionDto, LikeMention.class);
        return modelMapper.map(likeRepository.save(likeMention), LikeMentionDto.class);
    }

    @Override
    public LikeMentionDto update(Long id, LikeMentionDto dislikeMentionDto) {
        LikeMention likeMention1 = likeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("LikeMention not found")
        );
        likeMention1.setComment(dislikeMentionDto.getComment());
        likeMention1.setDate(dislikeMentionDto.getDate());
        return modelMapper.map(likeRepository.save(likeMention1), LikeMentionDto.class);
    }

    @Override
    public LikeMentionDto findById(Long id) {
        return modelMapper.map(likeRepository.findById(id).get(), LikeMentionDto.class);
    }

    @Override
    public LikeMentionDto deleteById(Long id) {
        LikeMention likeMention = likeRepository.findById(id).get();
        likeRepository.delete(likeMention);
        return modelMapper.map(likeRepository.save(likeMention), LikeMentionDto.class);
    }

    @Override
    public List<LikeMentionDto> findAll() {
        List<LikeMention> dislikeMentions = likeRepository.findAll();
        List<LikeMentionDto> list = new ArrayList<>();
        for (LikeMention dislikeMention : dislikeMentions) {
            LikeMentionDto map = modelMapper.map(dislikeMention, LikeMentionDto.class);
            list.add(map);
        }
        return list;
    }

}
