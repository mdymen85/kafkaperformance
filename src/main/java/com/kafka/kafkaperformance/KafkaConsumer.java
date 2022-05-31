package com.kafka.kafkaperformance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    @Autowired
    @Qualifier("kafkaproperties")
    private Properties properties;
//
//    @KafkaListener(topics = "topic3", groupId = "foo3")
//    public void listenGroupFoo(String message) {
//
//        StreamsBuilder builder = new StreamsBuilder();
//
//        KStream<String, String> textLines = builder.stream("topic3");
//
//        Topology topology = builder.build();
//
//
//
//        Pattern pattern = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);
//
//        KTable<String, Long> wordCounts = textLines
//                .flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())))
//                .groupBy((key, word) -> word)
//                .count();
//
//        wordCounts.toStream()
//                .foreach((word, count) -> System.out.println("TESTEEEEEEEE: " + word + " -> " + count));
//
//        KafkaStreams streams = new KafkaStreams(topology, properties);
//        streams.start();
//        streams.close();
////        String outputTopic = "outputTopic";
////        wordCounts.toStream()
////                .to(outputTopic, Produced.with(Serdes.String(), Serdes.Long()));
//    }

}
