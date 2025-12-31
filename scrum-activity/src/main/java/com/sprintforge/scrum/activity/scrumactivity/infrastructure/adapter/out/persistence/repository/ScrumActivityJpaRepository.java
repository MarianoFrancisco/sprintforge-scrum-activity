package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.repository;

import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.out.persistence.entity.ScrumActivityEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

@NullMarked
public interface ScrumActivityJpaRepository extends
        JpaRepository<ScrumActivityEntity, UUID>,
        JpaSpecificationExecutor<ScrumActivityEntity> {
}
