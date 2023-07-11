package com.example.react_api.repository;

import com.example.react_api.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDepartementRepository extends JpaRepository<Departement, Long> {
}
