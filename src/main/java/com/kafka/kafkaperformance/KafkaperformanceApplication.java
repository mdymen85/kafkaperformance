package com.kafka.kafkaperformance;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
@Slf4j
public class KafkaperformanceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "HelloStreams");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,

				Serdes.Integer().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
				Serdes.String().getClass());

		StreamsBuilder builder = new StreamsBuilder();

		builder.stream("topic3")
				.to("topic4");
		//kStream.foreach((k, v) -> System.out.println("Key = " + k + " Value = " + v));

//		StreamsBuilder builder = new StreamsBuilder();
//		KStream<Integer, String> kStream = builder.stream("topic3");
//		kStream.foreach((k, v) -> System.out.println("Key = " + k + " Value = " + v));

		Topology topology = builder.build();

		KafkaStreams streams = new KafkaStreams(topology, props);
		log.info("Starting the stream");
		streams.start();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			log.info("Stopping Stream");
			streams.close();
		}));
	}

}
