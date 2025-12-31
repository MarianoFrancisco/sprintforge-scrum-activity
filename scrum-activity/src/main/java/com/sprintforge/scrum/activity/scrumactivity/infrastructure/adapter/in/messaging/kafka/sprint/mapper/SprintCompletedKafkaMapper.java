package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.mapper;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCompletedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event.SprintCompletedKafkaMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SprintCompletedKafkaMapper {
    public SprintCompletedIntegrationEvent toEvent(
            SprintCompletedKafkaMessage message
    ) {
        return new SprintCompletedIntegrationEvent(
                message.entityType(),
                message.eventType(),
                message.message(),
                message.occurredAt(),
                message.projectId(),
                message.sprintId()
        );
    }
}
