package com.egor.sample.kafka.service;

import com.egor.sample.kafka.props.Props;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KafkaClient {
    public static KafkaProducer createKafkaProducer() {
        final Properties properties = new Properties();
        properties.put("client.id", "test-client");
        properties.put("bootstrap.servers", Props.KAFKA_SERVER);
        properties.put("acks", "all");
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(properties);
    }
}
