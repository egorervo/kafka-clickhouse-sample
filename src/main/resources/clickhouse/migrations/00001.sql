CREATE TABLE custom_events
(
    event_id        Int64 Codec (DoubleDelta, LZ4),
    time            DateTime Codec (DoubleDelta, LZ4),
    user_id         Int64 Codec (DoubleDelta, LZ4),
    project_id      Int64 Codec (DoubleDelta, LZ4),
    organization_id Int64 Codec (DoubleDelta, LZ4)
) Engine = MergeTree
      PARTITION BY toYYYYMM(time)
      ORDER BY (event_id, time)
      PRIMARY KEY (event_id);


CREATE TABLE custom_events_queue
(
    event_id        Int64,
    time            DateTime,
    user_id         Int64,
    project_id      Int64,
    organization_id Int64
)
    ENGINE = Kafka
        SETTINGS kafka_broker_list = 'kafka:9092',
            kafka_topic_list = 'custom_events',
            kafka_group_name = 'custom_events_group1',
            kafka_format = 'JSONEachRow',
            kafka_max_block_size = 1048576;


CREATE MATERIALIZED VIEW custom_events_queue_mv TO custom_events AS
SELECT event_id, time, user_id, project_id, organization_id
FROM custom_events_queue;
