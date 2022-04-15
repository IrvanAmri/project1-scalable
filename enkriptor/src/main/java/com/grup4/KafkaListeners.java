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
        topics = "plain-enkripsi",
        groupId = "groupId"
    )
    void enkriptorListener(String data){
        //panggil shuffle1
        String urlShuffle1 = "http://localhost:8084/api/enkriptor/shuffle-1?json={data}";
        ResponseEntity<String> shuffle1Response = restTemplate.getForEntity(urlShuffle1, String.class, data);

        //panggil xor
        String urlXor = "http://localhost:8086/api/xor?json={shuffle1}";
        ResponseEntity<String> xorResponse = restTemplate.getForEntity(urlXor, String.class, shuffle1Response.getBody());

        //panggil shuffle2
        String urlShuffle2 = "http://localhost:8085/api/enkriptor/shuffle-2?json={shuffle2}";
        ResponseEntity<String> shuffle2Response = restTemplate.getForEntity(urlShuffle2, String.class, xorResponse.getBody());

        kafkaTemplate.send("cipher-enkripsi", shuffle2Response.getBody());
    }
}
