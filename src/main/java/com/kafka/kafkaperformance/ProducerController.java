package com.kafka.kafkaperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @RequestMapping(value = "/v1/message", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MessageTestRecord> produce(@RequestBody MessageTestRecord message) {
        this.producerService.send(message);
        return ResponseEntity.ok(message);
    }

}
