package com.sprintforge.scrum.activity.scrumactivity.domain;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Getter
public class ScrumActivity {

    private final UUID id;

    private final UUID projectId;
    private final UUID sprintId;
    private final UUID workItemId;

    private final EntityType entityType;
    private final String eventType;

    private final String message;

    private final Instant occurredAt;

    public ScrumActivity(
            UUID projectId,
            UUID sprintId,
            UUID workItemId,
            String entityType,
            String eventType,
            String message,
            Instant occurredAt
    ) {
        this.id = randomUUID();
        this.projectId = projectId;
        this.sprintId = sprintId;
        this.workItemId = workItemId;
        this.entityType = EntityType.valueOf(entityType);
        this.eventType = eventType;
        this.message = message;
        this.occurredAt = occurredAt;
    }

    public ScrumActivity(
            UUID id,
            UUID projectId,
            UUID sprintId,
            UUID workItemId,
            EntityType entityType,
            String eventType,
            String message,
            Instant occurredAt
    ) {
        this.id = id;
        this.projectId = projectId;
        this.sprintId = sprintId;
        this.workItemId = workItemId;
        this.entityType = entityType;
        this.eventType = eventType;
        this.message = message;
        this.occurredAt = occurredAt;
    }
}
