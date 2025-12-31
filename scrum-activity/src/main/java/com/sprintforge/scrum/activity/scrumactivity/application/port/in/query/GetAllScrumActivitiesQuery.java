package com.sprintforge.scrum.activity.scrumactivity.application.port.in.query;

import java.util.UUID;

public record GetAllScrumActivitiesQuery(
        String entityType,
        UUID projectId,
        UUID sprintId,
        UUID workItemId
) {
}
