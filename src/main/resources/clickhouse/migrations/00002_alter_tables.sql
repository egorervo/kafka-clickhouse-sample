DETACH TABLE custom_events_queue;

ALTER TABLE custom_events ADD COLUMN event_type String;
CREATE TABLE custom_events_queue_v2
(
    event_id        Int64,
    time            DateTime,
    user_id         Int64,
    project_id      Int64,
    organization_id Int64,
    event_type String
)
    ENGINE = Kafka
        SETTINGS kafka_broker_list = 'kafka:9092',
            kafka_topic_list = 'custom_events',
            kafka_group_name = 'custom_events_group1',
            kafka_format = 'JSONEachRow',
            kafka_max_block_size = 1048576;

DROP TABLE custom_events_queue_mv;

CREATE MATERIALIZED VIEW custom_events_queue_mv TO custom_events AS
SELECT event_id, time, user_id, project_id, organization_id, event_type
FROM custom_events_queue_v2;





