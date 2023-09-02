package com.oreillys.pos.invoice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.payload.InvoiceData;
import com.oreillys.pos.invoice.payload.InvoiceDto;
import com.oreillys.pos.invoice.service.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootTest
class InvoiceApplicationTests {
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	InvoiceService invoiceService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testJsonToInvoice() throws JsonProcessingException {
		InvoiceDto invoice = invoiceService.getInvoiceById(54);
		System.out.println("invoiceDto invoiceData" + invoice.getInvoiceData());
		InvoiceData invoiceObject = objectMapper.readValue(invoice.getInvoiceData(), InvoiceData.class);
		System.out.println("tender type "+ invoiceObject.getStoreNumber());
	}

}
