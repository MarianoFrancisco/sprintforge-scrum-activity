package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.rest.mapper;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.query.GetAllScrumActivitiesQuery;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.rest.dto.ScrumActivityResponse;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class ScrumActivityRestMapper {
    public GetAllScrumActivitiesQuery toQuery(
            String entityType,
            UUID projectId,
            UUID sprintId,
            UUID workItemId
    ) {
        return new GetAllScrumActivitiesQuery(
                entityType,
                projectId,
                sprintId,
                workItemId
        );
    }

    public ScrumActivityResponse toResponse(
            com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity scrumActivity
    ) {
        return new ScrumActivityResponse(
                scrumActivity.getId(),
                scrumActivity.getEventType(),
                scrumActivity.getMessage(),
                scrumActivity.getOccurredAt()
        );
    }
}
