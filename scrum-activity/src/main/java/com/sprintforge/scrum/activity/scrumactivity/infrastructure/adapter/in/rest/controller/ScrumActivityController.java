package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.rest.controller;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.query.GetAllScrumActivities;
import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.rest.dto.ScrumActivityResponse;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.rest.mapper.ScrumActivityRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/scrum-activity")
public class ScrumActivityController {

    private final GetAllScrumActivities getAllScrumActivities;

    @GetMapping
    public List<ScrumActivityResponse> getAll(
            @RequestParam String entityType,
            @RequestParam(required = false) UUID projectId,
            @RequestParam(required = false) UUID sprintId,
            @RequestParam(required = false) UUID workItemId
    ) {
        List<ScrumActivity> scrumActivities = getAllScrumActivities.handle(
                ScrumActivityRestMapper.toQuery(
                        entityType,
                        projectId,
                        sprintId,
                        workItemId
                )
        );
        return scrumActivities.stream()
                .map(ScrumActivityRestMapper::toResponse)
                .toList();
    }
}
