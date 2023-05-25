package org.example.dao;

import org.example.model.Activity;

import java.util.List;

public interface ActivityDAO {

    boolean createActivityDAO(Activity activity);

    boolean updateActivityDAO(Activity activity);

    boolean deleteActivityDAO(Long id);

    Activity getActivityDAOById(Long id);

    List<Activity> getAllActivitiesDAO();

    void updateActivity(Activity activity);

    boolean addMemberToActivity(Long activityId, Long memberId);
}
