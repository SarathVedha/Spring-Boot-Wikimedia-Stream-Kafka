package com.vedha.stream.kafka;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "WikiMedia Data Stream Consumer App", summary = "Kafka", description = "WikiMedia Data Stream App Using Kafka"))
public class KafkaConsumerWikimediaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerWikimediaApplication.class, args);
    }
}