CREATE TABLE `Sink`
(
    `user`  VARCHAR,
    `cTime` VARCHAR,
    `url`   VARCHAR
)
WITH (
    'connector' = 'kafka',
    'topic' = 'user_behavior_sink',
    'properties.bootstrap.servers' = 'localhost:9092',
    'format' = 'json'
)