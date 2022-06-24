package com.kafka.kafkaperformance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Value("${topic.name:topic3}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<Long, String> kafkaTemplate1;
	
	public void send(MessageTestRecord messageTestRecord) {

		kafkaTemplate.send(topic, messageTestRecord.getMessage());

	}
	
}
