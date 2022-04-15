package com.grup4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KafkaListeners {
    
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @KafkaListener(
        topics = "cipher-dekripsi",
        groupId = "groupId"
    )
    void enkriptorListener(String data){
        //panggil shuffle2Inverse
        String urlShuffle2Inverse = "http://localhost:8088/api/dekriptor/shuffle-2-inverse?json={data}";
        ResponseEntity<String> shuffle1InverseResponse = restTemplate.getForEntity(urlShuffle2Inverse, String.class, data);

        //panggil xor
        String urlXor = "http://localhost:8086/api/xor?json={shuffle1}";
        ResponseEntity<String> xorResponse = restTemplate.getForEntity(urlXor, String.class, shuffle1InverseResponse.getBody());

        //panggil shuffle1Inverse
        String urlShuffle1Inverse = "http://localhost:8087/api/dekriptor/shuffle-1-inverse?json={shuffle2}";
        ResponseEntity<String> shuffle2InverseResponse = restTemplate.getForEntity(urlShuffle1Inverse, String.class, xorResponse.getBody());

        kafkaTemplate.send("plain-dekripsi", shuffle2InverseResponse.getBody());
    }
}
