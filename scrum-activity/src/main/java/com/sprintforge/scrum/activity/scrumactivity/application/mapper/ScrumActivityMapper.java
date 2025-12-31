package com.sprintforge.scrum.activity.scrumactivity.application.mapper;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.project.ProjectCreatedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCreatedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintStartedIntegrationEvent;
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

    public ScrumActivity toDomain(SprintCreatedIntegrationEvent event) {
        if (event == null) {
            return null;
        }

        return new ScrumActivity(
                event.projectId(),
                event.sprintId(),
                null,
                event.entityType(),
                event.eventType(),
                event.message(),
                event.occurredAt()
        );
    }

    public ScrumActivity toDomain(SprintStartedIntegrationEvent event) {
        if (event == null) {
            return null;
        }

        return new ScrumActivity(
                event.projectId(),
                event.sprintId(),
                null,
                event.entityType(),
                event.eventType(),
                event.message(),
                event.occurredAt()
        );
    }
}
