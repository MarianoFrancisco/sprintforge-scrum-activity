package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.mapper;

import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.entity.ScrumActivityEntity;
import lombok.experimental.UtilityClass;
import org.jspecify.annotations.NullMarked;

@NullMarked
@UtilityClass
public class ScrumActivityEntityMapper {

    public ScrumActivity toDomain(ScrumActivityEntity entity) {
        return new ScrumActivity(
                entity.getId(),
                entity.getProjectId(),
                entity.getSprintId(),
                entity.getWorkItemId(),
                entity.getEntityType(),
                entity.getEventType(),
                entity.getMessage(),
                entity.getOccurredAt()
        );
    }

    public ScrumActivityEntity toEntity(ScrumActivity domain) {
        return ScrumActivityEntity.builder()
                .id(domain.getId())
                .projectId(domain.getProjectId())
                .sprintId(domain.getSprintId())
                .workItemId(domain.getWorkItemId())
                .entityType(domain.getEntityType())
                .eventType(domain.getEventType())
                .message(domain.getMessage())
                .occurredAt(domain.getOccurredAt())
                .build();
    }
}
