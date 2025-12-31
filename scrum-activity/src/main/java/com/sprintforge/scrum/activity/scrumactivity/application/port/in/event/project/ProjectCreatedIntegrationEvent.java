package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.project;

import java.time.Instant;
import java.util.UUID;

public record ProjectCreatedIntegrationEvent(
        String entityType,
        String eventType,
        String message,
        Instant occurredAt,
        UUID projectId
) {
}
