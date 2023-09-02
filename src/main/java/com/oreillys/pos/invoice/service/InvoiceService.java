package com.oreillys.pos.invoice.service;

import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.payload.InvoiceData;
import com.oreillys.pos.invoice.payload.InvoiceDto;

import java.util.List;
import java.util.Map;

public interface InvoiceService {
    Map<Long, String> getInvoiceMapByCustomerId(long customerId);

    Map<Long, String> getTenderTypeMapByCustomerId(long customerId);

    Map<Long, String> getTenderTypeMapForCustomerList(List<Long> customerIds);

    List<Invoice> getInvoiceListByCustomerId(long id);
    InvoiceDto getInvoiceById(long id);
}
