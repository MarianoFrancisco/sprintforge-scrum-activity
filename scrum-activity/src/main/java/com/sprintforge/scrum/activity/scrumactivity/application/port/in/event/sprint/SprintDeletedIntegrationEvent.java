package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint;

import java.time.Instant;
import java.util.UUID;

public record SprintDeletedIntegrationEvent(
        String entityType,
        String eventType,
        String message,
        Instant occurredAt,
        UUID projectId,
        UUID sprintId
) {
}
