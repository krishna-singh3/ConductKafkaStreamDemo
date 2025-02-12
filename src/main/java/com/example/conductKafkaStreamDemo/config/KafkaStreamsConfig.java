package com.example.conductKafkaStreamDemo.config;

import com.example.conductKafkaStreamDemo.service.MessageProcessor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfig {

  @Bean
  public KStream<String, String> kafkaStream(StreamsBuilder streamsBuilder) {
    // Create a stream from the "my-topic" topic
    KStream<String, String> stream = streamsBuilder.stream("my-topic", Consumed.with(Serdes.String(), Serdes.String()));

    // Process the stream: convert messages to uppercase
    stream.mapValues(MessageProcessor::toUpperCase)
        .peek((key, value) -> System.out.println("Processed message: " + value));

    return stream;
  }
}
