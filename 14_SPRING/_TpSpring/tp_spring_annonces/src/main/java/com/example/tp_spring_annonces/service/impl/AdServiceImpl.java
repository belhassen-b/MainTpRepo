package com.example.tp_spring_annonces.service.impl;


import com.example.tp_spring_annonces.entity.Ad;
import com.example.tp_spring_annonces.repository.AdRepository;
import com.example.tp_spring_annonces.repository.CategoryRepository;
import com.example.tp_spring_annonces.repository.PictureRepository;
import com.example.tp_spring_annonces.service.IAdService;
import com.example.tp_spring_annonces.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements IAdService {


    @Autowired

    private  AdRepository _adRepository;
    @Autowired

    private  PictureRepository _pictureRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private IUploadService _uploadService;

    public AdServiceImpl(AdRepository adRepository, PictureRepository pictureRepository) {
        _adRepository = adRepository;
        _pictureRepository = pictureRepository;
    }

    @Override
    public List<Ad> findAll() {
        return _adRepository.findAll();
    }

    @Override
    public boolean save(Ad ad) {
        _adRepository.save(ad);
        return ad.getId() > 0;
    }
}
