package com.vedha.stream.kafka.controller;

import com.vedha.stream.kafka.producer.WikimediaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/stream")
@AllArgsConstructor
public class KafkaController {

    private final WikimediaProducer wikimediaProducer;

    @GetMapping("v1/wikiMedia/start")
    public ResponseEntity<String> startWikimediaStream() throws InterruptedException {

        wikimediaProducer.sendMessage();

        return ResponseEntity.ok("Started Successfully");
    }

}
