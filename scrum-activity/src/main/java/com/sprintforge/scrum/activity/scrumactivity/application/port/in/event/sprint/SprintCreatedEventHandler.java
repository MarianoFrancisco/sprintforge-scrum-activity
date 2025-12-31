package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint;

public interface SprintCreatedEventHandler {
    void handle(SprintCreatedIntegrationEvent event);
}
