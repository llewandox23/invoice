package com.oreillys.pos.invoice;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

//public class RestApiCallTests {

//    @Test
//    public void testMapReturnedFromApiCall() {
//        ParameterizedTypeReference<Map<Long,String>> responseType =
//                new ParameterizedTypeReference<>() {};
//        RestTemplate restTemplate = new RestTemplate();
//        String resource = "http://localhost:8080/api/invoice/tendertype/customer/2";
//        RequestEntity<Void> requestEntity = RequestEntity.get(resource).build();
//        Map<Long, String> theMap = restTemplate.exchange(requestEntity, responseType).getBody();
//        theMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
//    }
//}
