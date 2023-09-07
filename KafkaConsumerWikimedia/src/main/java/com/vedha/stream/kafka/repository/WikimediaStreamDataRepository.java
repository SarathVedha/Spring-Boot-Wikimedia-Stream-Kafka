package com.vedha.stream.kafka.repository;

import com.vedha.stream.kafka.entity.WikimediaStreamData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaStreamDataRepository extends JpaRepository<WikimediaStreamData, Long> {
}
