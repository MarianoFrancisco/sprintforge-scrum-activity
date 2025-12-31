package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event;

import java.time.Instant;
import java.util.UUID;

public record SprintCreatedKafkaMessage(
        String entityType,
        String eventType,
        String message,
        Instant occurredAt,
        UUID projectId,
        UUID sprintId
) {
}
