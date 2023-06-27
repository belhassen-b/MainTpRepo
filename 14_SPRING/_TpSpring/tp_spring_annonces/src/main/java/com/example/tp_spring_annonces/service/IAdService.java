package com.example.tp_spring_annonces.service;

import com.example.tp_spring_annonces.entity.Ad;

import java.util.Collection;
import java.util.List;

public interface IAdService {


    List<Ad> findAll();

    boolean save(Ad ad);
}
