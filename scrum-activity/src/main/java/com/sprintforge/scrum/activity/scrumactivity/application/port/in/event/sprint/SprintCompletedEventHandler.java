package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint;

public interface SprintCompletedEventHandler {
    void handle(SprintCompletedIntegrationEvent event);
}
