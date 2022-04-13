package com.grup4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @KafkaListener(
        topics = "cipher-dekripsi",
        groupId = "groupId"
    )
    void enkriptorListener(String data){
        //panggil shuffle2Invers

        //panggil xor

        //panggil shuffle1Invers
        String shuffle1InversJson="";

        kafkaTemplate.send("plain-dekripsi", shuffle1InversJson);
    }
}
