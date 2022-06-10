package com.kafka.kafkaperformance;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
class Processor {

    @Autowired
    public void process(StreamsBuilder builder) {

        final Serde<Integer> integerSerde = Serdes.Integer();
        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();

                builder.stream("topic3", Consumed.with(integerSerde, stringSerde))
                .to("topic4");

//        KStream<Integer, String> textLines = builder.stream("topic3", Consumed.with(integerSerde, stringSerde));
//
//        KTable<String, Long> wordCounts = textLines
//                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
//                .groupBy((key, value) -> value, Grouped.with(stringSerde, stringSerde))
//                .count();
//
//        wordCounts.toStream().to("topic4", Produced.with(stringSerde, longSerde));
    }
}
