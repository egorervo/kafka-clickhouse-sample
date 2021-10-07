package com.stripo.versions.helper;


import com.stripo.versions.helper.service.EventsProducer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        new EventsProducer().produceEvents();
        System.out.println("wasted %s ms".formatted(System.currentTimeMillis() - start));
    }

}
