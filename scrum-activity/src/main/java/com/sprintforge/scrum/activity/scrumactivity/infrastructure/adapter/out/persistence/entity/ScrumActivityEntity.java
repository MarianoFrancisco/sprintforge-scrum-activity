package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.entity;

import com.sprintforge.scrum.activity.scrumactivity.domain.EntityType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "scrum_activity")
public class ScrumActivityEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "project_id")
    private UUID projectId;

    @Column(name = "sprint_id")
    private UUID sprintId;

    @Column(name = "work_item_id")
    private UUID workItemId;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false, length = 30)
    private EntityType entityType;

    @Column(name = "event_type", nullable = false, length = 80)
    private String eventType;

    @Column(name = "message", nullable = false, length = 600)
    private String message;

    @Column(name = "occurred_at", nullable = false)
    private Instant occurredAt;
}
