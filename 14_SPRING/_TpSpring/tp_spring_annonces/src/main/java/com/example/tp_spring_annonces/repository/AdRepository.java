package com.example.tp_spring_annonces.repository;

import com.example.tp_spring_annonces.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
}
