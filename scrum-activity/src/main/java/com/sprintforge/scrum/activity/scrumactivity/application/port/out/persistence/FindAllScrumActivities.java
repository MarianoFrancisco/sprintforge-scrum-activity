package com.sprintforge.scrum.activity.scrumactivity.application.port.out.persistence;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.query.GetAllScrumActivitiesQuery;
import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;

import java.util.List;

public interface FindAllScrumActivities {
    List<ScrumActivity> findAll(GetAllScrumActivitiesQuery query);
}
