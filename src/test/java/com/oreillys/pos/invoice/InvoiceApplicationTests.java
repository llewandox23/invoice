package com.oreillys.pos.invoice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.payload.InvoiceData;
import com.oreillys.pos.invoice.payload.InvoiceDto;
import com.oreillys.pos.invoice.payload.TenderDetails;
import com.oreillys.pos.invoice.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		InvoiceDto invoice = invoiceService.getInvoiceById(56);
		String invoiceData = invoice.getInvoiceData();
//		int tenderDetailsStart = invoiceData.indexOf("amount") - 2;
		String searchStr = "\"tenderDetails\": ";
		int tenderDetailsStart = invoiceData.indexOf(searchStr) + searchStr.length();
		String tenderDetails = invoiceData.substring(tenderDetailsStart);
		TenderDetails tenderDetailsObject = objectMapper.readValue(tenderDetails, TenderDetails.class);
		System.out.println("tender type "+ tenderDetailsObject.getType());
		assertEquals("credit", tenderDetailsObject.getType());
	}

}
