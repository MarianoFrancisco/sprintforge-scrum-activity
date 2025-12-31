package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.mapper;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintStartedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event.SprintStartedKafkaMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SprintStartedKafkaMapper {
    public SprintStartedIntegrationEvent toEvent(
            SprintStartedKafkaMessage message
    ) {
        return new SprintStartedIntegrationEvent(
                message.entityType(),
                message.eventType(),
                message.message(),
                message.occurredAt(),
                message.projectId(),
                message.sprintId()
        );
    }
}
