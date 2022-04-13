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
        topics = "plain-enkripsi",
        groupId = "groupId"
    )
    void enkriptorListener(String data){
        //panggil shuffle1
        String shuffle1Json="";

        //panggil xor
        String xorJson="";

        //panggil shuffle2
        String shuffle2Json="";

        kafkaTemplate.send("cipher-enkripsi", shuffle2Json);
    }
}
