package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.specification;

import com.sprintforge.scrum.activity.scrumactivity.domain.EntityType;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.entity.ScrumActivityEntity;
import jakarta.validation.constraints.NotNull;
import lombok.experimental.UtilityClass;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

@NullMarked
@UtilityClass
public class ScrumActivitySpecs {

    public Specification<ScrumActivityEntity> hasProject(UUID projectId) {
        return (root, ignored, cb) -> cb.equal(root.get("projectId"), projectId);
    }

    public Specification<ScrumActivityEntity> hasSprint(UUID sprintId) {
        return (root, ignored, cb) -> cb.equal(root.get("sprintId"), sprintId);
    }

    public Specification<ScrumActivityEntity> hasWorkItem(UUID workItemId) {
        return (root, ignored, cb) -> cb.equal(root.get("workItemId"), workItemId);
    }

    public Specification<ScrumActivityEntity> hasEntityType(@NotNull String entityType) {
        EntityType type = EntityType.valueOf(entityType.toUpperCase());

        return (root, ignored, cb) ->
                cb.equal(root.get("entityType"), type);
    }

    public Specification<ScrumActivityEntity> withFilters(
            @NotNull String entityType,
            @Nullable UUID projectId,
            @Nullable UUID sprintId,
            @Nullable UUID workItemId
    ) {
        Specification<ScrumActivityEntity> spec =
                (ignoredRoot, ignoredQuery, cb) -> cb.conjunction();

        spec = spec.and(hasEntityType(entityType));
        if (projectId != null) spec = spec.and(hasProject(projectId));
        if (sprintId != null) spec = spec.and(hasSprint(sprintId));
        if (workItemId != null) spec = spec.and(hasWorkItem(workItemId));

        return spec;
    }
}
