CREATE TABLE `user_behavior_log`
(
    `user` VARCHAR,
    `url`  VARCHAR
)
WITH (
    'connector' = 'kafka',
    'topic' = 'user_behavior_log',
    'properties.bootstrap.servers' = 'localhost:9092',
    'properties.group.id' = 'testGroup',
    'format' = 'csv',
    'scan.startup.mode' = 'latest-offset'
)