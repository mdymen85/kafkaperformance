package com.kafka.kafkaperformance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaStream {

    @PostConstruct
    public void kafkaStreamsStart() {
    //    this.kafkaStreams();
    }

//    @Autowired
//    public void kafkaStreams() {
//        Properties props = new Properties();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "HelloStreams");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//
//        StreamsBuilder builder = new StreamsBuilder();
//
//        builder.stream("topic3")
//                .to("topic4");
//
//        Topology topology = builder.build();
//
//        KafkaStreams streams = new KafkaStreams(topology, props);
//        log.info("Starting the stream");
//        streams.start();
//
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            log.info("Stopping Stream");
//            streams.close();
//        }));
//    }

}
