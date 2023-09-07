package com.vedha.stream.kafka.consumer;

import com.vedha.stream.kafka.entity.WikimediaStreamData;
import com.vedha.stream.kafka.repository.WikimediaStreamDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class WikimediaConsumer {

    private final WikimediaStreamDataRepository wikimediaStreamDataRepository;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeStreamDate(String message) {

        log.debug("Consumed WikiMedia Message : " + message);

        wikimediaStreamDataRepository.save(WikimediaStreamData.builder().data(message).build());
    }
}
