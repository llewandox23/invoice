package com.oreillys.pos.invoice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @GetMapping("/customer/{id}")
    public ResponseEntity<Map<Long, String>> getInvoicesForCustomer(@PathVariable(name = "id") long id) {
        Map<Long, String> theMap = new HashMap<>();
        theMap.put(123L, "Hello");
        return new ResponseEntity<>(theMap, HttpStatus.OK);
    }


}
