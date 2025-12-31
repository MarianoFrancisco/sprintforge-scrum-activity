package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCreatedIntegrationEvent;

public interface SprintCreatedEventHandler {
    void handle(SprintCreatedIntegrationEvent event);
}
