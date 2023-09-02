package com.oreillys.pos.invoice.payload;

import lombok.Data;
@Data
public class InvoiceDto {
    private long id;
    private long customerId;
    private String invoiceData;

}
