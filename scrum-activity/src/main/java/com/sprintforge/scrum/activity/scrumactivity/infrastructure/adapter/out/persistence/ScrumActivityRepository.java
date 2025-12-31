package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence;

import com.sprintforge.scrum.activity.scrumactivity.application.port.in.query.GetAllScrumActivitiesQuery;
import com.sprintforge.scrum.activity.scrumactivity.application.port.out.persistence.FindAllScrumActivities;
import com.sprintforge.scrum.activity.scrumactivity.application.port.out.persistence.SaveScrumActivity;
import com.sprintforge.scrum.activity.scrumactivity.domain.ScrumActivity;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.entity.ScrumActivityEntity;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.mapper.ScrumActivityEntityMapper;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.repository.ScrumActivityJpaRepository;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.specification.ScrumActivitySpecs;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@NullMarked
@Repository
@RequiredArgsConstructor
public class ScrumActivityRepository implements
        FindAllScrumActivities,
        SaveScrumActivity {

    private final ScrumActivityJpaRepository scrumActivityEventJpaRepository;

    @Override
    public List<ScrumActivity> findAll(GetAllScrumActivitiesQuery query) {
        Specification<ScrumActivityEntity> spec =
                ScrumActivitySpecs.withFilters(
                        query.entityType(),
                        query.projectId(),
                        query.sprintId(),
                        query.workItemId()
                );

        return scrumActivityEventJpaRepository.findAll(spec)
                .stream()
                .map(ScrumActivityEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void save(ScrumActivity event) {
        ScrumActivityEntity entity = ScrumActivityEntityMapper.toEntity(event);
        scrumActivityEventJpaRepository.save(entity);
    }
}
