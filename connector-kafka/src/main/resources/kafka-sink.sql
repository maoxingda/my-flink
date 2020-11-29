CREATE TABLE `pv`
(
    `url` VARCHAR,
    `cnt` BIGINT
)
WITH (
    'connector' = 'kafka',
    'topic' = 'pv',
    'properties.bootstrap.servers' = 'localhost:9092',
    'format' = 'csv'
)