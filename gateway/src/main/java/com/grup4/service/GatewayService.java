package com.grup4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GatewayService {

    //komunikasi tools
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    
    //asinkronus tools
    private static boolean kontrolEnkripsi;
    private static boolean kontrolDekripsi;

    //keluaran enkripsi path
    private static String cipherSaver;
    //keluaran dekripsi path
    private static String plainSaver;

    public static boolean isKontrolEnkripsi() {
        return kontrolEnkripsi;
    }
    public static void setKontrolEnkripsi(boolean kontrolEnkripsi) {
        GatewayService.kontrolEnkripsi = kontrolEnkripsi;
    }
    public static boolean isKontrolDekripsi() {
        return kontrolDekripsi;
    }
    public static void setKontrolDekripsi(boolean kontrolDekripsi) {
        GatewayService.kontrolDekripsi = kontrolDekripsi;
    }
    public static String getCipherSaver() {
        return cipherSaver;
    }
    public static void setCipherSaver(String cipherSaver) {
        GatewayService.cipherSaver = cipherSaver;
    }
    public static String getPlainSaver() {
        return plainSaver;
    }
    public static void setPlainSaver(String plainSaver) {
        GatewayService.plainSaver = plainSaver;
    }

    //helper section
    public String stringToBlocks(String plain){
        String url = "http://localhost:8082/api/blocks?plain={plain}";
        ResponseEntity<String> blocksResponse = restTemplate.getForEntity(url, String.class, plain);
        return blocksResponse.getBody();
    }

    public String blocksToString(String blocks){
        String url = "http://localhost:8083/api/text?json={blocks}";
        ResponseEntity<String> textResponse = restTemplate.getForEntity(url, String.class, blocks);
        return textResponse.getBody();
    }
    //helper section

    //enkripsi section
    public void enkripsiService(String plain){
        kafkaTemplate.send("plain-enkripsi", stringToBlocks(plain));
    }

    @KafkaListener(
        topics = "cipher-enkripsi",
        groupId = "groupId1"
    )
    private void enkriptorListener(String data){
        cipherSaver = data;
        kontrolEnkripsi = true;
    }
    //enkripsi section

    //dekripsi section
    //dekripsi section
}
