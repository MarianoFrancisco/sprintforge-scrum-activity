package com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.project;

public interface ProjectCreatedEventHandler {
    void handle(ProjectCreatedIntegrationEvent event);
}
