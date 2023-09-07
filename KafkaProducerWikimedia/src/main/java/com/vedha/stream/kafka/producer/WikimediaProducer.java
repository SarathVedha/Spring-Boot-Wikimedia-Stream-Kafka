package com.vedha.stream.kafka.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.vedha.stream.kafka.handler.WikimediaStreamMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${kafka.stream.url}")
    private String wikiMediaStreamURL;

    public void sendMessage() throws InterruptedException {

        EventHandler eventHandler = new WikimediaStreamMessageHandler(kafkaTemplate, topicName);
        EventSource.Builder eventSource = new EventSource.Builder(eventHandler, URI.create(wikiMediaStreamURL));
        EventSource build = eventSource.build();
        build.start();

        TimeUnit.SECONDS.sleep(5);
    }
}
