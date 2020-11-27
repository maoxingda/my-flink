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
        String source = FileUtils.readFileToString(new File("connector-kafka/src/main/resources/kafka-source.sql"));
        String sink = FileUtils.readFileToString(new File("connector-kafka/src/main/resources/kafka-sink.sql"));
        tEnv.executeSql(source);
        tEnv.executeSql(sink);
        tEnv.executeSql("insert into Sink select * from Source");
        env.execute("kafka2kafka");
    }

    private static final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    private static final EnvironmentSettings settings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
    private static final StreamTableEnvironment tEnv = StreamTableEnvironment.create(env, settings);
}
