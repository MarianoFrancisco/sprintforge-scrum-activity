package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint;

public interface SprintStartedEventHandler {
    void handle(SprintStartedIntegrationEvent event);
}
