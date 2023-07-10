package com.example.spring_tp_vendredi_07072023.service.impl;


import com.example.spring_tp_vendredi_07072023.Dto.DislikeMentionDto;
import com.example.spring_tp_vendredi_07072023.entity.DislikeMention;
import com.example.spring_tp_vendredi_07072023.exception.NotFoundException;
import com.example.spring_tp_vendredi_07072023.repository.IDislikeRepository;
import com.example.spring_tp_vendredi_07072023.service.IDislikeMentionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DislikeMentionServiceImpl implements IDislikeMentionService {

    private final IDislikeRepository dislikeRepository;
    private final ModelMapper modelMapper;


    @Override
    public DislikeMentionDto create(DislikeMentionDto dislikeMentionDto) {
        DislikeMention dislikeMention = modelMapper.map(dislikeMentionDto, DislikeMention.class);
        return modelMapper.map(dislikeRepository.save(dislikeMention), DislikeMentionDto.class);
    }

    @Override
    public DislikeMentionDto update(Long id, DislikeMentionDto dislikeMentionDto) {
        DislikeMention dislikeMention1 = dislikeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("DislikeMention not found")
        );
        dislikeMention1.setComment(dislikeMentionDto.getComment());
        dislikeMention1.setDate(dislikeMentionDto.getDate());
        return modelMapper.map(dislikeRepository.save(dislikeMention1), DislikeMentionDto.class);
    }

    @Override
    public DislikeMentionDto findById(Long id) {
        return modelMapper.map(dislikeRepository.findById(id).get(), DislikeMentionDto.class);
    }

    @Override
    public DislikeMentionDto deleteById(Long id) {
        DislikeMention dislikeMention = dislikeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("DislikeMention not found")
        );
        dislikeRepository.delete(dislikeMention);
        return modelMapper.map(dislikeRepository.save(dislikeMention), DislikeMentionDto.class);
    }

    @Override
    public List<DislikeMentionDto> findAll() {
        List<DislikeMention> dislikeMentions = dislikeRepository.findAll();
        List<DislikeMentionDto> list = new ArrayList<>();
        for (DislikeMention dislikeMention : dislikeMentions) {
            DislikeMentionDto map = modelMapper.map(dislikeMention, DislikeMentionDto.class);
            list.add(map);
        }
        return list;
    }
}
