package com.vedha.stream.kafka.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wikimediaData")
public class WikimediaStreamData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Lob // Streaming data is too large so used lob for other db
    @Column(columnDefinition = "TEXT") // for postgres
    private String data;
}
