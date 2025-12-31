CREATE TABLE scrum_activity
(
    id           UUID PRIMARY KEY,
    project_id   UUID NULL,
    sprint_id    UUID NULL,
    work_item_id UUID NULL,
    entity_type  VARCHAR(30)  NOT NULL
        CHECK (entity_type IN ('PROJECT', 'SPRINT', 'WORK_ITEM', 'BOARD_COLUMN')),
    event_type   VARCHAR(80)  NOT NULL,
    message      VARCHAR(600) NOT NULL,
    occurred_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
