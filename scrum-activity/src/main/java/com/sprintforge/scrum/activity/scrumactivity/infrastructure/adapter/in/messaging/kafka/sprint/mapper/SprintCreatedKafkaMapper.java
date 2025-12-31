package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.mapper;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCreatedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event.SprintCreatedKafkaMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SprintCreatedKafkaMapper {
    public SprintCreatedIntegrationEvent toEvent(
            SprintCreatedKafkaMessage message
    ) {
        return new SprintCreatedIntegrationEvent(
                message.entityType(),
                message.eventType(),
                message.message(),
                message.occurredAt(),
                message.projectId(),
                message.sprintId()
        );
    }
}
