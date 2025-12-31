package com.sprintforge.scrum.activity.scrumactivity.application.port.out.persistence;

import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;

public interface SaveScrumActivity {
    void save(ScrumActivity event);
}
