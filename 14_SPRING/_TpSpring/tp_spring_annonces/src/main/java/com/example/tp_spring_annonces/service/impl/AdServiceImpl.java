package com.example.tp_spring_annonces.service.impl;


import com.example.tp_spring_annonces.entity.Ad;
import com.example.tp_spring_annonces.repository.AdRepository;
import com.example.tp_spring_annonces.service.IAdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements IAdService {

    private final AdRepository _adRepository;

    public AdServiceImpl(AdRepository adRepository) {
        _adRepository = adRepository;
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
