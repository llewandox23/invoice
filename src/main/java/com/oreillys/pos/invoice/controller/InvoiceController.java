package com.oreillys.pos.invoice.controller;

import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.payload.InvoiceData;
import com.oreillys.pos.invoice.payload.InvoiceDto;
import com.oreillys.pos.invoice.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/customer/tender/{id}")
    public Map<Long, String> getInvoicesForCustomer(@PathVariable(name = "id") long id) {
        return invoiceService.getInvoiceMapByCustomerId(id);
    }

    @GetMapping("/{id}")
    public InvoiceDto getInvoiceById(@PathVariable(name = "id") long id) {
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/customer/{id}")
    public List<Invoice> getInvoiceListByCustomerId(@PathVariable(name = "id") long customerId) {
        return invoiceService.getInvoiceListByCustomerId(customerId);
    }


}
