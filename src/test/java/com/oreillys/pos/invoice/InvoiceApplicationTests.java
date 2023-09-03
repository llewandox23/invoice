package com.oreillys.pos.invoice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.payload.TenderDetails;
import com.oreillys.pos.invoice.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class InvoiceApplicationTests {
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	InvoiceService invoiceService;

	@Test
	void contextLoads() {
	}
	// invoice 56 has type credit
	@Test
	public void testJsonToInvoice() throws JsonProcessingException {
		Invoice invoice = invoiceService.getInvoiceById(56);
		String invoiceData = invoice.getInvoiceData();
//		int tenderDetailsStart = invoiceData.indexOf("amount") - 2;
		String searchStr = "\"tenderDetails\": ";
		int tenderDetailsStart = invoiceData.indexOf(searchStr) + searchStr.length();
		String tenderDetails = invoiceData.substring(tenderDetailsStart);
		TenderDetails tenderDetailsObject = objectMapper.readValue(tenderDetails, TenderDetails.class);
		System.out.println("tender type "+ tenderDetailsObject.getType());
		assertEquals("credit", tenderDetailsObject.getType());
	}

	@Test
	public void testMapReturnedFromApiCall() {
		ParameterizedTypeReference<Map<Long,String>> responseType =
				new ParameterizedTypeReference<>() {};
		RestTemplate restTemplate = new RestTemplate();
		String resource = "http://localhost:8080/api/invoice/tendertype/customer/2";
		RequestEntity<Void> requestEntity = RequestEntity.get(resource).build();
		Map<Long, String> theMap = restTemplate.exchange(requestEntity, responseType).getBody();
		theMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
	}

}
