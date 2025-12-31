package com.sprintforge.scrum.activity.scrumactivity.application.service.event;

import com.sprintforge.scrum.activity.scrumactivity.application.mapper.ScrumActivityMapper;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCreatedEventHandler;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCreatedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.application.port.out.persistence.SaveScrumActivity;
import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class SprintCreatedEventHandlerImpl implements SprintCreatedEventHandler {

    private final SaveScrumActivity saveScrumActivityEvent;

    @Override
    public void handle(SprintCreatedIntegrationEvent event) {
        ScrumActivity scrumActivity = ScrumActivityMapper.toDomain(event);
        saveScrumActivityEvent.save(scrumActivity);
    }
}
