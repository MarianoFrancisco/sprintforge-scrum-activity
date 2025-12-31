package com.sprintforge.scrum.activity.scrumactivity.application.mapper;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.project.ProjectCreatedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.domain.EntityType;
import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ScrumActivityMapper {
    public ScrumActivity toDomain(ProjectCreatedIntegrationEvent event) {
        if (event == null) {
            return null;
        }

        return new ScrumActivity(
                event.projectId(),
                null,
                null,
                event.entityType(),
                event.eventType(),
                event.message(),
                event.occurredAt()
        );
    }
}
