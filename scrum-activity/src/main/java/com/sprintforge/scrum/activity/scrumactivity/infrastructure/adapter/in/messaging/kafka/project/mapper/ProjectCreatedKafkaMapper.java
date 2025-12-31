package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.project.mapper;

import com.sprintforge.common.infrastructure.adapter.in.messaging.kafka.project.event.ProjectCreatedKafkaMessage;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.project.ProjectCreatedIntegrationEvent;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProjectCreatedKafkaMapper {
    public ProjectCreatedIntegrationEvent toEvent(
            ProjectCreatedKafkaMessage message
    ) {
        return new ProjectCreatedIntegrationEvent(
                message.entityType(),
                message.eventType(),
                message.message(),
                message.occurredAt(),
                message.projectId()
        );
    }
}
