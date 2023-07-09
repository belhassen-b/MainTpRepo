package com.example.spring_tp_vendredi_07072023.repository;

import com.example.spring_tp_vendredi_07072023.entity.DislikeMention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDislikeRepository extends JpaRepository<DislikeMention, Long>{
}
