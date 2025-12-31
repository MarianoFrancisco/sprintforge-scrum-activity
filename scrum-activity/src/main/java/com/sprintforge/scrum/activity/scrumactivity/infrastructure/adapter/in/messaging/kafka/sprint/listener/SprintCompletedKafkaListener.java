package com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCompletedEventHandler;
import com.sprintforge.scrum.activity.scrumactivity.application.port.in.event.sprint.SprintCompletedIntegrationEvent;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.event.SprintCompletedKafkaMessage;
import com.sprintforge.scrum.activity.scrumactivity.infrastructure.adapter.in.messaging.kafka.sprint.mapper.SprintCompletedKafkaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SprintCompletedKafkaListener {

    private final SprintCompletedEventHandler handler;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.sprintCompleted}",
            groupId = "#{@kafkaGroupsProperties.defaultGroup}"
    )
    public void listen(String payload) {
        try {
            log.debug("Received SprintCompleted raw payload: {}", payload);

            SprintCompletedKafkaMessage message =
                    objectMapper.readValue(payload, SprintCompletedKafkaMessage.class);

            log.debug("Parsed SprintCompleted event: {}", message);

            SprintCompletedIntegrationEvent event = SprintCompletedKafkaMapper.toEvent(message);
            handler.handle(event);

        } catch (JsonProcessingException ex) {
            log.warn("Skipping invalid SprintCompleted payload: {}", payload, ex);
        }
    }
}
