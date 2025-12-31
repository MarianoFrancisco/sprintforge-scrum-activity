package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint;

public interface SprintDeletedEventHandler {
    void handle(SprintDeletedIntegrationEvent event);
}
