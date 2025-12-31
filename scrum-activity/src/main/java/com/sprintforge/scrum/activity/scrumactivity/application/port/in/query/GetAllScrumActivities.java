package com.sprintforge.scrum.activity.scrumactivity.application.port.in.query;

import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;

import java.util.List;

public interface GetAllScrumActivities {
    List<ScrumActivity> handle(GetAllScrumActivitiesQuery query);
}
