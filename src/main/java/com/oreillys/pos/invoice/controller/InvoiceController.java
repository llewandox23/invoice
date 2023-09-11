package com.oreillys.pos.invoice.controller;

import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.service.InvoiceService;
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

    /**
     * Just a simple GET test
     */
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello World";
    }

    /**
     *
     * @param customerId
     * @return a map with key: invoiceId and value: Invoice object
     */
    @GetMapping("/invoice/customer/{customerId}")
    public Map<Long, String> getInvoicesForCustomer(@PathVariable(name = "customerId") long customerId) {
        return invoiceService.getInvoiceMapByCustomerId(customerId);
    }

    /**
     *
     * @param invoiceId
     * @return the Invoice object for the given invoiceId
     */
    @GetMapping("/{invoiceId}")
    public Invoice getInvoiceById(@PathVariable(name = "invoiceId") long invoiceId) {
        return invoiceService.getInvoiceById(invoiceId);
    }

    /**
     *
     * @param customerId
     * @return A list of Invoice objects for a giver customerId
     */
    @GetMapping("/customer/{customerId}")
    public List<Invoice> getInvoiceListByCustomerId(@PathVariable(name = "customerId") long customerId) {
        return invoiceService.getInvoiceListByCustomerId(customerId);
    }

    /**
     *
     * @param customerId
     * @return a map with key: invoiceId and value: tenderType for a given customerId
     */
    @GetMapping("/tendertype/customer/{customerId}")
    public Map<Long, String> getTypeMapByCustomerId(@PathVariable(name = "customerId") long customerId) {
        return invoiceService.getTenderTypeMapByCustomerId(customerId);
    }

    /**
     *
     * @param customerIds a JSON list of customerIds
     * @return a map with key: invoiceId and value: tenderType for all the customers in the list
     */
    @PostMapping("/tendertype/customers")
    public Map<Long, String> getTypeForListOfCustomers(@RequestBody List<Long> customerIds) {
        System.out.println("The List: " + customerIds);
        Map<Long, String> typeList = invoiceService.getTenderTypeMapForCustomerList(customerIds);
        return typeList;
    }

    /**
     *
     * @param invoice -- Invoice object JSON formated for input
     * @return the invoiceId of the inserted invoice
     */
    @PostMapping("/insert")
    public Long insertInvoice(@RequestBody Invoice invoice) {
        return invoiceService.insertInvoice(invoice);
    }


}
