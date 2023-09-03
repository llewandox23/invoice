package com.oreillys.pos.invoice;

import com.oreillys.pos.invoice.controller.InvoiceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestApiCallTests {

    @Autowired
    InvoiceController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:8080/api/invoice/",
                String.class)).contains("Hello World");
    }

    /**
     * This REST api call returns data from the H2 database
     */
    @Test
    public void testMapReturnedFromApiCall() {
        ParameterizedTypeReference<Map<Long,String>> responseType =
                new ParameterizedTypeReference<>() {};
        String resource = "http://localhost:8080/api/invoice/tendertype/customer/2";
        RequestEntity<Void> requestEntity = RequestEntity.get(resource).build();
        Map<Long, String> theMap = restTemplate.exchange(requestEntity, responseType).getBody();
        theMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
