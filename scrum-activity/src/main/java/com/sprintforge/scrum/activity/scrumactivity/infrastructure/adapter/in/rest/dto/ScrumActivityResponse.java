package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.rest.dto;

import java.time.Instant;
import java.util.UUID;

public record ScrumActivityResponse(
        UUID id,
        String eventType,
        String message,
        Instant occurredAt
) {
}
