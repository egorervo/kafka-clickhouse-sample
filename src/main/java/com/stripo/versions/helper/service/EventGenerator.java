package com.stripo.versions.helper.service;

import com.stripo.versions.helper.data.CustomEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class EventGenerator {

    public static CustomEvent generateEvent(Long id) {
        return CustomEvent.builder()
                .eventId(id)
                .organizationId(Long.valueOf(getRandomNumberInRange(0, 10000)))
                .userId(Long.valueOf(getRandomNumberInRange(0, 10000)))
                .projectId(Long.valueOf(getRandomNumberInRange(0, 10000)))
                .eventType("TEST_VETNT" + id)
                .time(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
