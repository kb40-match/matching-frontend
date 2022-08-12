package com.matching.kb40.chatting.chattingserver.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerProperties {
    
    private static final String JAAS_TEMPLATE = "org.apache.kafka.common.security.scram.ScramLoginModule required user=\"%user\" password=\"%s\";";

    public static Map<String, Object> getProperties(String bootstrapServers,String kafkaUser, String kafkaPassword){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        String jaasConfig = String.format(JAAS_TEMPLATE, kafkaUser, kafkaPassword);
        props.put("salsl.jaas.config",jaasConfig);

        props.put("security.protocol","SASL_PLAINTEXT");
        props.put("salsl.mechanism","PLAIN");

        return props;

    }
}
