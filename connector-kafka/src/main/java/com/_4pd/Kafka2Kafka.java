package com._4pd;

import org.apache.commons.io.FileUtils;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

import java.io.File;

public class Kafka2Kafka {
    public static void main(String[] args) throws Exception {
        env.setParallelism(1);
        env.enableCheckpointing(10 * 1000);
        String user_behavior_log = FileUtils.readFileToString(new File("connector-kafka/src/main/resources/kafka-source.sql"));
        String pv = FileUtils.readFileToString(new File("connector-kafka/src/main/resources/kafka-sink.sql"));
        tEnv.executeSql(user_behavior_log);
        tEnv.executeSql(pv);
//        tEnv.executeSql("insert into `pv` select `url`, count(`user`) from `user_behavior_log` group by `url`");
        tEnv.executeSql("insert into `pv` select `url`, 1 from `user_behavior_log`");
        env.execute("kafka2kafka");
    }

    private static final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    private static final EnvironmentSettings settings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
    private static final StreamTableEnvironment tEnv = StreamTableEnvironment.create(env, settings);
}
