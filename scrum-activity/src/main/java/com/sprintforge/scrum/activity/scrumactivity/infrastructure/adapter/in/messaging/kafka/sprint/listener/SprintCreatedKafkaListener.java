package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCreatedEventHandler;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCreatedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event.SprintCreatedKafkaMessage;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.mapper.SprintCreatedKafkaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SprintCreatedKafkaListener {

    private final SprintCreatedEventHandler handler;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.sprintCreated}",
            groupId = "#{@kafkaGroupsProperties.defaultGroup}"
    )
    public void listen(String payload) {
        try {
            log.debug("Received SprintCreated raw payload: {}", payload);

            SprintCreatedKafkaMessage message =
                    objectMapper.readValue(payload, SprintCreatedKafkaMessage.class);

            log.debug("Parsed SprintCreated event: {}", message);

            SprintCreatedIntegrationEvent event = SprintCreatedKafkaMapper.toEvent(message);
            handler.handle(event);

        } catch (JsonProcessingException ex) {
            log.warn("Skipping invalid SprintCreated payload: {}", payload, ex);
        }
    }
}
