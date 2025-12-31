package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintDeletedEventHandler;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintDeletedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event.SprintDeletedKafkaMessage;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.mapper.SprintDeletedKafkaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SprintDeletedKafkaListener {

    private final SprintDeletedEventHandler handler;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.sprintDeleted}",
            groupId = "#{@kafkaGroupsProperties.defaultGroup}"
    )
    public void listen(String payload) {
        try {
            log.debug("Received SprintDeleted raw payload: {}", payload);

            SprintDeletedKafkaMessage message =
                    objectMapper.readValue(payload, SprintDeletedKafkaMessage.class);

            log.debug("Parsed SprintDeleted event: {}", message);

            SprintDeletedIntegrationEvent event = SprintDeletedKafkaMapper.toEvent(message);
            handler.handle(event);

        } catch (JsonProcessingException ex) {
            log.warn("Skipping invalid SprintDeleted payload: {}", payload, ex);
        }
    }
}
