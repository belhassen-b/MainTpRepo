package com.example.tp_spring_annonces.service;

import com.example.tp_spring_annonces.entity.Ad;
import com.example.tp_spring_annonces.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface IAdService {


    List<Ad> findAll();

    boolean save(Ad ad);

    boolean save(String title, String content, double price, List<Category> category, List<MultipartFile> picture);
}
