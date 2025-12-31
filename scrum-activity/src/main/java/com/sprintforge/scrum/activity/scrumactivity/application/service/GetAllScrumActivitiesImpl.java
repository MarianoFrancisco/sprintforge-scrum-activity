package com.sprintforge.scrum.activity.scrumactivity.application.service;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.query.GetAllScrumActivities;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.query.GetAllScrumActivitiesQuery;
import com.sprintforge.scrum.activity.scrumactivity.application.port.out.persistence.FindAllScrumActivities;
import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class GetAllScrumActivitiesImpl implements GetAllScrumActivities {

    private final FindAllScrumActivities findAllScrumActivities;

    @Override
    public List<ScrumActivity> handle(GetAllScrumActivitiesQuery query) {
        return findAllScrumActivities.findAll(query);
    }
}
