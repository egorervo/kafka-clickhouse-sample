package com.stripo.versions.helper.service;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

import static com.stripo.versions.helper.props.Props.KAFKA_SERVER;

public class KafkaClient {
    public static KafkaProducer createKafkaProducer() {
        final Properties properties = new Properties();
        properties.put("client.id", "test-client");
        properties.put("bootstrap.servers", KAFKA_SERVER);
        properties.put("acks", "all");
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(properties);
    }
}
