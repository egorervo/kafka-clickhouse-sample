package com.egor.sample.kafka.service;

import com.egor.sample.kafka.props.Props;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class EventsProducer {

    public void produceEvents() {
        final KafkaProducer kafkaProducer = KafkaClient.createKafkaProducer();

        for (long i = 20000; i < 120000; i++) {
            final ProducerRecord record = new ProducerRecord<>(Props.TOPIC, i + "",
                    new Gson().toJson(EventGenerator.generateEvent(i)));
            kafkaProducer.send(record);
        }
    }
}
