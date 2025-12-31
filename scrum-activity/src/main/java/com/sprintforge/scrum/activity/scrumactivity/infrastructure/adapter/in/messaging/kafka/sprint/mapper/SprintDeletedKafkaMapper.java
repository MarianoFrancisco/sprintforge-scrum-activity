package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.mapper;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintDeletedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event.SprintDeletedKafkaMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SprintDeletedKafkaMapper {
    public SprintDeletedIntegrationEvent toEvent(
            SprintDeletedKafkaMessage message
    ) {
        return new SprintDeletedIntegrationEvent(
                message.entityType(),
                message.eventType(),
                message.message(),
                message.occurredAt(),
                message.projectId(),
                message.sprintId()
        );
    }
}
