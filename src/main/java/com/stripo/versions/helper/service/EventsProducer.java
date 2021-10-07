package com.stripo.versions.helper.service;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import static com.stripo.versions.helper.props.Props.TOPIC;

public class EventsProducer {

    public void produceEvents() {
        final KafkaProducer kafkaProducer = KafkaClient.createKafkaProducer();

        for (long i = 20000; i < 120000; i++) {
            final ProducerRecord record = new ProducerRecord<>(TOPIC, i + "",
                    new Gson().toJson(EventGenerator.generateEvent(i)));
            kafkaProducer.send(record);
        }
    }
}
