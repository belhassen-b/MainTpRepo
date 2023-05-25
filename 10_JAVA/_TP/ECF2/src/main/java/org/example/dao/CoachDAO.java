package org.example.dao;

import org.example.model.Coach;

import java.util.List;

public interface CoachDAO {

    boolean createCoachDAO(Coach coach);

    boolean updateCoachDAO(Coach coach);

    boolean deleteCoachDAO(Long id);

    Coach getCoachDAOById(Long id);

    List<Coach> getAllCoachesDAO();
    boolean getCoachDAOByActivity();


}
