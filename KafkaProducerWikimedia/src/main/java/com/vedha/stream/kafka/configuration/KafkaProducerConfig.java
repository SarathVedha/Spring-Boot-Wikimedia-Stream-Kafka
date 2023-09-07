package com.vedha.stream.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.topic.name}")
    private String topicName;

    @Bean
    NewTopic initializeTopicVedhaStream() {

        return TopicBuilder.name(topicName).build();
    }
}
