package com.oreillys.pos.invoice.controller;

import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.payload.InvoiceData;
import com.oreillys.pos.invoice.payload.InvoiceDto;
import com.oreillys.pos.invoice.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping("/customer/tender/{id}")
    public Map<Long, String> getInvoicesForCustomer(@PathVariable(name = "id") long id) {
        return invoiceService.getInvoiceMapByCustomerId(id);
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable(name = "id") long id) {
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/customer/{id}")
    public List<Invoice> getInvoiceListByCustomerId(@PathVariable(name = "id") long customerId) {
        return invoiceService.getInvoiceListByCustomerId(customerId);
    }

    @GetMapping("/tendertype/customer/{id}")
    public Map<Long, String> getTypeMapByCustomerId(@PathVariable(name = "id") long customerId) {
        return invoiceService.getTenderTypeMapByCustomerId(customerId);
    }

    @PostMapping("/customers")
    public Map<Long, String> getTypeForListOfCustomers(@RequestBody List<Long> customerIds) {
        System.out.println("The List: " + customerIds);
        Map<Long, String> typeList = invoiceService.getTenderTypeMapForCustomerList(customerIds);
        return typeList;
    }

    @PostMapping("/insert")
    public Long insertInvoice(@RequestBody Invoice invoice) {
        return invoiceService.insertInvoice(invoice);
    }


}
