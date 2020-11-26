CREATE TABLE `Source`
(
    `user`  VARCHAR,
    `cTime` VARCHAR,
    `url`   VARCHAR
)
WITH (
    'connector' = 'kafka',
    'topic' = 'user_behavior_source',
    'properties.bootstrap.servers' = 'localhost:9092',
    'properties.group.id' = 'testGroup',
    'format' = 'json',
    'scan.startup.mode' = 'latest-offset'
)